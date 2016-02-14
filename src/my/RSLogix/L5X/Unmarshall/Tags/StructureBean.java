package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Structure")
public class StructureBean implements Serializable
{
	private static final long serialVersionUID = -5595967261801557021L;

	private String DataType;
	private List<StructureMemberBean> StructureMember;
	private List<ArrayMemberBean> ArrayMember;
	private List<DataValueMemberBean> DataValueMember;
	
	public StructureBean() { super(); }

	public String getDataType() {
		return DataType;
	}

	@XmlAttribute(name = "DataType")
	public void setDataType(String dataType) {
		DataType = dataType;
	}

	public List<StructureMemberBean> getStructureMember() {
		return StructureMember;
	}

	@XmlElement(name = "StructureMember")
	public void setStructureMember(List<StructureMemberBean> structureMember) {
		StructureMember = structureMember;
	}

	public List<DataValueMemberBean> getDataValueMember() {
		return DataValueMember;
	}

	@XmlElement(name = "DataValueMember")
	public void setDataValueMember(List<DataValueMemberBean> dataValueMember) {
		DataValueMember = dataValueMember;
	}

	public List<ArrayMemberBean> getArrayMember() {
		return ArrayMember;
	}

	@XmlElement(name = "ArrayMember")
	public void setArrayMember(List<ArrayMemberBean> arrayMember) {
		ArrayMember = arrayMember;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Structure ");
		str.append("DataType='").append(this.DataType).append("'>\r\n");
		for (StructureMemberBean i : this.StructureMember)
			str.append(i.toString());
		for (ArrayMemberBean i : this.ArrayMember)
			str.append(i.toString());
		for (DataValueMemberBean i : this.DataValueMember)
			str.append(i.toString());
		
		return str.toString();
	}
}
