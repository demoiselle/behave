package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "executionworkitem")
public class Executionworkitem {

	@XmlElement(namespace = "http://purl.org/dc/elements/1.1/")
	private String title;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionworkitem/v0.1")
	private String frequency;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionworkitem/v0.1")
	private Boolean regression;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionworkitem/v0.1")
	private Priority priority;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionworkitem/v0.1")
	private Integer weight;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private ExecutionworkitemTestcase testcase;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private ExecutionworkitemTestplan testplan;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Boolean getRegression() {
		return regression;
	}

	public void setRegression(Boolean regression) {
		this.regression = regression;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public ExecutionworkitemTestcase getTestcase() {
		return testcase;
	}

	public void setTestcase(ExecutionworkitemTestcase testcase) {
		this.testcase = testcase;
	}

	public ExecutionworkitemTestplan getTestplan() {
		return testplan;
	}

	public void setTestplan(ExecutionworkitemTestplan testplan) {
		this.testplan = testplan;
	}

}
