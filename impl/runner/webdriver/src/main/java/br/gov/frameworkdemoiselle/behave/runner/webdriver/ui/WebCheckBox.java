package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;

public class WebCheckBox extends WebBase implements CheckBox {

	public void click() {
		waitElement(0);
		
		getElements().get(0).click();
	}

}
