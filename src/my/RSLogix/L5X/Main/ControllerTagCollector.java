package my.RSLogix.L5X.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;

import my.RSLogix.L5X.TagBeans.ControllerBaseTagBean;
import my.RSLogix.L5X.Unmarshall.ControllerBean;
import my.RSLogix.L5X.Unmarshall.L5KBean;
import my.RSLogix.L5X.Unmarshall.DataTypes.DataTypeBean;
import my.RSLogix.L5X.Unmarshall.Tags.ArrayMemberBean;
import my.RSLogix.L5X.Unmarshall.Tags.DataValueMemberBean;
import my.RSLogix.L5X.Unmarshall.Tags.ElementBean;
import my.RSLogix.L5X.Unmarshall.Tags.StructureBean;
import my.RSLogix.L5X.Unmarshall.Tags.StructureMemberBean;
import my.RSLogix.L5X.Unmarshall.Tags.TagBean;



/**
 * Class to handle the .L5X tag Extraction</br>
 * Pass the .L5X file path and access the Tag list with <code>getTagList()</code>
 * 
 */
public class ControllerTagCollector
{
	private String filePath;
	private L5KBean l5kBean;
	
	/* Needed to handle Structured tags */
	private String rootDataType;
	private String tagType;
	private String constant;
	private String externalAccess;
	private final StringBuilder str = new StringBuilder();

	/* Tag list */
	private final List<ControllerBaseTagBean> controllerBaseTagBeans = new ArrayList<ControllerBaseTagBean>(1000);
	
	
	/**
	 * Construct the Class with the file path</br>
	 * Call <code>unmarshall()</code> to unmarshall the .L5X file and populate the tags
	 * 
	 * @param filePath
	 */
	public ControllerTagCollector(String filePath)
	{
		super();
		this.filePath = filePath;
	}
	

	/**
	 * Unmarshall the .L5X file and populate the tag list</br>
	 * access the Tag list with <code>getTagList()</code>
	 * 
	 * @throws Exception
	 */
	public void unmarshall() throws Exception
	{
		l5kBean = (L5KBean) JAXBContext.newInstance(L5KBean.class).createUnmarshaller().unmarshal(new File(filePath));
		evaluateTags(l5kBean.getController().getTags());
	}
	
	
	/**
	 * Evaluate the tags and construct the fully qualified names</br>
	 * Once Constructed, the tag will be added to the tag list
	 * 
	 * @param tagBeanList
	 */
	private void evaluateTags(List<TagBean> tagBeanList)
	{
		for (final TagBean i : tagBeanList)
		{
			if (testForStandardTag(i))
				constructAndAddStandardTag(i);
			
			else if (testForArrayTag(i))
				constructAndAddArrayTag(i);
			
			else if (testForStructuredTag(i))
				constructAndAddStructuredTag(i);
		}
	}
	
	
	/**
	 * Test for a controller standard tag (Not Complex)</br>
	 * i.e. BOOL, DINT, INT, SINT, REAL
	 * 
	 * @param tagBean
	 * @return
	 */
	private boolean testForStandardTag(TagBean tagBean)
	{
		return (tagBean.getTagType().equalsIgnoreCase("Base") &&
				tagBean.getData().getStructure()==null &&
				tagBean.getData().getArray()==null &&
				tagBean.getData().getMessage()==null &&
				tagBean.getData().getDataValue()!=null &&
				tagBean.getDimensions().equals("0"));
	}
	
	
	/**
	 * Construct and add the standard tag to the list
	 * 
	 * @param tagBean
	 */
	private void constructAndAddStandardTag(TagBean tagBean)
	{
		/* Clear from the last method call */
		clearTagName();
		
		/* The Controller Base Standard Tag already has a fully qualified name */
		appendToTag(tagBean.getName(), false);
		
		/* Add the tag to the Bean list */
		controllerBaseTagBeans.add(new ControllerBaseTagBean(this.getFullyQualifiedTagName(),
															 tagBean.getDataType(),
															 tagBean.getAliasFor(),
															 tagBean.getTagType(),
															 tagBean.getDataType(),
															 tagBean.getRadix(),
															 tagBean.getConstant(),
															 tagBean.getExternalAccess()));
	}
	
	
	/**
	 * Test for Controller Array
	 * 
	 * @param tagBean
	 * @return
	 */
	private boolean testForArrayTag(TagBean tagBean)
	{
		return (tagBean.getTagType().equalsIgnoreCase("Base") &&
				tagBean.getData().getArray()!=null &&
				!tagBean.getDimensions().equals("0"));
	}
	
	
	/**
	 * Construct and add the Array tag to the list
	 * 
	 * @param tagBean
	 */
	private void constructAndAddArrayTag(TagBean tagBean)
	{
		/* Build all the fully qualified names from the array structure */
		for (ElementBean i : tagBean.getData().getArray().getElement())
		{
			clearTagName();
			appendToTag(tagBean.getName(), false);
			appendToTag(i.getIndex(), false);
			
			/* Add the tag to the Bean list */
			controllerBaseTagBeans.add(new ControllerBaseTagBean(this.getFullyQualifiedTagName(),
																 tagBean.getData().getArray().getDataType(),
																 tagBean.getAliasFor(),
																 tagBean.getTagType(),
																 tagBean.getData().getArray().getDataType(),
																 tagBean.getData().getArray().getRadix(),
																 tagBean.getConstant(),
																 tagBean.getExternalAccess()));
		}
	}
	
	
	/**
	 * Test for a structured tag (Complex)</br>
	 * i.e. TIMER, COUNTER, User Data Type, ex.
	 * 
	 * @param tagBean
	 * @return
	 */
	private boolean testForStructuredTag(TagBean tagBean)
	{
		return (tagBean.getTagType().equalsIgnoreCase("Base") &&
				tagBean.getData().getStructure()!=null &&
				tagBean.getDimensions().equals("0"));
	}
	
	
	/**
	 * Construct and add the Structured tag to the list
	 * @param tagBean
	 */
	private void constructAndAddStructuredTag(TagBean tagBean)
	{
		this.clearTagName();
		this.appendToTag(tagBean.getName(), false);
		rootDataType = tagBean.getDataType();
		tagType = tagBean.getTagType();
		constant = tagBean.getConstant();
		externalAccess = tagBean.getExternalAccess();
		
		/* Build the fully qualified structure and add it to the structure lists */
		buildTagFromStructure(tagBean.getData().getStructure(), tagBean);
	}
	
	
	/**
	 * Build the fully qualified tag name and data type from the structure
	 * 
	 * @param structureBean
	 * @return
	 */
	public void buildTagFromStructure(StructureBean structureBean, TagBean tagBean)
	{
		/* Drill down to the final member */
		if (structureBean.getStructureMember()!=null)
			for (StructureMemberBean i : structureBean.getStructureMember())
				extractStructureMember(i, tagBean);
		
		if (structureBean.getArrayMember()!=null)
			for (ArrayMemberBean i : structureBean.getArrayMember())
				extractArrayMemberStructure(i, tagBean);
		
		if (structureBean.getDataValueMember()!=null)
			for (DataValueMemberBean i : structureBean.getDataValueMember())
				extractDataValueMemberStructure(i, tagBean);
	}
	
	
	/**
	 * Complex Structure members to extract
	 * 
	 * @param structureMemberBean
	 */
	private void extractStructureMember(StructureMemberBean structureMemberBean, TagBean tagBean)
	{
		this.appendToTag(structureMemberBean.getName(), true);
		
		if (structureMemberBean.getArrayMember()!=null)
			for (ArrayMemberBean i : structureMemberBean.getArrayMember())
				extractArrayMemberStructure(i, tagBean);

		if (structureMemberBean.getDataValueMember()!=null)
			for (DataValueMemberBean i : structureMemberBean.getDataValueMember())
				extractDataValueMemberStructure(i, tagBean);

		if (structureMemberBean.getStructureMember()!=null)
			for (StructureMemberBean i : structureMemberBean.getStructureMember())
				extractStructureMember(i, tagBean);
		
		/* Clean the last tag name append for the next update */
		this.deleteLastaddition();
	}	
	
	
	/**
	 * Array Members have Elements to extract
	 * 
	 * @param arrayMemberBean
	 */
	private void extractArrayMemberStructure(ArrayMemberBean arrayMemberBean, TagBean tagBean)
	{
		/* Iterate thru the list to extract the fully qualified tag */
		for (ElementBean e : arrayMemberBean.getElement())
		{
			this.appendToTag(arrayMemberBean.getName(), true);
			this.appendToTag(e.getIndex(), false);
			
			/* We have a structured array to handle */
			if (e.getStructure()!=null)
				buildTagFromStructure(e.getStructure(), tagBean);
			
			/* We have a final tag to add to the list */
			else
				controllerBaseTagBeans.add(new ControllerBaseTagBean(this.getFullyQualifiedTagName(),
																	 rootDataType,
																	 tagBean.getAliasFor(),
																	 arrayMemberBean.getDataType(),
																	 tagType,
																	 arrayMemberBean.getRadix(),
																	 constant,
																	 externalAccess));
			/* Clean the last tag name append for the next update */
			this.deleteLastaddition();
		}
	}
	
	
	/**
	 * Data Value Members
	 * 
	 * @param dataValueMemberBean
	 */
	private void extractDataValueMemberStructure(DataValueMemberBean dataValueMemberBean, TagBean tagBean)
	{
		this.appendToTag(dataValueMemberBean.getName(), true);
		/* Add the tag to the list */
		controllerBaseTagBeans.add(new ControllerBaseTagBean(this.getFullyQualifiedTagName(),
															 rootDataType,
															 tagBean.getAliasFor(),
															 dataValueMemberBean.getDataType(),
															 tagType,
															 dataValueMemberBean.getRadix(),
															 constant,
															 externalAccess));
		
		/* Clean the last tag name append for the next update */
		this.deleteLastaddition();
	}
	
	
	/**
	 * All Tags will have a tag Name
	 * 
	 * @return
	 */
	private String getFullyQualifiedTagName()
	{
		return str.toString();
	}
	
	
	/**
	 * Fully Qualified tags may have several appends based on the complexity of the structure</br>
	 * This method will be used to append to the tag.</br>
	 * 
	 * @param tag
	 * @param usesDot array constructs do not use the '.' to separate the appends
	 */
	private void appendToTag(String tag, boolean usesDot)
	{
		if (usesDot && str.length() > 0)
			str.append(".");
		str.append(tag);
	}
	
	
	/**
	 * Clear the String Builder
	 * 
	 */
	private void clearTagName()
	{
		if (str.length() > 0)
			str.delete(0, str.length());
	}
	
	
	/**
	 * When iterating structures we may need to take out the last addition
	 * 
	 */
	private void deleteLastaddition()
	{
		final String s = str.toString();
		clearTagName();
		
		String[] ss = s.split("\\.");
		for (int i=0;i<(ss.length-1);i++)
			appendToTag(ss[i], true);
	}
	
	public List<ControllerBaseTagBean> getTagList()
	{
		return controllerBaseTagBeans;
	}
	
	/**
	 * Get a list by Tag Data Type
	 * 
	 * @param dataType
	 * @return
	 */
	public List<ControllerBaseTagBean> getTagDataTypeList(String dataType)
	{
		final List<ControllerBaseTagBean> dataTypeList = new ArrayList<ControllerBaseTagBean>();
		
		for (ControllerBaseTagBean i : controllerBaseTagBeans)
			if (i.getDataType().equalsIgnoreCase(dataType))
				dataTypeList.add(i);
		
		return dataTypeList;
	}
	
	
	/**
	 * Get a list by Tag Root Data Type
	 * 
	 * @param dataType
	 * @return
	 */
	public List<ControllerBaseTagBean> getTagRootDataTypeList(String dataType)
	{
		final List<ControllerBaseTagBean> dataTypeList = new ArrayList<ControllerBaseTagBean>();
		
		for (ControllerBaseTagBean i : controllerBaseTagBeans)
			if (i.getRootDataType().equalsIgnoreCase(dataType))
				dataTypeList.add(i);
		
		return dataTypeList;
	}
	
	
	/**
	 * Get all Tags associated with the root name
	 * 
	 * @param tagName
	 * @return
	 */
	public List<ControllerBaseTagBean> getTagByNameList(String tagName)
	{
		final List<ControllerBaseTagBean> dataTypeList = new ArrayList<ControllerBaseTagBean>();
		
		for (ControllerBaseTagBean i : controllerBaseTagBeans)
			if (i.getTagName().contains(tagName))
				dataTypeList.add(i);
		
		return dataTypeList;
	}

	/**
	 * Pass the list to print the tags
	 * 
	 * @param tagList
	 * @return
	 */
	public String listToString(List<ControllerBaseTagBean> tagList)
	{
		final StringBuilder str = new StringBuilder();
		
		for (ControllerBaseTagBean i : tagList)
			str.append(i.toString());
		
		return str.toString();
	}
	
	
	/**
	 * Get the print of all the tags
	 * 
	 */
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		
		for (ControllerBaseTagBean i : controllerBaseTagBeans)
			str.append(i.toString());
		
		return str.toString();
	}
	
	
	/**
	 * Get the controller details
	 * 
	 * @return
	 */
	public ControllerBean getControllerDetails()
	{
		return l5kBean.getController();
	}
	
	
	/**
	 * Get the list of user data types
	 * 
	 * @return
	 */
	public List<DataTypeBean> getUserDataTypes()
	{
		return l5kBean.getController().getDataType();
	}
	
	
	/**
	 * Get a print of the Data Type List
	 * 
	 * @return
	 */
	public String getUserDataTypesToString()
	{
		final StringBuilder str = new StringBuilder();
		
		for (DataTypeBean i : l5kBean.getController().getDataType())
			str.append(i.toString());
		
		return str.toString();
	}
}
