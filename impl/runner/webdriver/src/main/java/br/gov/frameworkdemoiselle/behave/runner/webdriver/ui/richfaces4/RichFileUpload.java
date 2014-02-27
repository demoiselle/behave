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

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente rich:fileupload
 * 
 * Utiliza a API Javascript do Richfaces para a correta manipulação do componente.
 * O locator do mapeamento de tela deve retornar o primeiro div gerado pelo componente rich:fileupload,
 * aquele div que possui 'class="rf-cal"' ou ainda que possui o mesmo ID informado no arquivo XHTML,
 * porém, o ID não é obrigatório, basta selecionar o primeiro div gerado pelo componente.
 * 
 * @author lmveloso
 *
 */
public class RichFileUpload extends WebBase {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);
	
	public void sendKeys(CharSequence... keysToSend) {
		checkRichfacesComponent();
		String jsCodeGetInput = "return (function(id){ return RichFaces.$(id).input[0]; })('"+getId()+"');";
		WebElement input = (WebElement) getJavascriptExecutor().executeScript(jsCodeGetInput);
		input.sendKeys(keysToSend);
	}

	
	public void setValue(String value) {
		sendKeys(value);
	}

	public void add(String pathToFile){
		if(!canAdd())
			throw new BehaveException(message.getString("exception-error-click", "Add", this.getElementMap().name()));
		sendKeys(pathToFile);
	}
	public boolean canAdd() {
		checkRichfacesComponent();
		String jsCode = "return (function(id) { var rf = RichFaces.$(id); return (rf.addButton.prop('style').display != \"none\");})('"+getId()+"');";
		return (Boolean) getJavascriptExecutor().executeScript(jsCode);
	}
	
	public void clearAll(){
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('"+getId()+"').clearButton.click();");
		
	}

	public void upload(){
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('"+getId()+"').uploadButton.click();");
	}
	
	public String getSubmitedItemState(String label) {
		checkRichfacesComponent();
		String jsCode = "return (function(id,label) { var rf = RichFaces.$(id); var l = rf.list.find('.rf-fu-itm:contains('+label+') .rf-fu-itm-st'); if( rf.list.find('.rf-fu-itm:contains('+label+') .rf-pb').length == 0 && l.length == 1 ) return l.text(); return null;  })('"+getId()+"', '"+label+"' );";
		return (String) getJavascriptExecutor().executeScript(jsCode);
	}

	public Boolean waitUntilSubmitItAll() {
		checkRichfacesComponent();

		// Condições verificadas: não haver nenhuma progress bar; não haver nenhum item pendente de envio; haver algum item na lista de itens enviados
		String jsCodeAllSent = "return (function(id) { var rf = RichFaces.$(id); return (rf.list.find('.rf-pb').length == 0 && rf.items.length == 0 && rf.submitedItems.length > 0); })('"+getId()+"' );";
		Boolean allSent = (Boolean) getJavascriptExecutor().executeScript(jsCodeAllSent);
		
		if(! allSent ) {
			// Verifica se há alguma progress bar, indicando o progresso do envio de arquivo
			String jsCodeIsUploading = "return (function(id) { var rf = RichFaces.$(id); return rf.list.find('.rf-pb').length != 0; })('"+getId()+"' );";
			Boolean isSending = (Boolean) getJavascriptExecutor().executeScript(jsCodeIsUploading);
			int waitTime = 0;
			while( isSending && waitTime < BehaveConfig.getRunner_ScreenMaxWait() ) {
				// aguarda o termino do envio
				waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());
				waitTime += BehaveConfig.getRunner_ScreenMinWait();
				isSending = (Boolean) getJavascriptExecutor().executeScript(jsCodeIsUploading);
			}
			if( isSending )
				return false; // timeout
			// Verifica se todos os itens foram enviados 
			return (Boolean) getJavascriptExecutor().executeScript(jsCodeAllSent);
		}
		
		String jsCodeIsUploading = "return (function(id) { var rf = RichFaces.$(id); return (rf.list.find('.rf-pb').length == 0 && rf.items.length == 0 && rf.submitedItems.length > 0); })('"+getId()+"' );";
		return (Boolean) getJavascriptExecutor().executeScript(jsCodeIsUploading);
	}
	
	/**
	 * Verifica se o componente selecionado é realmente um coponente rich:fileupload
	 * @return
	 */
	public boolean isRichFileUpload(){
		String jsCodeCheckComponent = "return (function(tipo, id) { var rf = RichFaces.$(id); return (typeof(rf) == \"object\" && typeof(rf.name) == \"string\" && rf.name == tipo);})('FileUpload','"+getId()+"');";
		return (Boolean) getJavascriptExecutor().executeScript(jsCodeCheckComponent);
	}
	
	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkRichfacesComponent() {
		if (!isRichFileUpload()) {
			throw new BehaveException(message.getString("exception-not-rich-type", this.getElementMap().name(), getId(), "rich:fileupload"));
		}

	}
}
