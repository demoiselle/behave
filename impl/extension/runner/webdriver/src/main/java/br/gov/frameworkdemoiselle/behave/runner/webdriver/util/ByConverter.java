package br.gov.frameworkdemoiselle.behave.runner.webdriver.util;

import org.openqa.selenium.By;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;

public class ByConverter {

	public static By convert(ElementLocatorType type, String locator) {
		By by = null;

		if (type == ElementLocatorType.Id) {
			by = By.id(locator);
		} else if (type == ElementLocatorType.ClassName) {
			by = By.className(locator);
		} else if (type == ElementLocatorType.CssSelector) {
			by = By.cssSelector(locator);
		} else if (type == ElementLocatorType.LinkText) {
			by = By.linkText(locator);
		} else if (type == ElementLocatorType.Name) {
			by = By.name(locator);
		} else if (type == ElementLocatorType.TagName) {
			by = By.tagName(locator);
		} else if (type == ElementLocatorType.XPath) {
			by = By.xpath(locator);
		} else {
			throw new RuntimeException("Locator Type não encontrado.");
		}

		return by;
	}

}
