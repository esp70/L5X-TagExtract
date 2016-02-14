package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RedundancyInfo")
public class RedundencyInfoBean implements Serializable
{
	private static final long serialVersionUID = 4124162668089818616L;
	
	private String Enabled;
	private String KeepTestEditsOnSwitchOver;
	private String IOMemoryPadPercentage;
	private String DataTablePadPercentage;
	
	public RedundencyInfoBean() { super(); }

	public String getEnabled() {
		return Enabled;
	}

	@XmlAttribute(name = "Enabled")
	public void setEnabled(String enabled) {
		Enabled = enabled;
	}

	public String getKeepTestEditsOnSwitchOver() {
		return KeepTestEditsOnSwitchOver;
	}

	@XmlAttribute(name = "KeepTestEditsOnSwitchOver")
	public void setKeepTestEditsOnSwitchOver(String keepTestEditsOnSwitchOver) {
		KeepTestEditsOnSwitchOver = keepTestEditsOnSwitchOver;
	}

	public String getIOMemoryPadPercentage() {
		return IOMemoryPadPercentage;
	}

	@XmlAttribute(name = "IOMemoryPadPercentage")
	public void setIOMemoryPadPercentage(String iOMemoryPadPercentage) {
		IOMemoryPadPercentage = iOMemoryPadPercentage;
	}

	public String getDataTablePadPercentage() {
		return DataTablePadPercentage;
	}
	
	@XmlAttribute(name = "DataTablePadPercentage")
	public void setDataTablePadPercentage(String dataTablePadPercentage) {
		DataTablePadPercentage = dataTablePadPercentage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<RedundancyInfo ");
		str.append("Enabled='").append(this.Enabled).append(" ");
		str.append("KeepTestEditsOnSwitchOver='").append(this.KeepTestEditsOnSwitchOver).append("' ");
		str.append("IOMemoryPadPercentage='").append(this.IOMemoryPadPercentage).append("' ");
		str.append("DataTablePadPercentage='").append(this.DataTablePadPercentage).append("'/>");
		
		return str.toString();
	}
}
