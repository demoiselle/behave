package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class EmbeddedTest {

	private BehaveContext eng = null;

	public EmbeddedTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/embedded/");
	}
}
