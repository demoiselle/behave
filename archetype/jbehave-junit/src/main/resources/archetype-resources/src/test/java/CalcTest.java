package ${packageName};

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveController;

public class CalcTest {

	private BehaveController eng = null;

	public CalcTest() {
		eng = BehaveController.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories");
	}

}
