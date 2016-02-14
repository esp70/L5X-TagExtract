package my.RSLogix.L5X.Unmarshall.DataTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DataType")
public class DataTypeBean implements Serializable
{
	private static final long serialVersionUID = 3389348177175827402L;

	private String Name;
	private String Family;
	private String Clazz;
	@XmlElementWrapper(name = "Members")
	@XmlElement(name = "Member")
	private List<MemberBean> Member = new ArrayList<MemberBean>();
	
	public DataTypeBean() { super(); }

	public String getName() {
		return Name;
	}

	@XmlAttribute(name = "Name")
	public void setName(String name) {
		Name = name;
	}

	public String getFamily() {
		return Family;
	}

	@XmlAttribute(name = "Family")
	public void setFamily(String family) {
		Family = family;
	}

	public String getClazz() {
		return Clazz;
	}

	@XmlAttribute(name = "Class")
	public void setClazz(String clazz) {
		Clazz = clazz;
	}

	public List<MemberBean> getMember() {
		return Member;
	}

	@XmlElement(name = "Member")
	public void setMember(List<MemberBean> member) {
		Member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<DataType ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("Family='").append(this.Family).append("' ");
		str.append("Class='").append(this.Clazz).append("/>\r\n");
		for (MemberBean i : Member)
			str.append(i.toString());
		
		return str.toString();
	}
}
