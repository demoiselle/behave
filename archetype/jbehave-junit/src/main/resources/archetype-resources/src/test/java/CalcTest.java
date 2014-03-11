package ${packageName};

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class CalcTest {

	private BehaveContext eng = null;

	public CalcTest() {
		eng = BehaveContext.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories");
	}

}
