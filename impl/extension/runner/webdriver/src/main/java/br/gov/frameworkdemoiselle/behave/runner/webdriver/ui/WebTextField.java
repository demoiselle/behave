package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class WebTextField extends WebMappedElement implements TextField {

	public void sendKeys(CharSequence... keysToSend) {
		getElement().sendKeys(keysToSend);
	}

	@Override
	public void clear() {
		getElement().clear();
	}

}
