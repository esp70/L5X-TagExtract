package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RSLogix5000Content")
public class L5KBean implements Serializable
{
	private static final long serialVersionUID = -2406206388516013682L;
	
	// L5K Attributes
	private String SchemaRevision;
	private String SoftwareRevision;
	private String TargetName;
	private String TargetType;
	private String ContainsContext;
	private String Owner;
	private String ExportDate;
	private String ExportOptions;
	
	// L5K Element
	private ControllerBean controller = new ControllerBean();
	
	public L5KBean() { super(); }

	public String getSchemaRevision() {
		return SchemaRevision;
	}

	@XmlAttribute(name = "SchemaRevision")
	public void setSchemaRevision(String schemaRevision) {
		SchemaRevision = schemaRevision;
	}

	public String getSoftwareRevision() {
		return SoftwareRevision;
	}

	@XmlAttribute(name = "SoftwareRevision")
	public void setSoftwareRevision(String softwareRevision) {
		SoftwareRevision = softwareRevision;
	}

	public String getTargetName() {
		return TargetName;
	}

	@XmlAttribute(name = "TargetName")
	public void setTargetName(String targetName) {
		TargetName = targetName;
	}

	public String getTargetType() {
		return TargetType;
	}

	@XmlAttribute(name = "TargetType")
	public void setTargetType(String targetType) {
		TargetType = targetType;
	}

	public String getContainsContext() {
		return ContainsContext;
	}

	@XmlAttribute(name = "ContainsContext")
	public void setContainsContext(String containsContext) {
		ContainsContext = containsContext;
	}

	public String getOwner() {
		return Owner;
	}

	@XmlAttribute(name = "Owner")
	public void setOwner(String owner) {
		Owner = owner;
	}

	public String getExportDate() {
		return ExportDate;
	}

	@XmlAttribute(name = "ExportDate")
	public void setExportDate(String exportDate) {
		ExportDate = exportDate;
	}

	public String getExportOptions() {
		return ExportOptions;
	}

	@XmlAttribute(name = "ExportOptions")
	public void setExportOptions(String exportOptions) {
		ExportOptions = exportOptions;
	}

	public ControllerBean getController() {
		return controller;
	}
	
	@XmlElement(name = "Controller")
	public void setController(ControllerBean controller) {
		this.controller = controller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<RSLogix5000Content ");
		str.append("SchemaRevision='").append(this.SchemaRevision).append("' ");
		str.append("SoftwareRevision='").append(this.SoftwareRevision).append("' ");
		str.append("TargetName='").append(this.TargetName).append("' ");
		str.append("TargetType='").append(this.TargetType).append("' ");
		str.append("ContainsContext='").append(this.ContainsContext).append("' ");
		str.append("Owner='").append(this.Owner).append("' ");
		str.append("ExportDate='").append(this.ExportDate).append("' ");
		str.append("ExportOptions='").append(this.ExportOptions).append(">\r\n");
		str.append(controller.toString()).append("\r\n</RSLogix5000Content>");
		
		return str.toString();
	}
}
