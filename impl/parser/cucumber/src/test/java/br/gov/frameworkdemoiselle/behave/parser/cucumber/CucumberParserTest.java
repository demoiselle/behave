package br.gov.frameworkdemoiselle.behave.parser.cucumber;

import org.junit.Test;

public class CucumberParserTest {

	@Test
	public void testRun() {
		
		CucumberParser parser=new CucumberParser();
		
		parser.run();
	}

}
