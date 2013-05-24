package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.base.StateUI;

public class WebButton extends WebBase implements Button {

	public void click() {
		verifyState(StateUI.VISIBLE);
		verifyState(StateUI.ENABLE);
		
		getElements().get(0).click();
	}

}
