package br.gov.frameworkdemoiselle.behave.runner.ui;

public interface Screen extends Element {

	void waitText(String text);
	
	void waitText(String text, Integer timeout);	
	
}
