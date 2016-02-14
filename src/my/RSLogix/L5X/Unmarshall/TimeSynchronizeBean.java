package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TimeSynchronize")
public class TimeSynchronizeBean implements Serializable
{
	private static final long serialVersionUID = 7100414836172301391L;
	
	private String Priority1;
	private String Priority2;
	private String PTPEnable;

	public TimeSynchronizeBean() { super(); }

	public String getPriority1() {
		return Priority1;
	}
	
	@XmlAttribute(name = "Priority1")
	public void setPriority1(String priority1) {
		Priority1 = priority1;
	}

	public String getPriority2() {
		return Priority2;
	}

	@XmlAttribute(name = "Priority2")
	public void setPriority2(String priority2) {
		Priority2 = priority2;
	}

	public String getPTPEnable() {
		return PTPEnable;
	}

	@XmlAttribute(name = "PTPEnable")
	public void setPTPEnable(String pTPEnable) {
		PTPEnable = pTPEnable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<TimeSynchronize ");
		str.append("Priority1='").append(this.Priority1).append("' ");
		str.append("Priority2='").append(this.Priority2).append("' ");
		str.append("PTPEnable='").append(this.PTPEnable).append("'/>");
		
		return str.toString();
	}
}
