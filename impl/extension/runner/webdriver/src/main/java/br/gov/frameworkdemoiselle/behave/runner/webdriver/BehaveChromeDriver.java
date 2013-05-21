package br.gov.frameworkdemoiselle.behave.runner.webdriver;

import org.openqa.selenium.chrome.ChromeDriver;

import br.gov.frameworkdemoiselle.behave.runner.BehaveDriver;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

public class BehaveChromeDriver extends ChromeDriver implements BehaveDriver {

	/**
	 * TODO: os métodos que não estão implementados são pq irão utilizar as
	 * anotações Page e Field
	 */

	public BehaveChromeDriver() {
		super();
	}

	@Override
	public Element getElement(String name) {
		return null;
	}

	@Override
	public Element getElement(String pageName, String elementName) {
		return null;
	}

	public void navigateTo(String url) {
		Navigation nav = super.navigate();
		nav.to(url);
	}

}
