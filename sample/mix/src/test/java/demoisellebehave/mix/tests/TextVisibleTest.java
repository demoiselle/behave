package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class TextVisibleTest {

	private BehaveContext eng = null;

	public TextVisibleTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/text/");
	}
}
