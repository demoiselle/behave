package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class PrimeFacesInputTest {

	private BehaveContext eng = null;

	public PrimeFacesInputTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/primefaces/input.story");
	}
}
