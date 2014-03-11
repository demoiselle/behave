package ${packageName};

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class MyTest {

	private BehaveContext eng = BehaveContext.getInstance();

	@Test
	public void testAllObras() throws Throwable {
		eng.addStories("/stories");
		eng.run();
	}

}
