package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;

public class WebRadio extends WebBase implements Radio {

	public void click() {
		waitElement(0);

		getElements().get(0).click();
	}

}
