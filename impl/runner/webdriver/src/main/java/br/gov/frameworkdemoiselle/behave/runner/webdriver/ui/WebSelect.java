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
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;

/**
 * @author SERPRO
 */
public class WebSelect extends WebBase implements Select {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);
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
	 * Método generalizado para selecionar o valor do select (DropDown)
	 * 
	 * Atenção para a implementação: ele tenta 3 vezes selecionar o valor do select, isso é feito pois existem casos em que o select é populado por um ajax e ele pode demorar a acontecer, por isso precisamos que sejam feitas tentativas para não dar erro falso.
	 * 
	 * @param value
	 * @param type
	 */
	private void select(String value, WebSelectType type) {
		boolean valueSelected = false;
		int numberMaxTries = 3;
		int currentTries = 1;

		while (!valueSelected) {

			// Número máximo de tentativas excedido
			if (currentTries > numberMaxTries)
				break;

			try {

				// Tenta esperar que o texto do valo esteja na tela, mas somente isso não garante que o valor seja do campo, por isso fazemos 3 tentativas
				waitText(value);

				// // log.debug("Tentando selecionar o valor do drop down (" + value + ") - waitElement");

				// Aguarda o primeiro elemento ser clicável
				waitElement(0);

				if (getElements().get(0).getTagName().equals("select")) {

					// log.debug("Entrou para selecionar (" + value + ") - Depois waitElement");

					// Select comum e usa um helper do selenium
					org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));

					// log.debug("Pegou o objeto do select (" + value + ")");

					// Verifica o tipo valor do select
					if (type == WebSelectType.TEXT) {
						lSelect.selectByVisibleText(value);
					} else if (type == WebSelectType.INDEX) {
						lSelect.selectByIndex(Integer.parseInt(value));
					} else if (type == WebSelectType.VALUE) {
						lSelect.selectByValue(value);
					}

					valueSelected = true;

					// log.debug("Selecionou o valor (" + value + ")");

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

					valueSelected = true;

				}

			} catch (StaleElementReferenceException ex) {
				log.error("Erro no dropwdown (StaleElementReferenceException): ", ex);
			} finally {
				currentTries++;
			}
		}

		// Se nenhum valor selecionado for encontrado tem que dar erro
		if (!valueSelected)
			throw new BehaveException(message.getString("exception-value-dont-selected"));
	}

	public enum WebSelectType {
		TEXT, INDEX, VALUE
	}

}
