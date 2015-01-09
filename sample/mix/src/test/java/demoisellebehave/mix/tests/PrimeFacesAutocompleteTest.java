package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class PrimeFacesAutocompleteTest {

	private BehaveContext eng = null;

	public PrimeFacesAutocompleteTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/primefaces/autocomplete.story");
	}
	
	@Test
	public void testComponent() throws Throwable {
		eng.run("/stories/primefaces/autocomplete_component.story");
	}

}
