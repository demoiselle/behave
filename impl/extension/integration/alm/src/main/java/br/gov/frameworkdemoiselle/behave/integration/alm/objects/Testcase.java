package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "testcase")
public class Testcase {

	@XmlElement(namespace = "http://purl.org/dc/elements/1.1/")
	private String title;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/v0.1/")
	private State state;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private Integer weight;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private Priority priority;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private Boolean suspect;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Boolean getSuspect() {
		return suspect;
	}

	public void setSuspect(Boolean suspect) {
		this.suspect = suspect;
	}

}
