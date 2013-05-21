package br.gov.frameworkdemoiselle.behave.parser.imperative;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImperativeParserTest {

	@Test
	public void testRun() {
		ImperativeParser parser=new ImperativeParser();
		parser.run();
	}

}
