package my.RSLogix.L5X.Unmarshall.Tags;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MessageParameters")
public class MessageBean implements Serializable
{
	private static final long serialVersionUID = -6412348750844287121L;

	private String MessageType;
	private String RemoteElement = "FALSE";
	private String RequestedLength;
	private String ConnectedFlag;
	private String ConnectionPath;
	private String CommTypeCode;
	private String ServiceCode;
	private String ObjectType;
	private String TargetObject;
	private String AttributeNumber;
	private String LocalIndex;
	private String DestinationTag;
	private String LocalElement = "FALSE";
	private String CacheConnections = "FALSE";
	
	public MessageBean() { super(); }

	public String getMessageType() {
		return MessageType;
	}

	@XmlAttribute(name = "MessageType")
	public void setMessageType(String messageType) {
		MessageType = messageType;
	}

	public String getRequestedLength() {
		return RequestedLength;
	}

	public String getRemoteElement() {
		return RemoteElement;
	}

	@XmlAttribute(name = "RemoteElement")
	public void setRemoteElement(String remoteElement) {
		RemoteElement = remoteElement;
	}

	@XmlAttribute(name = "RequestedLength")
	public void setRequestedLength(String requestedLength) {
		RequestedLength = requestedLength;
	}

	public String getConnectedFlag() {
		return ConnectedFlag;
	}

	@XmlAttribute(name = "ConnectedFlag")
	public void setConnectedFlag(String connectedFlag) {
		ConnectedFlag = connectedFlag;
	}

	public String getConnectionPath() {
		return ConnectionPath;
	}

	@XmlAttribute(name = "ConnectionPath")
	public void setConnectionPath(String connectionPath) {
		ConnectionPath = connectionPath;
	}

	public String getCommTypeCode() {
		return CommTypeCode;
	}

	@XmlAttribute(name = "CommTypeCode")
	public void setCommTypeCode(String commTypeCode) {
		CommTypeCode = commTypeCode;
	}

	public String getServiceCode() {
		return ServiceCode;
	}

	@XmlAttribute(name = "ServiceCode")
	public void setServiceCode(String serviceCode) {
		ServiceCode = serviceCode;
	}

	public String getObjectType() {
		return ObjectType;
	}

	@XmlAttribute(name = "ObjectType")
	public void setObjectType(String objectType) {
		ObjectType = objectType;
	}

	public String getTargetObject() {
		return TargetObject;
	}

	@XmlAttribute(name = "TargetObject")
	public void setTargetObject(String targetObject) {
		TargetObject = targetObject;
	}

	public String getAttributeNumber() {
		return AttributeNumber;
	}

	@XmlAttribute(name = "AttributeNumber")
	public void setAttributeNumber(String attributeNumber) {
		AttributeNumber = attributeNumber;
	}

	public String getLocalIndex() {
		return LocalIndex;
	}

	@XmlAttribute(name = "LocalIndex")
	public void setLocalIndex(String localIndex) {
		LocalIndex = localIndex;
	}

	public String getDestinationTag() {
		return DestinationTag;
	}

	@XmlAttribute(name = "DestinationTag")
	public void setDestinationTag(String destinationTag) {
		DestinationTag = destinationTag;
	}

	public String getLocalElement() {
		return LocalElement;
	}

	@XmlAttribute(name = "LocalElement")
	public void setLocalElement(String localElement) {
		LocalElement = localElement;
	}

	public String getCacheConnections() {
		return CacheConnections;
	}

	@XmlAttribute(name = "CacheConnections")
	public void setCacheConnections(String cacheConnections) {
		CacheConnections = cacheConnections;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString()
	{
		final StringBuilder str = new StringBuilder();
		str.append("<MessageParameters ");
		str.append("MessageType='").append(this.MessageType).append("' ");
		str.append("RemoteElement='").append(this.RemoteElement).append("' ");
		str.append("RequestedLength='").append(this.RequestedLength).append("' ");
		str.append("ConnectedFlag='").append(this.ConnectedFlag).append("' ");
		str.append("ConnectionPath='").append(this.ConnectionPath).append("' ");
		str.append("CommTypeCode='").append(this.CommTypeCode).append("' ");
		str.append("LocalIndex='").append(this.LocalIndex).append("' ");
		str.append("LocalElement='").append(this.LocalElement).append("' ");
		str.append("CacheConnections='").append(this.CacheConnections).append("/>\r\n");
		
		return str.toString();
	}
}
