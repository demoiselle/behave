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

import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.SwitchDriver;

public class WebScreen extends WebBase implements Screen {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);

	private SwitchDriver frame;
	private WebDriver driver;

	public void waitText(String text) {
		waitText(text, BehaveConfig.getRunner_ScreenMaxWait());
	}

	/**
	 * Neste método waitText estamos forçando que seja verificado dentro do body
	 * através de um loop controlado por nós e não pelo implicityWait do
	 * Webdriver. Por isso zeramos o implicityWait e depois voltamos para o
	 * valor padrão das propriedades.
	 */
	public void waitText(String text, Long timeout) {
		try {
			boolean found = false;

			driver = (WebDriver) runner.getDriver();
			frame = new SwitchDriver(driver);
			long startedTime = GregorianCalendar.getInstance().getTimeInMillis();

			while (true) {
				frame.bind();
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
				for (int i = 0; i < frame.countFrames(); i++) {
					frame.switchNextFrame();
					List<WebElement> elements = driver.findElements(By.tagName("body"));
					if (elements.size() > 0) {
						if (elements.get(0).getText().contains(text)) {
							found = true;
							break;
						}
					} else {
						if (driver.getPageSource().contains(text)) {
							found = true;
							break;
						}
					}
				}
				driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
				if (found) {
					break;
				}
				Thread.sleep(BehaveConfig.getRunner_ScreenMinWait());
				if (GregorianCalendar.getInstance().getTimeInMillis() - startedTime > BehaveConfig.getRunner_ScreenMaxWait()) {
					Assert.fail(message.getString("message-text-not-found", text));
				}
			}
		} catch (BehaveException be) {
			throw be;
		} catch (NoSuchFrameException ex) {
			throw new BehaveException(message.getString("exception-no-such-frame", frame.currentFrame(), ex));
		} catch (InterruptedException e) {
			throw new BehaveException(message.getString("exception-thread-sleep"), e);
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-unexpected", e.getMessage()), e);
		}
	}

}
