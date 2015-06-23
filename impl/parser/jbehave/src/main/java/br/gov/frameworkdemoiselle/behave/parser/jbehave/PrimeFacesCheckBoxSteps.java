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

import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

public class PrimeFacesCheckBoxSteps extends PrimeFacesSteps {
	
	/**
	 * Tenta preencher repetidas vezes o checkbox.
	 *  
	 * Nota: para este funcionar o elemento precisa ser um PrimefacesCheckBox
	 * @param checkBoxName Nome do PrimefacesCheckBox
	 */
	@When("garanto que o campo \"$checkBoxName\" está desmarcado")
	public void forceUncheckField(String checkBoxName) {
		
		Element element = runner.getElement(currentPageName, checkBoxName);

		CheckBox cb = (CheckBox) element;
		Integer tentativas = 0;
		
		while (cb.isSelected() && tentativas < 5) {
			cb.click();
			tentativas++;
		}
		
	}
	
	/**
	 * Tenta preencher repetidas vezes o checkbox.
	 * 
	 * Nota: para este funcionar o elemento precisa ser um PrimefacesCheckBox
	 * @param checkBoxName Nome do PrimefacesCheckBox
	 */
	@When("garanto que o campo \"$checkBoxName\" está marcado")
	public void forceCheckField(String checkBoxName) {
		
		Element element = runner.getElement(currentPageName, checkBoxName);

		if (element instanceof CheckBox) {
			CheckBox cb = (CheckBox) element;
			Integer tentativas = 0;
			
			while (!cb.isSelected() && tentativas < 5) {
				cb.click();
				tentativas++;
			}
		}
	}
}
