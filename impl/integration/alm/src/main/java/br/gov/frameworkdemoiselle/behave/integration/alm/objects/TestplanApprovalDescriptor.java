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
