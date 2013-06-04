package br.gov.frameworkdemoiselle.behave.config;

import java.util.Enumeration;
import java.util.Properties;

import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;
import org.mockito.Mockito;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.util.PropertiesLoaderUtil;

public class BehaveConfigTest {
	
		
	
/*

	
	@Test
	public void testGetProperty() {
		  new MockUp<PropertiesLoaderUtil>() {
			
				@Mock(invocations=1)
				public Properties getProperties() {
					Properties properties=Mockito.mock(Properties.class);
					Mockito.when(properties.containsKey(Mockito.anyObject())).thenReturn(true);
					Mockito.when(properties.keys()).thenReturn(new Enumeration<Object>() {
						
						@Override
						public Object nextElement() {
							// TODO Auto-generated method stub
							return null;
						}
						
						@Override
						public boolean hasMoreElements() {
							// TODO Auto-generated method stub
							return false;
						}
					});
					
					return properties;
				}
			
			  
		  };
		
		
		BehaveConfig.getProperty("property1");
		
	}

	@Test(expected=BehaveException.class)
	public void testGetPropertyNotExist() {
		Properties properties=Mockito.mock(Properties.class);
		Mockito.when(properties.containsKey(Mockito.anyObject())).thenReturn(false);
		BehaveConfig.properties=properties;

		BehaveConfig.getProperty("property1");
		
	}

	@Test
	public void testContains() {
		
	}
*/
}
