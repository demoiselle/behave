package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

public class WebButton extends WebBase implements Button {

	public void click() {
		waitElement(0);
		
		// Clica
		getElements().get(0).click();
	}

}
