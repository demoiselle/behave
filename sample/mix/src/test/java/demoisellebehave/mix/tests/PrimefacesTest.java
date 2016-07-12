package demoisellebehave.mix.tests;

import org.junit.Test;

import demoisellebehave.mix.steps.MySteps;
import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class PrimefacesTest {

	private BehaveContext eng = null;

	public PrimefacesTest() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/primefaces/");
	}
}
