package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;

public class WebScreen extends WebBase implements Screen {

	private Logger logger = Logger.getLogger(this.toString());
	
	public void waitText(String text) {
		waitText(text, BehaveConfig.BROWSER_MAX_WAIT);
	}

	public void waitText(String text, Long timeout) {
		int totalMilliseconds = 0;
		while (!((WebDriver) runner.getDriver()).getPageSource().contains(text)) {
			try {
				logger.log(Level.FINE, "Aguardando o elemento [" + text + "]");
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
