package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class MouseOverTest {

	private BehaveContext eng = null;

	public MouseOverTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.run("/stories/movemouse/");
	}
}
