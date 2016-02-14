package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Tag")
public class TagBean implements Serializable
{
	private static final long serialVersionUID = 1222334476918285398L;

	private String Name = "";
	private String TagType = "";
	private String DataType = "";
	private String Radix = "";
	private String AliasFor = "";// Only if it is an Alias Type tag
	private String Constant = "";// Only if it is a Base type tag and numeric (i.e. not a timer or counter)
	private String ExternalAccess = "";
	private String Dimensions = "0";// Only used for an Array
	private DataBean Data;
	
	public TagBean() { super(); }

	public String getName() {
		return Name;
	}

	@XmlAttribute(name = "Name")
	public void setName(String name) {
		Name = name;
	}
	
	public String getTagType() {
		return TagType;
	}

	@XmlAttribute(name = "TagType")
	public void setTagType(String tagType) {
		TagType = tagType;
	}

	public String getDataType() {
		return DataType;
	}

	@XmlAttribute(name = "DataType")
	public void setDataType(String dataType) {
		DataType = dataType;
	}

	public String getRadix() {
		return Radix;
	}

	@XmlAttribute(name = "Radix")
	public void setRadix(String radix) {
		Radix = radix;
	}

	public String getExternalAccess() {
		return ExternalAccess;
	}

	@XmlAttribute(name = "ExternalAccess")
	public void setExternalAccess(String externalAccess) {
		ExternalAccess = externalAccess;
	}

	public String getAliasFor() {
		return AliasFor;
	}

	@XmlAttribute(name = "AliasFor")
	public void setAliasFor(String aliasFor) {
		AliasFor = aliasFor;
	}

	public String getConstant() {
		return Constant;
	}

	@XmlAttribute(name = "Constant")
	public void setConstant(String constant) {
		Constant = constant;
	}
	
	/**
	 * If the Dimension is greater than 0 then it is an array</br>
	 * This is the only attribute to inform the system that this tag is an array
	 * 
	 * @return
	 */
	public String getDimensions() {
		return Dimensions;
	}

	@XmlAttribute(name = "Dimensions")
	public void setDimensions(String dimensions) {
		Dimensions = dimensions;
	}

	public DataBean getData() {
		return Data;
	}

	@XmlElement(name = "Data")
	public void setData(DataBean data) {
		Data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Show the bean and 'TRY' to ignore attributes that are not affiliated with the Tag type</BR>
	 * The data will be <code>null</code> if the tag does not use the attribute 
	 * 
	 */
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Tag ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("TagType='").append(this.TagType).append("' ");
		/* Alias Tag */
		if (TagType.equalsIgnoreCase("Alias"))
			str.append("AliasFor='").append(this.AliasFor).append("' ");
		else
			str.append("DataType='").append(this.DataType).append("' ");
		/* Numeric base */
		if (TagType.equalsIgnoreCase("Base") && (DataType.equalsIgnoreCase("DINT") || DataType.equalsIgnoreCase("REAL") || DataType.equalsIgnoreCase("BOOL")))
			str.append("Radix='").append(this.Radix).append("' ");
		/* Could be more but other than an Alias and Message tag */
		if (!TagType.equalsIgnoreCase("Alias") && !DataType.equalsIgnoreCase("MESSAGE"))
			str.append("Constant='").append(this.Constant).append("' ");
		/* we will show the dimension even though it may not be an array */
		str.append("Dimensions='").append(this.Dimensions).append("' ");
		str.append("ExternalAccess='").append(this.ExternalAccess).append("'>\r\n");
		
		/* Not all tags have Data */
		if (Data != null)
			str.append(this.Data.toString());
		
		return str.toString();
	}
}
