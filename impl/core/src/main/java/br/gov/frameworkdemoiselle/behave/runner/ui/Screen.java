package br.gov.frameworkdemoiselle.behave.runner.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.base.BaseUI;

public interface Screen extends BaseUI {

	void waitText(String text);

	void waitText(String text, Long timeout);

}
