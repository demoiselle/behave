package demoisellebehave.mix.tests;

import org.junit.Test;

import demoisellebehave.mix.steps.MySteps;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class TestPrimeFacesFileUpload {

	private BehaveContext eng = null;

	public TestPrimeFacesFileUpload() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories/primefaces/fileupload.story");
	}

}
