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

import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.WebBrowser;

public class WebDriverRunner implements Runner {

	private Logger logger = Logger.getLogger(WebDriverRunner.class);
	private WebDriver driver;
	private WebBrowser browser;

	void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Object getDriver() {
		if (driver == null) {
			browser = Enum.valueOf(WebBrowser.class, BehaveConfig.getRunner_ScreenType());

			// Uso opicionao do proxy
			if (!BehaveConfig.getRunner_ProxyEnabled()) {
				driver = browser.getWebDriver();
			} else {
				Proxy proxy = new Proxy();
				proxy.setProxyType(Proxy.ProxyType.PAC);
				proxy.setProxyAutoconfigUrl(BehaveConfig.getRunner_ProxyURL());
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.PROXY, proxy);
				driver = new FirefoxDriver(capabilities);
			}

			logger.debug("Iniciou o driver - " + browser.toString());

			// Configurações do driver
			try{
				driver.manage().timeouts().pageLoadTimeout(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
				driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
			}catch(UnsupportedCommandException e){
				logger.error("Não foi possível configurar o timeout do [" + browser.toString() +"]");
				logger.debug(e);
			}
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

		if ((currentPageName == null) || (currentPageName.equals("")))
			throw new RuntimeException("Não existe página selecionada.");

		ElementMap map = ReflectionUtil.getElementMap(currentPageName, elementName);

		Class<?> clazz = ReflectionUtil.getElementType(currentPageName, elementName);

		// Exige que a classe seja uma interface
		if (!clazz.isInterface())
			throw new RuntimeException("A class [" + clazz.getName() + "] no elemento [" + elementName + "] da página [" + currentPageName + "] não é uma interface.");

		Element element = null;
		// Comportamento padrão usa o InjectionManager para resolver quem implementa a interface
		if( map.implementedBy().equals( InjectionManager.class ) )
			element = (Element) InjectionManager.getInstance().getInstanceDependecy(clazz);
		// Instancia a classe fornecida explicitamente como implementação da interface
		else {
			// Garante que a classe fornecida realmente implementa a interface Element
			if( ! Element.class.isAssignableFrom( map.implementedBy() ) )
				throw new RuntimeException("A class [" + map.implementedBy().getName() + "] no elemento [" + elementName + "] da página [" + currentPageName + "] não é uma interface para 'Element'.");
			try {
				element = (Element) map.implementedBy().newInstance();
			} catch (Exception e) {
				element = null;
			} 
		}
		if( element == null )
			throw new RuntimeException("Não foi possível instanciar o elemento [" + elementName + "] da página [" + currentPageName + "].");
			
		element.setElementMap(map);

		return element;
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		if (browser.equals(WebBrowser.GoogleChrome)) return;
		driver.close();
	}

	public void quit() {			
		driver.quit();
	}

	public Screen getScreen() {
		return (Screen) InjectionManager.getInstance().getInstanceDependecy(Screen.class);
	}

}
