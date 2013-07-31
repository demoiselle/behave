package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;

public class WebSelect extends WebBase implements Select {

	/**
	 * Select all options that display text matching the argument. That is, when
	 * given "Bar" this would select an option like: <option
	 * value="foo">Bar</option> text.
	 * 
	 * @param valueThe
	 *            visible text to match against
	 */
	public void selectByVisibleText(String value) {
		if (getElements().get(0).getTagName().equals("select")) {
			// Select comum e usa um helper do selenium
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));
			lSelect.selectByVisibleText(value);
		} else {

			// Aguarda o primeiro elemento ser clicável
			waitElement(0);

			// Outros tipos de select como a do primefaces
			WebElement elementMain = getElements().get(0);
			elementMain.click();

			List<WebElement> elementValue = getElements().get(1).findElements(By.tagName("li"));
			for (WebElement item : elementValue) {
				if (item.getText().equals(value)) {
					// Aguarda o segundo elemento ser clicável
					waitElement(1);
					item.click();
					break;
				}
			}
		}

	}

	/**
	 * Select the option at the given index. This is done by examing the "index"
	 * attribute of an element, and not merely by counting.
	 * 
	 * @param index
	 *            The option at this index will be selected
	 */
	public void selectByIndex(int index) {
		if (getElements().get(0).getTagName().equals("select")) {
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));
			lSelect.selectByIndex(index);
		} else {
			throw new BehaveException("Passo suportado apenas para tag Select.");
		}
	}

	/**
	 * Select all options that have a value matching the argument. That is, when
	 * given "foo" this would select an option like: <option
	 * value="foo">Bar</option>
	 * 
	 * @param value
	 *            The value to match against
	 */
	public void selectByValue(String value) {
		if (getElements().get(0).getTagName().equals("select")) {
			org.openqa.selenium.support.ui.Select lSelect = new org.openqa.selenium.support.ui.Select(getElements().get(0));
			lSelect.selectByValue(value);
		} else {
			throw new BehaveException("Passo suportado apenas para tag Select.");
		}
	}

}
