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
package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.AutoComplete;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;

/**
 * @author SERPRO
 */
public class WebAutoComplete extends WebBase implements AutoComplete {

	protected static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);

	/**
	 * Armazena o valor que será selecionado na lista do autocomplete, somente
	 * se, o valor de busca for diferente deste
	 * 
	 * Exemplo: Busca pelo texto "foo" mas seleciona na lista o valor "foo, bar"
	 * 
	 * @see #select(String)
	 */
	private String selectValue = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectByValue(String value) {
		select(value);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void searchAndSelectValue(String searchValue, String selectValue) {
		this.selectValue = selectValue;

		select(searchValue);

	}

	@Override
	public String getText() {
		waitElement(0);
		return getElements().get(0).getAttribute("value");
	}

	/**
	 * Método generalizado para selecionar o valor da lista
	 * 
	 * @param value
	 *            Valor a ser informado no campo de texto do autocomplete
	 */
	protected void select(String value) {

		// Aguarda o primeiro elemento ser clicável
		waitElement(0);

		List<WebElement> elements = getElements();
		if (elements.size() == 1 && getElementMap().locator().length == 1) {
			throw new BehaveException(message.getString("exception-autocomplete-missing-elements", "locator", "@ElementMap"));
		}

		WebElement element = elements.get(0);

		if (element.getTagName().equals("input") && element.getAttribute("type").equals("text")) {
			// Preenche o valor do Autocomplete
			element.clear();
			element.sendKeys(value);
		}

		/*
		 * Tempo do efeito de abertura das opções
		 * 
		 * Obs: Utilizada API de Reflection para retrocompatibilidade com
		 * versões anteriores do DBehave (1.3.0 por exemplo)
		 */
		try {
			Method waitElementOnlyVisible = getClass().getMethod("waitElementOnlyVisible", new Class[] { Integer.class });
			try {
				waitElementOnlyVisible.invoke(this, new Object[] { 1 });
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			waitElement(1);
		}

		if (this.selectValue != null) {
			value = this.selectValue;
		}

		selectOnList(elements.get(1), value);
	}

	/**
	 * Busca nas tags <li>ou
	 * <td>filhas de "element", um texto correspondente a "value" na lista do
	 * autocomplete e seleciona-o
	 * 
	 * @param WebElement
	 *            element Elemento pai da lista de resultados do autocomplete
	 * @param String
	 *            value valor a ser procurado na lista
	 */
	protected void selectOnList(WebElement element, String value) {

		List<WebElement> elementValue = element.findElements(By.tagName("li"));
		if (elementValue.size() == 0) {
			elementValue = element.findElements(By.tagName("td"));
		}

		for (WebElement item : elementValue) {
			if (item.getText().equals(value)) {
				// Aguarda o segundo elemento ser clicável
				try {
					waitElement(1);
					item.click();
				} catch (Throwable t) {
					waitElement(1);
					item.click();
				}
				break;
			}
		}
	}
}