package ${packageName};

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveController;

public class MyTest {

	private BehaveController eng = null;

	public MyTest() {
		eng = BehaveController.getInstance();
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories");
	}

}
