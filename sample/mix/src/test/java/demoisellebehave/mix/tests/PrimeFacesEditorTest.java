package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class PrimeFacesEditorTest {

	private BehaveContext eng = null;

	public PrimeFacesEditorTest() {
		eng = BehaveContext.getInstance();
	}


	@Test
	public void testPrimeEditor(){
		eng.run("/stories/primefaces/test_primefaces_showcase_Editor.story");
	}

}
