package demoisellebehave.mix.tests;

import org.junit.Test;

import demoisellebehave.mix.steps.MySteps;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class FrameTest {

	private BehaveContext eng = null;

	public FrameTest() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testFrames() throws Throwable {
		eng.run("/stories/frames/frames.story");
	}

	@Test
	public void testIFrames() throws Throwable {
		eng.run("/stories/frames/iframes.story");
	}

}
