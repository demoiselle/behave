package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class FramesTest {

	private BehaveContext eng = null;

	public FramesTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void test() throws Throwable {
		eng.run("/stories/frames/");
	}
}
