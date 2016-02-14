package my.RSLogix.L5X.Unmarshall.DataTypes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Member")
public class MemberBean implements Serializable
{
	private static final long serialVersionUID = -7658159801536160288L;

	private String Name;
	private String DataType;
	private String Dimension;
	private String Radix;
	private String Hidden;
	private String Target;
	private String BitNumber;
	private String ExternalAccess;
	
	public MemberBean() { super(); }

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

	public String getDimension() {
		return Dimension;
	}

	@XmlAttribute(name = "Dimension")
	public void setDimension(String dimension) {
		Dimension = dimension;
	}

	public String getRadix() {
		return Radix;
	}

	@XmlAttribute(name = "Radix")
	public void setRadix(String radix) {
		Radix = radix;
	}

	public String getHidden() {
		return Hidden;
	}

	@XmlAttribute(name = "Hidden")
	public void setHidden(String hidden) {
		Hidden = hidden;
	}

	public String getTarget() {
		return Target;
	}
	
	@XmlAttribute(name = "Target")
	public void setTarget(String target) {
		Target = target;
	}

	public String getBitNumber() {
		return BitNumber;
	}

	@XmlAttribute(name = "BitNumber")
	public void setBitNumber(String bitNumber) {
		BitNumber = bitNumber;
	}

	public String getExternalAccess() {
		return ExternalAccess;
	}

	@XmlAttribute(name = "ExternalAccess")
	public void setExternalAccess(String externalAccess) {
		ExternalAccess = externalAccess;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Member ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("DataType='").append(this.DataType).append("' ");
		str.append("Dimension='").append(this.Dimension).append("' ");
		str.append("Radix='").append(this.Radix).append("' ");
		str.append("Hidden='").append(this.Hidden).append("' ");
		str.append("Target='").append(this.Target).append("' ");
		str.append("BitNumber='").append(this.BitNumber).append("' ");
		str.append("ExternalAccess='").append(this.ExternalAccess).append("/>\r\n");
		
		return str.toString();
	}
}
