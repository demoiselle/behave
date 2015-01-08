package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "approvals")
public class TestplanApprovals {

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")	
	private List<TestplanApprovalDescriptor> approvalDescriptor;
	
}
