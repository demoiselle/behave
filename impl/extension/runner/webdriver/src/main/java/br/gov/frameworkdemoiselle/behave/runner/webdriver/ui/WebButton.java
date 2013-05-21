package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

public class WebButton extends WebMappedElement implements Button {

	public void click() {
		getElement().click();
	}

}
