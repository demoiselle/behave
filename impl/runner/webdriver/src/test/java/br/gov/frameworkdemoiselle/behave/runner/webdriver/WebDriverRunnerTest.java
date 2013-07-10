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
		runner.close();
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
