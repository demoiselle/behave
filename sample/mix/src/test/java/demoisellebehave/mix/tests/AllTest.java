package demoisellebehave.mix.tests;

import org.junit.Test;

import demoisellebehave.mix.steps.DialogSteps;
import demoisellebehave.mix.steps.MySteps;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class AllTest {

	private BehaveContext eng = null;

	public AllTest() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
		eng.addSteps(new DialogSteps());
	}

	@Test
	public void testFrames() throws Throwable {
		eng.run("/stories/frames/frames.story");
	}

	@Test
	public void testIFrames() throws Throwable {
		eng.run("/stories/frames/iframes.story");
	}
	
	@Test
	public void testPopup() throws Throwable {
		eng.run("/stories/popup/popup.story");
	}
	
	@Test
	public void testDialog() throws Throwable {
		eng.run("/stories/dialog/dialog.story");
	}

}
