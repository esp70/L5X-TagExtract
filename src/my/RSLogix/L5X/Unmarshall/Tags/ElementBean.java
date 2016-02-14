package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Element")
public class ElementBean implements Serializable
{
	private static final long serialVersionUID = 1198262840490474169L;

	private String Index;
	private String Value;
	private StructureBean Structure;
	
	public ElementBean() { super(); }

	public String getIndex() {
		return Index;
	}

	@XmlAttribute(name = "Index")
	public void setIndex(String index) {
		Index = index;
	}

	public String getValue() {
		return Value;
	}

	@XmlAttribute(name = "Value")
	public void setValue(String value) {
		Value = value;
	}
	
	public StructureBean getStructure() {
		return Structure;
	}

	@XmlElement(name = "Structure")
	public void setStructure(StructureBean structure) {
		Structure = structure;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Element ");
		str.append("Index='").append(this.Index).append("' ");
		str.append("Value='").append(this.Value).append("'/>\r\n");
		if (Structure!=null)
			str.append(Structure.toString());
		
		return str.toString();
	}
}
