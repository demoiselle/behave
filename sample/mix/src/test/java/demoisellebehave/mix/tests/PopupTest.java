package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class PopupTest {

	private BehaveContext eng = null;

	public PopupTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/popup/");
	}
}
