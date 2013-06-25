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
import br.gov.frameworkdemoiselle.behave.runner.ui.base.StateUI;

public class WebBaseTest {

	@Test
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
		// String text = webBase.getText();

	}

	@Test
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
		webBase.verifyState(StateUI.VISIBLE);

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
