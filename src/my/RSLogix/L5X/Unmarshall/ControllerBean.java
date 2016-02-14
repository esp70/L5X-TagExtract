package my.RSLogix.L5X.Unmarshall;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import my.RSLogix.L5X.Unmarshall.DataTypes.DataTypeBean;
import my.RSLogix.L5X.Unmarshall.Tags.TagBean;




@XmlRootElement(name = "Controller")
public class ControllerBean implements Serializable
{
	private static final long serialVersionUID = 5662143294390004770L;
	
	// Controller Attributes
	private String Use;
	private String Name;
	private String ProcessorType;
	private String MajorRev;
	private String MinorRev;
	private String TimeSlice;
	private String ShareUnusedTimeSlice;
	private String ProjectCreationDate;
	private String LastModifiedDate;
	private String SFCExecutionControl;
	private String SFCRestartPosition;
	private String SFCLastScan;
	private String ProjectSN;
	private String MatchProjectToController;
	private String CanUseRPIFromProducer;
	private String InhibitAutomaticFirmwareUpdate;
	
	// Controller Elements
	private RedundencyInfoBean RedundencyInfo;
	private SecurityBean Security;
	private CSTBean CST;
	private WallClockTimeBean WallClockTime;
	private TimeSynchronizeBean TimeSynchronize;
	
	// Controller Wrapper Elements
	@XmlElementWrapper(name = "Tags")
	@XmlElement(name = "Tag")
	private List<TagBean> Tags = new ArrayList<TagBean>();
	
	@XmlElementWrapper(name = "DataTypes")
	@XmlElement(name = "DataType")
	private List<DataTypeBean> DataType = new ArrayList<DataTypeBean>();
	
	public ControllerBean() { super(); }

	public String getUse() {
		return Use;
	}

	@XmlAttribute(name = "Use")
	public void setUse(String use) {
		Use = use;
	}

	public String getName() {
		return Name;
	}

	@XmlAttribute(name = "Name")
	public void setName(String name) {
		Name = name;
	}

	public String getProcessorType() {
		return ProcessorType;
	}

	@XmlAttribute(name = "ProcessorType")
	public void setProcessorType(String processorType) {
		ProcessorType = processorType;
	}

	public String getMajorRev() {
		return MajorRev;
	}

	@XmlAttribute(name = "MajorRev")
	public void setMajorRev(String majorRev) {
		MajorRev = majorRev;
	}

	public String getMinorRev() {
		return MinorRev;
	}

	@XmlAttribute(name = "MinorRev")
	public void setMinorRev(String minorRev) {
		MinorRev = minorRev;
	}

	public String getTimeSlice() {
		return TimeSlice;
	}

	@XmlAttribute(name = "TimeSlice")
	public void setTimeSlice(String timeSlice) {
		TimeSlice = timeSlice;
	}

	public String getShareUnusedTimeSlice() {
		return ShareUnusedTimeSlice;
	}

	@XmlAttribute(name = "ShareUnusedTimeSlice")
	public void setShareUnusedTimeSlice(String shareUnusedTimeSlice) {
		ShareUnusedTimeSlice = shareUnusedTimeSlice;
	}

	public String getProjectCreationDate() {
		return ProjectCreationDate;
	}

	@XmlAttribute(name = "ProjectCreationDate")
	public void setProjectCreationDate(String projectCreationDate) {
		ProjectCreationDate = projectCreationDate;
	}

	public String getLastModifiedDate() {
		return LastModifiedDate;
	}

	@XmlAttribute(name = "LastModifiedDate")
	public void setLastModifiedDate(String lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}

	public String getSFCExecutionControl() {
		return SFCExecutionControl;
	}

	@XmlAttribute(name = "SFCExecutionControl")
	public void setSFCExecutionControl(String sFCExecutionControl) {
		SFCExecutionControl = sFCExecutionControl;
	}

	public String getSFCRestartPosition() {
		return SFCRestartPosition;
	}

	@XmlAttribute(name = "SFCRestartPosition")
	public void setSFCRestartPosition(String sFCRestartPosition) {
		SFCRestartPosition = sFCRestartPosition;
	}

	public String getSFCLastScan() {
		return SFCLastScan;
	}

	@XmlAttribute(name = "SFCLastScan")
	public void setSFCLastScan(String sFCLastScan) {
		SFCLastScan = sFCLastScan;
	}

	public String getProjectSN() {
		return ProjectSN;
	}

	@XmlAttribute(name = "ProjectSN")
	public void setProjectSN(String projectSN) {
		ProjectSN = projectSN;
	}

	public String getMatchProjectToController() {
		return MatchProjectToController;
	}

	@XmlAttribute(name = "MatchProjectToController")
	public void setMatchProjectToController(String matchProjectToController) {
		MatchProjectToController = matchProjectToController;
	}

	public String getCanUseRPIFromProducer() {
		return CanUseRPIFromProducer;
	}

	@XmlAttribute(name = "CanUseRPIFromProducer")
	public void setCanUseRPIFromProducer(String canUseRPIFromProducer) {
		CanUseRPIFromProducer = canUseRPIFromProducer;
	}

	public String getInhibitAutomaticFirmwareUpdate() {
		return InhibitAutomaticFirmwareUpdate;
	}

	@XmlAttribute(name = "InhibitAutomaticFirmwareUpdate")
	public void setInhibitAutomaticFirmwareUpdate(
			String inhibitAutomaticFirmwareUpdate) {
		InhibitAutomaticFirmwareUpdate = inhibitAutomaticFirmwareUpdate;
	}

	public RedundencyInfoBean getRedundencyInfo() {
		return RedundencyInfo;
	}

	@XmlElement(name = "RedundancyInfo")
	public void setRedundencyInfo(RedundencyInfoBean redundencyInfo) {
		RedundencyInfo = redundencyInfo;
	}

	public SecurityBean getSecurity() {
		return Security;
	}

	@XmlElement(name = "Security")
	public void setSecurity(SecurityBean security) {
		Security = security;
	}

	public CSTBean getCST() {
		return CST;
	}

	@XmlElement(name = "CST")
	public void setCST(CSTBean cST) {
		CST = cST;
	}

	public WallClockTimeBean getWallClockTime() {
		return WallClockTime;
	}

	@XmlElement(name = "WallClockTime")
	public void setWallClockTime(WallClockTimeBean wallClockTime) {
		WallClockTime = wallClockTime;
	}

	public TimeSynchronizeBean getTimeSynchronize() {
		return TimeSynchronize;
	}

	@XmlElement(name = "TimeSynchronize")
	public void setTimeSynchronize(TimeSynchronizeBean timeSynchronize) {
		TimeSynchronize = timeSynchronize;
	}

	public List<TagBean> getTags() {
		return Tags;
	}

	@XmlElement(name = "Tags")
	public void setTags(List<TagBean> tags) {
		Tags = tags;
	}

	public List<DataTypeBean> getDataType() {
		return DataType;
	}

	@XmlElement(name = "DataTypes")
	public void setDataType(List<DataTypeBean> dataType) {
		DataType = dataType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<Controller ");
		str.append("Use='").append(this.Use).append("' ");
		str.append("Name='").append(this.Name).append("' ");
		str.append("ProcessorType='").append(this.ProcessorType).append("' ");
		str.append("MajorRev='").append(this.MajorRev).append("' ");
		str.append("MinorRev='").append(this.MinorRev).append("' ");
		str.append("TimeSlice='").append(this.TimeSlice).append("' ");
		str.append("ShareUnusedTimeSlice='").append(this.ShareUnusedTimeSlice).append("' ");
		str.append("ProjectCreationDate='").append(this.ProjectCreationDate).append("' ");
		str.append("LastModifiedDate='").append(this.LastModifiedDate).append("' ");
		str.append("SFCExecutionControl='").append(this.SFCExecutionControl).append("' ");
		str.append("SFCRestartPosition='").append(this.SFCRestartPosition).append("' ");
		str.append("SFCLastScan='").append(this.SFCLastScan).append("' ");
		str.append("ProjectSN='").append(this.ProjectSN).append("' ");
		str.append("MatchProjectToController='").append(this.MatchProjectToController).append("' ");
		str.append("CanUseRPIFromProducer='").append(this.CanUseRPIFromProducer).append("' ");
		str.append("InhibitAutomaticFirmwareUpdate='").append(this.InhibitAutomaticFirmwareUpdate).append("'>\r\n");
		str.append(RedundencyInfo.toString()).append("\r\n");
		str.append(Security.toString()).append("\r\n");
		str.append(CST.toString()).append("\r\n");
		str.append(WallClockTime.toString()).append("\r\n");
		str.append(TimeSynchronize.toString()).append("\r\n</Controller>");
		
		return str.toString();
	}
}
