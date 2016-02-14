package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "StructureMember")
public class StructureMemberBean implements Serializable
{
	private static final long serialVersionUID = 7229911297708084467L;

	private String Name;
	private String DataType;
	private List<ArrayMemberBean> ArrayMember;
	private List<DataValueMemberBean> DataValueMember;
	private List<StructureMemberBean> StructureMember;
	
	public StructureMemberBean() { super(); }

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

	public List<ArrayMemberBean> getArrayMember() {
		return ArrayMember;
	}

	@XmlElement(name = "ArrayMember")
	public void setArrayMember(List<ArrayMemberBean> arrayMember) {
		ArrayMember = arrayMember;
	}

	public List<DataValueMemberBean> getDataValueMember() {
		return DataValueMember;
	}

	@XmlElement(name = "DataValueMember")
	public void setDataValueMember(List<DataValueMemberBean> dataValueMember) {
		DataValueMember = dataValueMember;
	}

	public List<StructureMemberBean> getStructureMember() {
		return StructureMember;
	}

	@XmlElement(name = "StructureMember")
	public void setStructureMember(List<StructureMemberBean> structureMember) {
		StructureMember = structureMember;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<StructureMember ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("DataType='").append(this.DataType).append("'>\r\n");
		if (this.StructureMember!=null)
			for (StructureMemberBean i : this.StructureMember)
				str.append(i.toString());
		if (this.ArrayMember!=null)
			for (ArrayMemberBean i : this.ArrayMember)
				str.append(i.toString());
		if (this.DataValueMember!=null)
			for (DataValueMemberBean i : this.DataValueMember)
				str.append(i.toString());
		
		return str.toString();
	}
}
