package br.gov.frameworkdemoiselle.behave.runner.ui;

public interface TextField extends Element {

	void sendKeys(CharSequence... keysToSend);

	void clear();
	
}
