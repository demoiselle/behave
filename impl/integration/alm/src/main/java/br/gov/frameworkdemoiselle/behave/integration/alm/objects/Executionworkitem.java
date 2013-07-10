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
	private TestcaseLink testcase;

	@XmlElement(namespace = "http://jazz.net/xmlns/alm/qm/v0.1/")
	private TestplanLink testplan;

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

	public TestcaseLink getTestcase() {
		return testcase;
	}

	public void setTestcase(TestcaseLink testcase) {
		this.testcase = testcase;
	}

	public TestplanLink getTestplan() {
		return testplan;
	}

	public void setTestplan(TestplanLink testplan) {
		this.testplan = testplan;
	}

}
