package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.gov.frameworkdemoiselle.behave.runner.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;

public class WebScreen extends MappedElement implements Screen {

	public void waitText(String text) {
		/**
		 * TODO Paramatrizar o tempo
		 */
		waitText(text, 30000);
	}

	public void waitText(String text, Integer timeout) {
		int totalMilliseconds = 0;
		while (!((WebDriver) runner.getDriver()).getPageSource().contains(text)) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			totalMilliseconds += 1000;

			if (totalMilliseconds > timeout)
				Assert.fail("Texto não encontrado na tela. Texto: " + text);
		}
	}

}
