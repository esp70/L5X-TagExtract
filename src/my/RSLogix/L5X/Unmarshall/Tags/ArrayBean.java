package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Array")
public class ArrayBean implements Serializable
{
	private static final long serialVersionUID = 606901376898438873L;

	private String DataType;
	private String Dimensions;
	private String Radix;
	private List<ElementBean> Element;
	
	public ArrayBean() { super(); }

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
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<ArrayMember ");
		str.append("DataType='").append(this.DataType).append("' ");
		str.append("Dimensions='").append(this.Dimensions).append("' ");
		str.append("Radix='").append(this.Radix).append("'>\r\n");
		for (ElementBean i : Element)
			str.append(i.toString());
		str.append("</Array>\r\n");
		
		return str.toString();
	}
}
