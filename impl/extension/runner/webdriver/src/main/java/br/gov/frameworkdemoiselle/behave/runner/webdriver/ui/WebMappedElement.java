package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.runner.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ByConverter;

public class WebMappedElement extends MappedElement {

	public WebElement getElement() {
		WebElement element = (WebElement) ((WebDriver) runner.getDriver()).findElement(ByConverter.convert(getElementMap()));
		return element;
	}
	
}