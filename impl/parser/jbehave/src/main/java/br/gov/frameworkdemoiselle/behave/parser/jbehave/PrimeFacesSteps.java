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
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License version 3
* along with this program; if not, see <http://www.gnu.org/licenses/>
* or write to the Free Software Foundation, Inc., 51 Franklin Street,
* Fifth Floor, Boston, MA 02110-1301, USA.
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
package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;

public class PrimeFacesSteps extends CommonSteps {

	/**
	 * Verifica se um PrimeFacesCheckBox ou PrimeFacesRadioButton está desmarcado.
	 * 
	 * Nota: para este funcionar o elemento precisa ser um PrimeFacesCheckBox ou PrimeFacesRadioButton
	 * @param elementName Nome do PrimeFacesCheckBox ou PrimeFacesRadioButton
	 */
	@Given("o campo \"$elementName\" está desmarcado")
	@When("o campo \"$elementName\" está desmarcado")
	@Then("o campo \"$elementName\" está desmarcado")
	public void primefacesFieldIsNotSelected(String elementName) {
		
		Element element = runner.getElement(currentPageName, elementName);

		if (element instanceof CheckBox) {			
			if(((CheckBox) element).isSelected()){
				throw new BehaveException("O elemento com identificador ["+element.getElementMap().locator()[0]+"] deveria estar DESmarcado, mas está marcado!"); 
			} 
		} else if (element instanceof Radio) { 
			if(((Radio) element).isSelected()){
				throw new BehaveException("O elemento com identificador ["+element.getElementMap().locator()[0]+"] deveria estar DESmarcado, mas está marcado!"); 
			}
		}
	}
	
	/**
	 * Verifica se um PrimeFacesCheckBox ou PrimeFacesRadioButton está marcado.
	 * 
	 * Nota: para este funcionar o elemento precisa ser um PrimeFacesCheckBox ou PrimeFacesRadioButton
	 * @param elementName nome do elemento PrimeFacesCheckBox ou PrimeFacesRadioButton
	 */
	@Given("o campo \"$elementName\" está marcado")
	@When("o campo \"$elementName\" está marcado")
	@Then("o campo \"$elementName\" está marcado")
	public void primefacesFieldIsSelected(String elementName) {
		
		Element element = runner.getElement(currentPageName, elementName);

		if (element instanceof CheckBox) {			
			if(!((CheckBox) element).isSelected()){
				throw new BehaveException("O elemento com identificador ["+element.getElementMap().locator()[0]+"] deveria estar marcado, mas está DESmarcado!"); 
			} 
		} else if (element instanceof Radio) {
			if(!((Radio) element).isSelected()){
				throw new BehaveException("O elemento com identificador ["+element.getElementMap().locator()[0]+"] deveria estar marcado, mas está DESmarcado!");
			}
		}
	}

}
