package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.runner.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ByConverter;

public class WebTextField extends MappedElement implements TextField {

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		WebElement element = (WebElement) ((WebDriver) runner.getDriver()).findElement(ByConverter.convert(getElementMap()));
		element.sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		WebElement element = (WebElement) ((WebDriver) runner.getDriver()).findElement(ByConverter.convert(getElementMap()));
		element.clear();
	}

}
