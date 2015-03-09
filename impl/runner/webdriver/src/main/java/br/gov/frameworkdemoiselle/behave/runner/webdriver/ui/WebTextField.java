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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;

public class WebTextField extends WebBase implements TextField {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);

	public void sendKeys(CharSequence... keysToSend) {
		waitElement(0);
		
		String value = charSequenceToString(keysToSend);
		
		//Envia uma sequencia de char
		getElements().get(0).sendKeys(value);
	}

	/**
	 * Função que tenta preencher mais de uma vez o campo. Ela verifica se o
	 * conteúdo enviado é o mesmo que esta atualmente no campo.
	 */
	public void sendKeysWithTries(CharSequence... keysToSend) {
		waitElement(0);
		
		String value = charSequenceToString(keysToSend);

		int totalMilliseconds = 0;

		List<WebElement> elements = getElements();

		while (!elements.get(0).getAttribute("value").equals(value)) {
			
			// Limpa o valor atual do campo utilizando a função padrão 
			elements.get(0).clear();
			
			// Envia para o elemento
			elements.get(0).sendKeys(getValueToSend(value));
			
			// Verifica se o elemento já esta com o valor correto
			if (elements.get(0).getAttribute("value").equals(value))
				break;
			
			totalMilliseconds += BehaveConfig.getRunner_ScreenMinWait();

			if (totalMilliseconds > BehaveConfig.getRunner_ScreenMaxWait()) {
				throw new BehaveException(message.getString("exception-not-clean"));
			}

			// Aguarda um tempo antes de tentar novamente
			try {
				Thread.sleep(BehaveConfig.getRunner_ScreenMinWait());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String charSequenceToString(CharSequence... keysToSend) {
		String value = "";
		
		for (int i = 0; i < keysToSend.length; i++)
			value += keysToSend[i];
		
		return value;
	}
	
	private String getValueToSend(String value) {
		String finalValue = Keys.chord(Keys.CONTROL, "a") + value + Keys.chord(Keys.TAB);		
		return finalValue;
	}

	/**
	 * O método de limpar o campo do WebDriver não funciona corretamente com
	 * campos com máscara. Segue abaixo o que esta escrito no javadoc do
	 * Webdriver.
	 * 
	 * ------------------------------------------------------------------------
	 * If this element is a text entry element, this will clear the value. Has
	 * no effect on other elements. Text entry elements are INPUT and TEXTAREA
	 * elements.
	 * 
	 * Note that the events fired by this event may not be as you'd expect. In
	 * particular, we don't fire any keyboard or mouse events. If you want to
	 * ensure keyboard events are fired, consider using something like
	 * {@link #sendKeys(CharSequence...)} with the backspace key. To ensure you
	 * get a change event, consider following with a call to
	 * {@link #sendKeys(CharSequence...)} with the tab key.
	 * ------------------------------------------------------------------------
	 */
	public void clear() {
		waitElement(0);
		
		// Limpa o campo enviando BACKSPACE
		getElements().get(0).sendKeys(getValueToSend(Keys.chord(Keys.BACK_SPACE)));
	}

	@Override
	public String getText() {
		waitElementOnlyVisible(0);
		return getElements().get(0).getAttribute("value");
	}

}
