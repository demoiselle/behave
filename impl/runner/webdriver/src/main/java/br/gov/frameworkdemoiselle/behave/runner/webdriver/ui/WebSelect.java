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
	public String getText() {
		// Fazer tratamento para SELECT normal e PrimeFaces
		if (getElements().get(0).getTagName().equals("select")) {
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));
			return lSelect.getFirstSelectedOption().getText();
		} else {
			return getElements().get(0).getText();
		}
	}

	/**
	 * Método generalizado para selecionar o valor do select (DropDown)
	 * 
	 * @param value
	 * @param type
	 */
	private void select(String value, WebSelectType type) {

		// Esperar que o texto do valo esteja na tela
		waitText(value);

		// Aguarda o primeiro elemento ser clicável
		waitElement(0);

		if (getElements().get(0).getTagName().equals("select")) {

			// Select comum e usa um helper do selenium
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));

			// Verifica o tipo valor do select
			if (type == WebSelectType.TEXT) {
				lSelect.selectByVisibleText(value);
			} else if (type == WebSelectType.INDEX) {
				lSelect.selectByIndex(Integer.parseInt(value));
			} else if (type == WebSelectType.VALUE) {
				lSelect.selectByValue(value);
			}

		} else {

			// Outros tipos de select como a do primefaces
			WebElement elementMain = getElements().get(0);
			elementMain.click();

			List<WebElement> elementValue = getElements().get(1).findElements(By.tagName("li"));
			for (WebElement item : elementValue) {
				if (item.getText().equals(value)) {
					// Aguarda o segundo elemento ser clicável
					waitElement(1);
					item.click();
					break;
				}
			}

		}

	}

	public enum WebSelectType {
		TEXT, INDEX, VALUE
	}

}
