package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "approval")
public class TestplanApproval {

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private TestplanApprovalOwner approvalOwner;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String approvalStatus;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private String approvalStateChangedDate;

	public TestplanApprovalOwner getApprovalOwner() {
		return approvalOwner;
	}

	public void setApprovalOwner(TestplanApprovalOwner approvalOwner) {
		this.approvalOwner = approvalOwner;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalStateChangedDate() {
		return approvalStateChangedDate;
	}

	public void setApprovalStateChangedDate(String approvalStateChangedDate) {
		this.approvalStateChangedDate = approvalStateChangedDate;
	}

}