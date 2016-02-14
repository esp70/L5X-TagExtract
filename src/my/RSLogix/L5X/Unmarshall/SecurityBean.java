package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Security")
public class SecurityBean implements Serializable
{
	private static final long serialVersionUID = 6434505204593483903L;
	
	private String Code;
	
	public SecurityBean() { super(); }

	public String getCode() {
		return Code;
	}
	
	@XmlAttribute(name = "Code")
	public void setCode(String code) {
		Code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Security ");
		str.append("Code='").append(this.Code).append("'/>");
		
		return str.toString();
	}
}
