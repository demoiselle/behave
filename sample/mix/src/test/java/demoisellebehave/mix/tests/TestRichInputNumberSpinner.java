package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import demoisellebehave.mix.steps.MySteps;

public class TestRichInputNumberSpinner {

	private BehaveContext eng = null;

	public TestRichInputNumberSpinner() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories/richfaces4/inputNumberSpinner.story");
	}

}
