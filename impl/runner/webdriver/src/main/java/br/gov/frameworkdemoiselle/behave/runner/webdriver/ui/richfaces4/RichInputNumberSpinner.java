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
package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4;

import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente rich:inputNumberSpinner
 * 
 * Utiliza a API Javascript do Richfaces para a correta manipulação do componente.
 * O locator do mapeamento de tela deve retornar o primeiro div gerado pelo componente rich:inputNumberSpinner,
 * aquele span que possui 'class="rf-insp"' ou ainda que possui o mesmo ID informado no arquivo XHTML,
 * porém, o ID não é obrigatório, basta selecionar o primeiro span gerado pelo componente. 
 * 
 * @author lmveloso
 *
 */
public class RichInputNumberSpinner extends WebBase {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);
	
	public void sendKeys(CharSequence... keysToSend) {
		checkRichfacesComponent();
		String jsCodeGetInput = "return (function(id){ return RichFaces.$(id).input[0]; })('"+getId()+"');";
		WebElement input = (WebElement) getJavascriptExecutor().executeScript(jsCodeGetInput);
		input.sendKeys(keysToSend);
	}
	
	public void setValue(Long value) {
		checkRichfacesComponent();
		String jsCode = "return (function(id,value){ return RichFaces.$(id).setValue(value); })('"+getId()+"', "+value+");";
		getJavascriptExecutor().executeScript(jsCode);
	}
	
	public Long getValue() {
		checkRichfacesComponent();
		String jsCode = "return (function(id,value){ return RichFaces.$(id).getValue(); })('"+getId()+"');";
		return (Long) getJavascriptExecutor().executeScript(jsCode);
	}
	
	public void increase() {
		checkRichfacesComponent();
		String jsCode = "return (function(id,value){ return RichFaces.$(id).increase(); })('"+getId()+"');";
		getJavascriptExecutor().executeScript(jsCode);
	}
	
	public void decrease() {
		checkRichfacesComponent();
		String jsCode = "return (function(id,value){ return RichFaces.$(id).decrease(); })('"+getId()+"');";
		getJavascriptExecutor().executeScript(jsCode);
	}

	/**
	 * Verifica se o componente selecionado é realmente um coponente rich:fileupload
	 * @return
	 */
	public boolean isRichNumberSpin(){
		String jsCodeCheckComponent = "return (function(tipo, id) { var rf = RichFaces.$(id); return (typeof(rf) == \"object\" && typeof(rf.name) == \"string\" && rf.name == tipo);})('InputNumberSpinner','"+getId()+"');";
		return (Boolean) getJavascriptExecutor().executeScript(jsCodeCheckComponent);
	}
	
	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkRichfacesComponent() {
		if (!isRichNumberSpin()) {
			throw new BehaveException(message.getString("exception-not-rich-type", this.getElementMap().name(), getId(), "rich:inputNumberSpinner"));
		}

	}
}
