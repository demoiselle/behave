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

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.runner.ui.Select;

/**
 * @author SERPRO
 */
public class WebSelect extends WebBase implements Select {

	Logger log = Logger.getLogger(WebSelect.class);

	/**
	 * Armazena o elemento html principal que compôe o combo
	 * 
	 * <b>Obs:</b> Específico para combos do primefaces
	 */
	private WebElement elementMain = null;

	/**
	 * {@inheritDoc}
	 */
	public void selectByVisibleText(String value) {
		select(value, WebSelectType.TEXT);
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectByIndex(int index) {
		select(index + "", WebSelectType.INDEX);
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectByValue(String value) {
		select(value, WebSelectType.VALUE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText() {
		// Fazer tratamento para SELECT normal e PrimeFaces
		List<WebElement> elements = getElements();
		if (elements.get(0).getTagName().equals("select")) {
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(elements.get(0));
			return lSelect.getFirstSelectedOption().getText();
		} else {
			WebElement element = elements.get(0);
			if (element.getAttribute("class").contains("ui-selectonemenu") && !element.getAttribute("class").contains("ui-selectonemenu-label")) {
				org.openqa.selenium.support.ui.Select lSelectInnerElement = new org.openqa.selenium.support.ui.Select(element.findElement(By.tagName("select")));
				return lSelectInnerElement.getFirstSelectedOption().getAttribute("innerHTML");
			} else {
				return element.getText();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void blur() {
		getElements().get(0).click();
	}

	public void blur(WebElement element) {
		// Clica em outro elemento para tirar o foco
		element.click();
	}

	/**
	 * Método generalizado para selecionar o valor do select (DropDown)
	 * 
	 * @param value
	 * @param type
	 */
	private void select(String value, WebSelectType type) {

		// Aguarda o primeiro elemento ser clicável
		waitElement(0);

		List<WebElement> elements = getElements();

		if (elements.get(0).getTagName().equals("select")) {

			// Select comum e usa um helper do selenium
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(elements.get(0));

			// Verifica o tipo valor do select
			if (type == WebSelectType.TEXT) {
				lSelect.selectByVisibleText(value);
			} else if (type == WebSelectType.INDEX) {
				lSelect.selectByIndex(Integer.parseInt(value));

				// Solução de contorno para atualizar o valor selecionado
				lSelect.getFirstSelectedOption();
			} else if (type == WebSelectType.VALUE) {
				lSelect.selectByValue(value);
			}

		} else {

			// Outros tipos de select como a do primefaces
			elementMain = elements.get(0);
			elementMain.click();

			// Tempo do efeito de abertura das opções
			waitElementOnlyVisible(1);

			List<WebElement> elementValue = elements.get(1).findElements(By.tagName("li"));

			// Aguarda o segundo elemento ser clicável
			if (type == WebSelectType.INDEX) {
				// Índice começando em 1 - Muitas vezes o 1 é o item SELECIONE
				int index = 1;
				for (WebElement item : elementValue) {
					if (index++ == Integer.valueOf(value)) {
						itemListClick(item);
						break;
					}
				}
			} else {
				for (WebElement item : elementValue) {
					// Verifica se existe a virgula, se existir significa que
					// são multiplos valores e procura por contains
					if (value.contains(",")) {
						if (!item.getText().equals("") && value.contains(item.getText())) {
							itemListClick(item);

							item = null;
							continue;
						}
					} else if (item.getText().equals(value)) {
						itemListClick(item);
						break;
					}
				}
			}

			// Aguarda o DIV sumir se não for seleção multipla, pois na seleção
			// multipla ele tem o botão de fechar
			if (!value.contains(","))
				waitInvisible(1);

		}

	}

	/**
	 * Seleciona um item <li>da lista do combo, retirando ou não o foco a
	 * depender do que for definido no parâmetro "action"
	 * 
	 * @param WebElement
	 *            item Elemento <li>que será selecionado
	 * @see ElementMainAction
	 */
	private void itemListClick(WebElement item) {
		try {
			waitElement(1);
			item.click();
		} catch (Throwable t) {
			waitElement(1);
			item.click();
		}
	}

	public enum WebSelectType {
		TEXT, INDEX, VALUE
	}

}