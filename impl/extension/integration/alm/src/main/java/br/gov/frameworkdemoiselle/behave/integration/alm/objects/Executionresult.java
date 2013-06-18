package br.gov.frameworkdemoiselle.behave.integration.alm.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "executionresult")
public class Executionresult {

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/v0.1/")
	private String state;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private ApprovalState approvalstate;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer iterations = 1;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer weight = 100;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer pointspassed = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer pointsfailed = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer pointsattempted = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer pointsblocked = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private Integer pointsinconclusive = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private Integer pointspermfailed = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private Integer pointsdeferred = 0;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private ExecutionresultExecutionworkitem executionworkitem;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ApprovalState getApprovalstate() {
		return approvalstate;
	}

	public void setApprovalstate(ApprovalState approvalstate) {
		this.approvalstate = approvalstate;
	}

	public Integer getIterations() {
		return iterations;
	}

	public void setIterations(Integer iterations) {
		this.iterations = iterations;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getPointspassed() {
		return pointspassed;
	}

	public void setPointspassed(Integer pointspassed) {
		this.pointspassed = pointspassed;
	}

	public Integer getPointsfailed() {
		return pointsfailed;
	}

	public void setPointsfailed(Integer pointsfailed) {
		this.pointsfailed = pointsfailed;
	}

	public Integer getPointsattempted() {
		return pointsattempted;
	}

	public void setPointsattempted(Integer pointsattempted) {
		this.pointsattempted = pointsattempted;
	}

	public Integer getPointsblocked() {
		return pointsblocked;
	}

	public void setPointsblocked(Integer pointsblocked) {
		this.pointsblocked = pointsblocked;
	}

	public Integer getPointsinconclusive() {
		return pointsinconclusive;
	}

	public void setPointsinconclusive(Integer pointsinconclusive) {
		this.pointsinconclusive = pointsinconclusive;
	}

	public Integer getPointspermfailed() {
		return pointspermfailed;
	}

	public void setPointspermfailed(Integer pointspermfailed) {
		this.pointspermfailed = pointspermfailed;
	}

	public Integer getPointsdeferred() {
		return pointsdeferred;
	}

	public void setPointsdeferred(Integer pointsdeferred) {
		this.pointsdeferred = pointsdeferred;
	}

	public ExecutionresultExecutionworkitem getExecutionworkitem() {
		return executionworkitem;
	}

	public void setExecutionworkitem(ExecutionresultExecutionworkitem executionworkitem) {
		this.executionworkitem = executionworkitem;
	}

}
