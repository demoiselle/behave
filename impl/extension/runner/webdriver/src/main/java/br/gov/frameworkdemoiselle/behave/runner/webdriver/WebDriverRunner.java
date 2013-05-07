package br.gov.frameworkdemoiselle.behave.runner.webdriver;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.gov.frameworkdemoiselle.behave.runner.Runner;

public class WebDriverRunner implements Runner {

	private Logger logger = Logger.getLogger(this.toString());

	@Override
	public void run(Object... params) {
		logger.log(Level.INFO, "Rodou o RUNNER WebDriver");
	}

}
