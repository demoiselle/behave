package ${packageName};

import java.util.ArrayList;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.EngineController;

public class MyTest {

	@Test
	public void testAllStories() throws Throwable {
		ArrayList<String> stories = new ArrayList<String>();
		stories.add("/stories");

		EngineController eng = new EngineController();
		eng.addSteps(new MySteps());
		eng.run(stories);
	}	

}
