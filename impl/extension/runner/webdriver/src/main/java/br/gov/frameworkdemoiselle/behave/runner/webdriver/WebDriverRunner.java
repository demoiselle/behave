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
package br.gov.frameworkdemoiselle.behave.runner.webdriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.ui.base.Element;
import br.gov.frameworkdemoiselle.behave.util.ReflectionUtil;

public class WebDriverRunner implements Runner {

	private Logger logger = Logger.getLogger(this.toString());
	private WebDriver driver;

	public Object getDriver() {
		if (driver == null) {
			logger.info("Iniciou o driver");

			// Versão diferente de firefox
			// File pathToBinary = new
			// File("/home/00968514901/Desktop/navegador/firefox/firefox");
			// FirefoxBinary bin = new FirefoxBinary(pathToBinary);
			// driver = new FirefoxDriver(bin, new FirefoxProfile());

			// driver = new ChromeDriver();
			driver = new FirefoxDriver();

			driver.manage().timeouts().implicitlyWait(BehaveConfig.BROWSER_MAX_WAIT, TimeUnit.MILLISECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void start() {
		driver = null;
		getDriver();
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void get(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public Element getElement(String currentPageName, String elementName) {

		if (currentPageName.equals(""))
			throw new RuntimeException("Não existe página selecionada.");

		ElementMap map = ReflectionUtil.getElementMap(currentPageName, elementName);

		Class<?> clazz = ReflectionUtil.getElementType(currentPageName, elementName);

		if (!clazz.isInterface())
			throw new RuntimeException("A class [" + clazz.getName() + "] no elemento [" + elementName + "] da página [" + currentPageName + "] não é uma interface.");

		Element element = (Element) InjectionManager.getInstance().getInstanceDependecy(clazz);
		element.setElementMap(map);

		return element;
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public Screen getScreen() {
		return (Screen) InjectionManager.getInstance().getInstanceDependecy(Screen.class);
	}

}
