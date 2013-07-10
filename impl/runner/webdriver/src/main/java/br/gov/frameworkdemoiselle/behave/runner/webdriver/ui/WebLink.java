package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

public class WebLink extends WebBase implements Link
{
	public void click()
	{
		waitElement(0);
		// Clica
		getElements().get(0).click();
	}
}
