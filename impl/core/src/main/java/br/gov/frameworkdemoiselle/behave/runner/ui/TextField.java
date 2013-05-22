package br.gov.frameworkdemoiselle.behave.runner.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.base.BaseUI;

public interface TextField extends BaseUI {

	void sendKeys(CharSequence... keysToSend);

	void clear();

}
