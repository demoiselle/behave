package br.gov.frameworkdemoiselle.behave.util;

import junit.framework.Assert;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Tela de Busca", location = "http://www.google.com.br")
public class ReflectionUtilTest {

	@ElementMap(name = "Campo de Busca", locatorType = ElementLocatorType.Id, locator = "gbqfq")
	private TextField searchField;

	@Test
	public void testGetLocation() {
		String location = ReflectionUtil.getLocation("Tela de Busca");
		Assert.assertEquals("http://www.google.com.br", location);

	}

	@Test
	public void testGetElementType() {
		@SuppressWarnings("rawtypes")
		Class type = ReflectionUtil.getElementType("Tela de Busca", "Campo de Busca");
		Assert.assertTrue(type.getName().contains("TextField"));
	}

	@Test
	public void testGetElementMap() {
		ElementMap element = ReflectionUtil.getElementMap("Tela de Busca", "Campo de Busca");
		Assert.assertTrue(element.toString().contains("name=Campo de Busca"));

	}

}
