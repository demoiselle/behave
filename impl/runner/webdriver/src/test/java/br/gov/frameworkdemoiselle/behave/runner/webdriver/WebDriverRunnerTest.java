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

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Busca", location = "http://www.google.com.br")
public class WebDriverRunnerTest {

	@ElementMap(name = "Botao", locatorType = ElementLocatorType.Id, locator = "gbqfq")
	private TextField searchField;

	@Test
	public void testGetDriver() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);
		WebDriver driverActual = (WebDriver) runner.getDriver();

		Assert.assertEquals(driverExpected, driverActual);

	}

	@Test
	public void testNavigateTo() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		Navigation navigation = Mockito.mock(Navigation.class);
		Mockito.when(driverExpected.navigate()).thenReturn(navigation);
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		runner.navigateTo("http://www.google.com");

	}

	@Test
	public void testGet() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);

		Mockito.when(driverExpected.getCurrentUrl()).thenReturn("url");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		runner.get("url");
	}

	@Test
	public void testGetCurrentUrl() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);

		Mockito.when(driverExpected.getCurrentUrl()).thenReturn("url");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		Assert.assertEquals("url", runner.getCurrentUrl());
	}

	@Test
	public void testGetTitle() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		Mockito.when(driverExpected.getTitle()).thenReturn("title");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);
		String titulo = runner.getTitle();
		Assert.assertEquals("title", titulo);
	}

	@Test
	public void testGetElement() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);

		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		TextField field = (TextField) runner.getElement("Busca", "Botao");
		Assert.assertNotNull(field);
		Assert.assertTrue(field.toString().contains(".WebTextField"));
	}

	@Test(expected = RuntimeException.class)
	public void testGetElementEmptyPage() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);

		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		runner.getElement("", "Botao");
	}

	@Test(expected = RuntimeException.class)
	public void testGetElementNullElement() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);

		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		runner.getElement("Pagina", null);
	}

	@Test(expected = RuntimeException.class)
	public void testGetElementNullPage() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);

		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		runner.getElement(null, "Botao");
	}

	@Test
	public void testGetPageSource() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		Mockito.when(driverExpected.getPageSource()).thenReturn("source");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);

		String source = runner.getPageSource();

		Assert.assertEquals("source", source);
	}

	@Test
	public void testClose() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		Mockito.when(driverExpected.getPageSource()).thenReturn("source");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);
	}

	@Test
	public void testQuit() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		Mockito.when(driverExpected.getPageSource()).thenReturn("source");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);
		runner.quit();
	}

	@Test
	public void testGetScreen() {
		WebDriver driverExpected = Mockito.mock(WebDriver.class);
		Mockito.when(driverExpected.getPageSource()).thenReturn("source");
		WebDriverRunner runner = new WebDriverRunner();
		runner.setWebDriver(driverExpected);
		Screen screen = runner.getScreen();
		Assert.assertNotNull(screen);
	}

}
