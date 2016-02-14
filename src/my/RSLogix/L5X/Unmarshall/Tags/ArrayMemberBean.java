package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArrayMember")
public class ArrayMemberBean implements Serializable
{
	private static final long serialVersionUID = -8861008773848139435L;
	
	private String Name;
	private String DataType;
	private String Dimensions;
	private String Radix;
	private List<ElementBean> Element;

	/* When we have an array of a structure, we need to maintain what the root tag is */
	private String tagPathBuildHolder = "";
	
	public ArrayMemberBean() { super(); }

	public String getName() {
		return Name;
	}

	@XmlAttribute(name = "Name")
	public void setName(String name) {
		Name = name;
	}

	public String getDataType() {
		return DataType;
	}

	@XmlAttribute(name = "DataType")
	public void setDataType(String dataType) {
		DataType = dataType;
	}

	public String getDimensions() {
		return Dimensions;
	}

	@XmlAttribute(name = "Dimensions")
	public void setDimensions(String dimensions) {
		Dimensions = dimensions;
	}

	public String getRadix() {
		return Radix;
	}

	@XmlAttribute(name = "Radix")
	public void setRadix(String radix) {
		Radix = radix;
	}

	public List<ElementBean> getElement() {
		return Element;
	}

	@XmlElement(name="Element")
	public void setElement(List<ElementBean> element) {
		Element = element;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTagPathBuildHolder() {
		return tagPathBuildHolder;
	}

	public void setTagPathBuildHolder(String tagPathBuildHolder) {
		this.tagPathBuildHolder = tagPathBuildHolder;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<ArrayMember ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("DataType='").append(this.DataType).append("' ");
		str.append("Dimensions='").append(this.Dimensions).append("' ");
		str.append("Radix='").append(this.Radix).append("/>\r\n");
		if (Element!=null)
			for (ElementBean i : Element)
				str.append(i.toString());
		str.append("</ArrayMember>\r\n");
		
		return str.toString();
	}
}
