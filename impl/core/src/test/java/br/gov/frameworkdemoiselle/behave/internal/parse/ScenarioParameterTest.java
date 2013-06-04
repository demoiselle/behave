package br.gov.frameworkdemoiselle.behave.internal.parse;

import org.junit.Test;
import org.mockito.Mockito;

public class ScenarioParameterTest {

	@Test
	public void testRemoveParameterNames() {
		
		ScenarioParameter.removeParameterNames("cenario1");
		
	}

	@Test
	public void testReplaceCallParameters() {
		Scenario scenario=Mockito.mock(Scenario.class);
		Mockito.when(scenario.getIdentification()).thenReturn("identification");
		ScenarioParameter.replaceCallParameters("cenario1", scenario);
	}

}
