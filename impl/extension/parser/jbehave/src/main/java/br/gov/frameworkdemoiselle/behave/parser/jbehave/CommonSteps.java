package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbehave.core.annotations.Given;

public class CommonSteps {

	private Logger logger = Logger.getLogger(this.toString());

	@Given("vou para o endereço [$url]")
	public void goToUrl(String url) {
		logger.log(Level.INFO, "Go to URL: " + url);
	}

	@Given("clico em [$objeto]")
	public void click(String objeto) {
		logger.log(Level.INFO, "Click em " + objeto);
	}

}
