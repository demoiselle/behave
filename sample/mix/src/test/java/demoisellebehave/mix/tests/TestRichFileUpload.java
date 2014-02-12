package demoisellebehave.mix.tests;

import org.junit.Test;

import demoisellebehave.mix.steps.MySteps;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class TestRichFileUpload {

	private BehaveContext eng = null;

	public TestRichFileUpload() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories/richfaces4/fileupload.story");
	}

}
