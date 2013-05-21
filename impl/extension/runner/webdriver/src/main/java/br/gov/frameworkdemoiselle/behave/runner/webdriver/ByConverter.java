package br.gov.frameworkdemoiselle.behave.runner.webdriver;

import org.openqa.selenium.By;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;

public class ByConverter {

	public static By convert(ElementMap map) {
		By by = null;

		if (map.locatorType() == ElementLocatorType.Id) {
			by = By.id(map.locator());
		} else if (map.locatorType() == ElementLocatorType.ClassName) {
			by = By.className(map.locator());
		} else if (map.locatorType() == ElementLocatorType.CssSelector) {
			by = By.cssSelector(map.locator());
		} else if (map.locatorType() == ElementLocatorType.LinkText) {
			by = By.linkText(map.locator());
		} else if (map.locatorType() == ElementLocatorType.Name) {
			by = By.name(map.locator());
		} else if (map.locatorType() == ElementLocatorType.TagName) {
			by = By.tagName(map.locator());
		} else if (map.locatorType() == ElementLocatorType.XPath) {
			by = By.xpath(map.locator());
		} else {
			throw new RuntimeException("Locator Type não encontrado.");
		}

		return by;
	}

}
