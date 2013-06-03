package br.gov.frameworkdemoiselle.behave.config;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;

public class BehaveConfigTest {
	
	@Test
	public void testGetProperty() {
		
	}

	@Test(expected=BehaveException.class)
	public void testGetPropertyNotExist() {
		
		BehaveConfig.getProperty("property1");
		
	}

	@Test
	public void testContains() {
		
	}

}
