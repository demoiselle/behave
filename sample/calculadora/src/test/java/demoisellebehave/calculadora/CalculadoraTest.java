package demoisellebehave.calculadora;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveController;

public class CalculadoraTest {

	private BehaveController eng = null;

	public CalculadoraTest() {
		eng = BehaveController.getInstance();
		eng.addSteps(new MeusPassos());
	}

	@Test
	public void testAllStories() throws Throwable {
		eng.run("/stories");
	}

}
