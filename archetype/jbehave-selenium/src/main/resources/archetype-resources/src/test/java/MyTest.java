package ${packageName};

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class MyTest {

	private BehaveContext eng = BehaveContext.getInstance();

	public MyTest() {
		eng.addSteps(new MySteps());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories");
	}

}
