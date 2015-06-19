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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.util.WebBrowser;

public class WebDriverRunner implements Runner {

	private Logger logger = Logger.getLogger(WebDriverRunner.class);
	private WebDriver driver;
	private WebBrowser browser;
	public static String MESSAGEBUNDLE = "demoiselle-runner-webdriver-bundle";
	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);

	void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	public Object getDriver() {
		if (driver == null) {
			browser = Enum.valueOf(WebBrowser.class, BehaveConfig.getRunner_ScreenType());
			driver = browser.getWebDriver();
			if (BehaveConfig.getRunner_WindowMaximizeEnabled()) {
				driver.manage().window().maximize();
			}
			logger.debug(message.getString("message-webdriver-started", browser.toString()));
			try {
				driver.manage().timeouts().pageLoadTimeout(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
				driver.manage().timeouts().implicitlyWait(BehaveConfig.getRunner_ScreenMaxWait(), TimeUnit.MILLISECONDS);
			} catch (UnsupportedCommandException e) {
				logger.error(message.getString("message-configure-timeout", browser.toString()), e);
			}
		}
		return driver;
	}

	public void start() {
		driver = null;
		getDriver();
	}

	public void navigateTo(String url) {
		try {
			logger.debug(message.getString("message-try-access", url));
			setDefaultWindow();
			driver.navigate().to(url);
		} catch (WebDriverException cause) {
			throw new BehaveException(message.getString("exception-navigate-to", url), cause);
		}
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

		if ((currentPageName == null) || (currentPageName.equals(""))) {
			throw new BehaveException(message.getString("exception-page-not-selected"));
		}

		Field f = ReflectionUtil.getElementMap(currentPageName, elementName);
		ElementMap map = f.getAnnotation(ElementMap.class);
		Class<?> clazz = f.getType();

		Element element = null;
		// Comportamento padrão usa o InjectionManager para resolver quem
		// implementa a interface
		if (clazz.isInterface()) {
			element = (Element) InjectionManager.getInstance().getInstanceDependecy(clazz);
			// Instancia a classe fornecida explicitamente como implementação da
			// interface Element
		} else if (Element.class.isAssignableFrom(clazz)) {
			try {
				element = (Element) clazz.newInstance();
			} catch (Exception e) {
				element = null;
			}
		} else {
			throw new BehaveException(message.getString("exception-class-not-element", clazz.getName(), elementName, currentPageName));
		}

		if (element == null) {
			throw new BehaveException(message.getString("exception-instance-element", elementName, currentPageName));
		}

		element.setElementMap(map);

		return element;
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		setDefaultWindow();
		if (browser.equals(WebBrowser.GoogleChrome)) {
			return;
		}
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public Screen getScreen() {
		return (Screen) InjectionManager.getInstance().getInstanceDependecy(Screen.class);
	}

	public File saveScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	}

	public File saveScreenshotTo(String fileName) {
		return saveScreenshotTo(fileName, true);
	}

	public File saveScreenshotTo(String fileName, boolean generateSource) {
		File screenshotFile = new File(fileName);

		screenshotFile.getParentFile().mkdirs();

		driver.manage().window().maximize();

		File screenshot = null;

		if (BehaveConfig.getRunner_screenShotZoomout() != 0) {
			WebElement html = driver.findElement(By.tagName("html"));

			for (int x = 0; x < BehaveConfig.getRunner_screenShotZoomout(); x++) {
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
			}

			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			html.sendKeys(Keys.chord(Keys.CONTROL, "0"));
		} else {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		}

		if (screenshot != null) {
			try {
				FileUtils.copyFile(screenshot, new File(screenshotFile.getAbsolutePath()));

				if (generateSource) {
					writeHtmlFile(screenshotFile.getAbsolutePath());
				}
			} catch (IOException e) {
				throw new BehaveException(message.getString("exception-save-screenshot"), e);
			}
		}

		return screenshotFile;
	}

	private void writeHtmlFile(String path) {
		try {
			File file = new File(path + ".html");
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
			Writer w = new BufferedWriter(osw);
			w.write(this.driver.getPageSource());
			w.close();
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-save-screenshot"), e);
		}
	}

	public void setScreen(String screenName) {
		String location;

		try {
			location = ReflectionUtil.getLocation(screenName);
		} catch (Exception ex) {
			location = "";
		}

		Set<String> lWindowHandles = driver.getWindowHandles();
		for (String lWindowHandle : lWindowHandles) {
			WebDriver lWindow = driver.switchTo().window(lWindowHandle);
			if (!location.isEmpty() && lWindow.getCurrentUrl().equalsIgnoreCase(location)) {
				return;
			}
			if (lWindow.getTitle().toUpperCase().indexOf(screenName.toUpperCase()) >= 0) {
				return;
			}
		}
	}

	private void setDefaultWindow() {
		Set<String> lWindowHandles = driver.getWindowHandles();
		for (String lWindowHandle : lWindowHandles) {
			driver.switchTo().window(lWindowHandle);
			return;
		}
	}

}
