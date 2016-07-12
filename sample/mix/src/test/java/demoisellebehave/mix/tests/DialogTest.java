package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class DialogTest {

	private BehaveContext eng = null;

	public DialogTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/dialog/");
	}
}
