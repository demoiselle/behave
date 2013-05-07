package br.gov.frameworkdemoiselle.behave.parser.cucumber;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.gov.frameworkdemoiselle.behave.parser.Parser;

public class CucumberParser implements Parser {

	private Logger logger = Logger.getLogger(this.toString());

	@Override
	public void run() {
		logger.log(Level.INFO, "Rodou o PARSER Cucumber");
	}

	@Override
	public List<String> storyPaths() {
		return null;
	}

}
