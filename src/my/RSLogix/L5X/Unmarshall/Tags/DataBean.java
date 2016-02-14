package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Data")
public class DataBean implements Serializable
{
	private static final long serialVersionUID = -8628280488036966261L;

	private String Format;
	private DataValueBean DataValue;
	private StructureBean Structure;
	private MessageBean Message;
	private ArrayBean Array;
	
	public DataBean() { super(); }

	public String getFormat() {
		return Format;
	}

	@XmlAttribute(name = "Format")
	public void setFormat(String format) {
		Format = format;
	}

	public DataValueBean getDataValue() {
		return DataValue;
	}

	@XmlElement(name = "DataValue")
	public void setDataValue(DataValueBean dataValue) {
		DataValue = dataValue;
	}

	public StructureBean getStructure() {
		return Structure;
	}

	@XmlElement(name = "Structure")
	public void setStructure(StructureBean structure) {
		Structure = structure;
	}

	public ArrayBean getArray() {
		return Array;
	}

	@XmlElement(name = "Array")
	public void setArray(ArrayBean array) {
		Array = array;
	}

	public MessageBean getMessage() {
		return Message;
	}

	@XmlElement(name = "MessageParameters")
	public void setMessage(MessageBean message) {
		Message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Data ");
		str.append("Format='").append(this.Format).append("'/>\r\n");
		
		if (DataValue!=null)
			str.append(DataValue.toString());
		
		if (Structure!=null)
			str.append(Structure.toString());
		
		if (Array!=null)
			str.append(Array.toString());
		
		if (Message!=null)
			str.append(Message.toString());
		
		return str.toString();
	}
}
