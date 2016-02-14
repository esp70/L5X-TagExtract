package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CST")
public class CSTBean implements Serializable
{
	private static final long serialVersionUID = 9110362171293115902L;
	
	private String MasterID;
	
	public CSTBean() { super(); }

	public String getMasterID() {
		return MasterID;
	}
	
	@XmlAttribute(name = "MasterID")
	public void setMasterID(String masterID) {
		MasterID = masterID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<CST ");
		str.append("MasterID='").append(this.MasterID).append("'/>");
		
		return str.toString();
	}
}
