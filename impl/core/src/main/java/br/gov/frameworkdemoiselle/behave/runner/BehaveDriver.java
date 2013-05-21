package br.gov.frameworkdemoiselle.behave.runner;

import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

public interface BehaveDriver {

	void get(String url);

	void navigateTo(String url);

	String getCurrentUrl();

	String getTitle();

	Element getElement(String name);

	Element getElement(String pageName, String elementName);

	String getPageSource();

	void close();

	void quit();

}
