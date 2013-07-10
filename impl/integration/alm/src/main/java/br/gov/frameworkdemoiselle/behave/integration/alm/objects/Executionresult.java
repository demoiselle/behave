/*
 * Demoiselle Framework
 * Copyright (C) 2013 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
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
	private ExecutionworkitemLink executionworkitem;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private String starttime;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private String endtime;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/executionresult/v0.1")
	private String details;

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

	public ExecutionworkitemLink getExecutionworkitem() {
		return executionworkitem;
	}

	public void setExecutionworkitem(ExecutionworkitemLink executionworkitem) {
		this.executionworkitem = executionworkitem;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
