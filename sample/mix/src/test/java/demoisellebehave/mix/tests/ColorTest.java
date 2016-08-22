package demoisellebehave.mix.tests;

import org.junit.Test;

import demoisellebehave.mix.steps.MySteps;
import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class ColorTest {

	private BehaveContext eng = null;

	public ColorTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.addSteps(new MySteps());
		eng.run("/stories/color/");
	}
}
