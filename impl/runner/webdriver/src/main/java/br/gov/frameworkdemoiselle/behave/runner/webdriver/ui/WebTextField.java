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

import org.openqa.selenium.Keys;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.runner.ui.StateUI;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class WebTextField extends WebBase implements TextField {

	public void sendKeys(CharSequence... keysToSend) {
		verifyState(StateUI.ENABLE);
		verifyState(StateUI.VISIBLE);

		getElements().get(0).sendKeys(keysToSend);
	}

	/**
	 * Função que tenta preencher mais de uma vez o campo. Ela verifica se o
	 * conteúdo enviado é o mesmo que esta atualmente no campo.
	 */
	public void sendKeysWithTries(CharSequence... keysToSend) {
		int totalMilliseconds = 0;
		while (!getElements().get(0).getAttribute("value").equals(keysToSend)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			Keys[] keys = new Keys[getElements().get(0).getAttribute("value").length()];
			for (int i = 0; i < keys.length; i++)
				keys[i] = Keys.BACK_SPACE;

			sendKeys(Keys.chord(keys), keysToSend.toString());

			totalMilliseconds += 1000;

			if (totalMilliseconds > BehaveConfig.getRunner_ScreenMaxWait())
				throw new RuntimeException("Limpeza de campo não concluída com sucesso.");
		}
	}

	public void clear() {
		verifyState(StateUI.ENABLE);
		verifyState(StateUI.VISIBLE);
		getElements().get(0).clear();
	}
	
	@Override
	public String getText() {
		waitElement(0);
		return getElements().get(0).getAttribute("value");
	}

}
