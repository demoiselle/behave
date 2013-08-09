package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import org.openqa.selenium.interactions.Actions;

import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

public class WebButton extends WebBase implements Button {

	public void click() {
		waitElement(0);
		
		// Clica
		getElements().get(0).click();
	}

	@Override
	public void mouseOver() {
		waitElement(0);
		
		// mouse over
		Actions actions = new Actions(getDriver());
		actions.moveToElement(getElements().get(0)).build().perform();
	}

}
