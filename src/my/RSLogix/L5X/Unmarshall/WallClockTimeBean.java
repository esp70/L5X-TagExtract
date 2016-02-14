package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WallClockTime")
public class WallClockTimeBean implements Serializable
{
	private static final long serialVersionUID = 2492492776556082675L;
	
	private String LocalTimeAdjustment;
	private String TimeZone;
	
	public WallClockTimeBean() { super(); }

	public String getLocalTimeAdjustment() {
		return LocalTimeAdjustment;
	}

	@XmlAttribute(name = "LocalTimeAdjustment")
	public void setLocalTimeAdjustment(String localTimeAdjustment) {
		LocalTimeAdjustment = localTimeAdjustment;
	}

	public String getTimeZone() {
		return TimeZone;
	}
	
	@XmlAttribute(name = "TimeZone")
	public void setTimeZone(String timeZone) {
		TimeZone = timeZone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<WallClockTime ");
		str.append("LocalTimeAdjustment='").append(this.LocalTimeAdjustment).append("' ");
		str.append("TimeZone='").append(this.TimeZone).append("'/>");
		
		return str.toString();
	}
}
