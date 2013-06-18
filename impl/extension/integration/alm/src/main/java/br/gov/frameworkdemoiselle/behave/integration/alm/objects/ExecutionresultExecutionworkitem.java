package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "testcase")
public class ExecutionresultExecutionworkitem {

	@XmlAttribute
	protected String href;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
