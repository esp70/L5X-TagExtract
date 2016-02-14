package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DataValue")
public class DataValueBean implements Serializable
{
	private static final long serialVersionUID = -4381769084420467678L;
	
	private String DataType;
	private String Radix;
	private String Value;
	
	public DataValueBean() { super(); }

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
		str.append("<DataValue ");
		str.append("DataType='").append(this.DataType).append("' ");
		str.append("Radix='").append(this.Radix).append("' ");
		str.append("Value='").append(this.Value).append("'/>\r\n");
		
		return str.toString();
	}
}
