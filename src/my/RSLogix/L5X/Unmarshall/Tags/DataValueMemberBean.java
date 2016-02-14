package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DataValueMember")
public class DataValueMemberBean implements Serializable
{
	private static final long serialVersionUID = 7277586726875780982L;

	private String Name = "";
	private String DataType = "";
	private String Radix = "";
	private String Value;
	
	public DataValueMemberBean() { super(); }
	
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

	public String getRadix() {
		return Radix;
	}

	@XmlAttribute(name = "Radix")
	public void setRadix(String radix) {
		Radix = radix;
	}

	public String getValue() {
		return Value;
	}

	@XmlAttribute(name = "Value")
	public void setValue(String value) {
		Value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<DataValueMember ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("DataType='").append(this.DataType).append("' ");
		str.append("Radix='").append(this.Radix).append("' ");
		str.append("Value='").append(this.Value).append("'/>\r\n");
		
		return str.toString();
	}
}
