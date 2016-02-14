package my.RSLogix.L5X.TagBeans;

import java.io.Serializable;

/**
 * The base Abstract Class for all tags
 *
 */
public abstract class GenericTagBean implements Serializable
{
	private static final long serialVersionUID = 958015635057417087L;

	private String tagName = "";
	private String rootDataType = "";
	private String aliasFor = "";
	private String dataType = "";
	private String tagType = "";
	private String radix = "";
	private String constant = "";
	private String externalAccess = "";
	
	public GenericTagBean() { super(); }
	
	/**
	 * Constructor
	 * 
	 * @param tagName
	 * @param rootDataType
	 * @param aliasFor
	 * @param dataType
	 * @param tagType
	 * @param radix
	 * @param constant
	 * @param externalAccess
	 */
	public GenericTagBean(String tagName, String rootDataType,
			String aliasFor, String dataType, String tagType, String radix,
			String constant, String externalAccess)
	{
		super();
		this.tagName = tagName;
		this.rootDataType = rootDataType;
		this.aliasFor = aliasFor;
		this.dataType = dataType;
		this.tagType = tagType;
		this.radix = radix;
		this.constant = constant;
		this.externalAccess = externalAccess;
	}

	/**
	 * Tag <code>toString()</code> override for a clean print of the tag data
	 */
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Tag Name='").append(tagName).append("' ");
		str.append("RootDataType='").append(rootDataType).append("' ");
		str.append("AliasFor='").append(aliasFor).append("' ");
		str.append("TagDataType='").append(dataType).append("' ");
		str.append("TagType='").append(tagType).append("' ");
		str.append("Radix='").append(radix).append("' ");
		str.append("Constant='").append(constant).append("' ");
		str.append("ExternalAccess='").append(externalAccess).append("'>\r\n");
		
		return str.toString();
	}
	
	/* Getters and Setters for public access */
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getRootDataType() {
		return rootDataType;
	}
	public void setRootDataType(String rootDataType) {
		this.rootDataType = rootDataType;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getRadix() {
		return radix;
	}
	public void setRadix(String radix) {
		this.radix = radix;
	}
	public String getConstant() {
		return constant;
	}
	public void setConstant(String constant) {
		this.constant = constant;
	}
	public String getExternalAccess() {
		return externalAccess;
	}
	public void setExternalAccess(String externalAccess) {
		this.externalAccess = externalAccess;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
