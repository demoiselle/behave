package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "approvalDescriptor")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestplanApprovalDescriptor {

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String id;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String name;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String approvalType;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String approvalStateChangedDate;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String archived;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private List<TestplanApproval> approval;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public String getApprovalStateChangedDate() {
		return approvalStateChangedDate;
	}

	public void setApprovalStateChangedDate(String approvalStateChangedDate) {
		this.approvalStateChangedDate = approvalStateChangedDate;
	}

	public String getArchived() {
		return archived;
	}

	public void setArchived(String archived) {
		this.archived = archived;
	}

	public List<TestplanApproval> getApproval() {
		return approval;
	}

	public void setApproval(List<TestplanApproval> approval) {
		this.approval = approval;
	}

}
