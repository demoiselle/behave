package ${packageName};

import java.util.ArrayList;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.EngineController;

public class AppTest {

	@Test
	public void start() throws Throwable {
		ArrayList<String> stories = new ArrayList<String>();
//		stories.add("stories/acesso-sistema.story");
//		stories.add("stories/pedido.story");
		stories.add("/stories");

		EngineController eng = new EngineController();

		eng.addSteps(new MySteps());

		eng.run(stories);
	}

	public static void main(String[] args) throws Throwable {
		AppTest app = new AppTest();
		app.start();
	}

}
