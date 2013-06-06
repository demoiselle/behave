package br.gov.frameworkdemoiselle.behave.util;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

public class PropertiesLoaderUtilTest {

	@Test
	public void testGetInstance() {
		try {
			
			PropertiesLoaderUtil properties=PropertiesLoaderUtil.getInstance();
			assertNotNull(properties);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testGetProperties() {
		PropertiesLoaderUtil propertiesUtil;
		try {
			propertiesUtil = PropertiesLoaderUtil.getInstance();
			Properties properties=propertiesUtil.getProperties();
			assertNotNull(properties);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		
	}

}
