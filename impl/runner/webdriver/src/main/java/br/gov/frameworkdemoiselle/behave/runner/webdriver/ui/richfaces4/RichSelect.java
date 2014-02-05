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

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente rich:select
 * 
 * Utiliza a API Javascript do Richfaces para a correta manipulação do
 * componente. O locator do mapeamento de tela deve retornar o primeiro div
 * gerado pelo componente rich:select, aquele div que possui 'class="rf-sel"' ou
 * ainda que possui o mesmo ID informado no arquivo XHTML, porém, o ID não é
 * obrigatório, basta selecionar o primeiro div gerado pelo componente.
 * 
 * @author lmveloso
 * 
 */
public class RichSelect extends WebBase implements Select {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);

	/**
	 * Clica no campo do rich:select, provocando a abertura ou o fechamento do
	 * menu popup.
	 * 
	 * Se após o click o popup estiver aberto e foi informado algum parâmetro
	 * para o localizador, então busca o item com label igual ao parâmetro e
	 * clica neste campo.
	 * 
	 */
	public void click() {
		if (getLocatorParameter() != null && !getLocatorParameter().isEmpty())
			click(getLocatorParameter().get(0));
		else
			click(null);
	}

	/**
	 * Clica no campo do rich:select, provocando a abertura ou o fechamento do
	 * menu popup.
	 * 
	 * Se após o click o popup estiver aberto e foi informado algum parâmetro
	 * para o localizador, então busca o item com label igual ao parâmetro e
	 * clica neste campo.
	 * 
	 * @param txtMenuItem
	 */
	public void click(String txtMenuItem) {
		waitElement(0);

		checkRichfacesComponent();

		// Abre ou fecha o menu de acordo com o estado do componente
		if ((Boolean) getJavascriptExecutor().executeScript("return RichFaces.$('" + getId() + "').popupList.isVisible();"))
			hidePopup();
		else {
			showPopup();
			clickMenuItem(txtMenuItem);
		}
	}

	/**
	 * Procura no componente rich:select um item com o mesmo label informado e
	 * se encontrado envia um evento de click() para o elemento correspondente.
	 * 
	 * @param txtMenuItem
	 */
	public void clickMenuItem(String txtMenuItem) {

		checkRichfacesComponent();

		// Se o label do item de menu foi informado, seleciona o elemento da
		// popupList
		if (txtMenuItem != null && !txtMenuItem.isEmpty()) {
			String jsClickItemCode = "return (function(val, id){ var rfs = RichFaces.$(id); for( var n=0; n < rfs.popupList.options.clientSelectItems.length; n++ ) { if( rfs.popupList.options.clientSelectItems[n].label == val ) { rfs.originalItems[ n ].click(); return true; } } return false; })('" + txtMenuItem + "','" + getId() + "');";

			Boolean clicked = (Boolean) getJavascriptExecutor().executeScript(jsClickItemCode);
			if (!clicked) {
				throw new BehaveException(message.getString("exception-error-click", txtMenuItem, this.getElementMap().name()));
			}
		}
	}

	/**
	 * Utiliza a API Javascritp do Richfaces para mostrar o popup com itens do
	 * rich:select
	 */
	public void showPopup() {
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('" + getId() + "').showPopup();");
	}

	/**
	 * Utiliza a API Javascritp do Richfaces para ocultar o popup com itens do
	 * rich:select
	 */
	public void hidePopup() {
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('" + getId() + "').hidePopup();");
	}

	/**
	 * Verifica se o componente selecionado é realmente um coponente rich:select
	 * 
	 * @return
	 */
	public boolean isRichSelect() {
		String jsCodeCheckComponent = "return (function(tipo, id) { var rf = RichFaces.$(id); return (typeof(rf) == \"object\" && typeof(rf.name) == \"string\" && rf.name == tipo);})('select','" + getId() + "');";
		return (Boolean) getJavascriptExecutor().executeScript(jsCodeCheckComponent);
	}

	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkRichfacesComponent() {
		if (!isRichSelect()) {
			throw new BehaveException(message.getString("exception-not-rich-type", this.getElementMap().name(), getId(), "rich:select"));
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void selectByVisibleText(String value) {
		clickMenuItem(value);
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectByIndex(int index) {

		checkRichfacesComponent();

		String jsClickItemCode = "return (function(index,id){ var rfs = RichFaces.$(id); if( index >= 0 && index < rfs.originalItems.length ) { rfs.originalItems.get( index ).click(); return true; } return false; })(" + index + ",'" + getId() + "');";

		Boolean clicked = (Boolean) getJavascriptExecutor().executeScript(jsClickItemCode);
		if (!clicked) {
			throw new BehaveException(message.getString("exception-error-click", index, this.getElementMap().name()));
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void selectByValue(String value) {
		checkRichfacesComponent();

		// Se o label do item de menu foi informado, seleciona o elemento da
		// popupList
		if (value != null && !value.isEmpty()) {
			String jsClickItemCode = "return (function(value,id){ var rfs = RichFaces.$(id); for( var n=0; n < rfs.popupList.options.clientSelectItems.length; n++ ) { if( rfs.popupList.options.clientSelectItems[n].label == value ) { rfs.originalItems[ n ].click(); return true; } } return false; })('" + value + "','" + getId() + "');";

			Boolean clicked = (Boolean) getJavascriptExecutor().executeScript(jsClickItemCode);
			if (!clicked) {
				throw new BehaveException(message.getString("exception-error-click", value, this.getElementMap().name()));
			}
		}
	}
}
