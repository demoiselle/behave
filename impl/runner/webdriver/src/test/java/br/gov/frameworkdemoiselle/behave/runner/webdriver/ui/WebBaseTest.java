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

import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.runner.Runner;

public class WebBaseTest {

	@Test
	@Ignore
	public void testGetElements() {
		WebDriver driver = Mockito.mock(WebDriver.class);

		Runner runner = Mockito.mock(Runner.class);
		Mockito.when(runner.getDriver()).thenReturn(driver);

		WebBase webBase = new WebBase();
		ElementMap mapa = Mockito.mock(ElementMap.class);
		Mockito.when(mapa.locator()).thenReturn(new String[] { "ID" });
		Mockito.when(mapa.locatorType()).thenReturn(ElementLocatorType.XPath);

		webBase.setElementMap(mapa);
		webBase.setRunner(runner);

		List<WebElement> lista = webBase.getElements();
		assertTrue(lista.size() > 0);
	}

	@Test
	@Ignore
	public void testGetText() {
		WebElement element = Mockito.mock(WebElement.class);
		WebDriver driver = Mockito.mock(WebDriver.class);
		Mockito.when(driver.findElement((By) Mockito.anyObject())).thenReturn(element);
		Runner runner = Mockito.mock(Runner.class);
		Mockito.when(runner.getDriver()).thenReturn(driver);
		WebBase webBase = new WebBase();
		ElementMap mapa = Mockito.mock(ElementMap.class);
		Mockito.when(mapa.locator()).thenReturn(new String[] { "ID" });
		Mockito.when(mapa.locatorType()).thenReturn(ElementLocatorType.XPath);

		webBase.setRunner(runner);
		webBase.setElementMap(mapa);
	}

	@Test
	@Ignore
	public void testVerifyState() {
		WebElement element = Mockito.mock(WebElement.class);
		Mockito.when(element.isDisplayed()).thenReturn(true);
		WebDriver driver = Mockito.mock(WebDriver.class);
		Mockito.when(driver.findElement((By) Mockito.anyObject())).thenReturn(element);
		Runner runner = Mockito.mock(Runner.class);
		Mockito.when(runner.getDriver()).thenReturn(driver);
		WebBase webBase = new WebBase();
		ElementMap mapa = Mockito.mock(ElementMap.class);
		Mockito.when(mapa.locator()).thenReturn(new String[] { "ID" });
		Mockito.when(mapa.locatorType()).thenReturn(ElementLocatorType.XPath);

		webBase.setRunner(runner);
		webBase.setElementMap(mapa);
	}

	@Test
	@Ignore
	public void testWaitElement() {
		WebElement element = Mockito.mock(WebElement.class);
		Mockito.when(element.isDisplayed()).thenReturn(true);
		WebDriver driver = Mockito.mock(WebDriver.class);
		Mockito.when(driver.findElement((By) Mockito.anyObject())).thenReturn(element);
		Runner runner = Mockito.mock(Runner.class);
		Mockito.when(runner.getDriver()).thenReturn(driver);
		WebBase webBase = new WebBase();
		ElementMap mapa = Mockito.mock(ElementMap.class);
		Mockito.when(mapa.locator()).thenReturn(new String[] { "ID" });
		Mockito.when(mapa.locatorType()).thenReturn(ElementLocatorType.XPath);

		webBase.setRunner(runner);
		webBase.setElementMap(mapa);
		webBase.waitElement(1);
	}

	@Test
	public void testGetDriver() {
		WebElement element = Mockito.mock(WebElement.class);
		Mockito.when(element.isDisplayed()).thenReturn(true);
		WebDriver driver = Mockito.mock(WebDriver.class);
		Mockito.when(driver.findElement((By) Mockito.anyObject())).thenReturn(element);
		Runner runner = Mockito.mock(Runner.class);
		Mockito.when(runner.getDriver()).thenReturn(driver);
		WebBase webBase = new WebBase();
		ElementMap mapa = Mockito.mock(ElementMap.class);
		Mockito.when(mapa.locator()).thenReturn(new String[] { "ID" });
		Mockito.when(mapa.locatorType()).thenReturn(ElementLocatorType.XPath);

		webBase.setRunner(runner);
		webBase.setElementMap(mapa);
		WebDriver driverActual = webBase.getDriver();
		Assert.assertEquals(driver, driverActual);
	}

}
