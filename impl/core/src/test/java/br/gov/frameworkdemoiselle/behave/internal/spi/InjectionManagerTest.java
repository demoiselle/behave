package br.gov.frameworkdemoiselle.behave.internal.spi;

import static org.junit.Assert.assertNotNull;

import java.util.Hashtable;

import org.junit.Test;
import org.mockito.Mockito;

import br.gov.frameworkdemoiselle.behave.parser.Parser;

public class InjectionManagerTest {

	@Test
	public void testGetInstance() {
		InjectionManager injectionManager=InjectionManager.getInstance();
		assertNotNull(injectionManager);
		
		
	}


	@Test
	public void testGetInstanceDependecy() {
		
		InjectionManager injectionManager=InjectionManager.getInstance();
		assertNotNull(injectionManager);
		@SuppressWarnings({ "unchecked" })
		Hashtable<String, Object> singletons=Mockito.mock(Hashtable.class);
		Mockito.when(singletons.containsKey(Mockito.anyObject())).thenReturn(true);
		injectionManager.setSingletons(singletons);
		injectionManager.getInstanceDependecy(Parser.class);
		
	}

}
