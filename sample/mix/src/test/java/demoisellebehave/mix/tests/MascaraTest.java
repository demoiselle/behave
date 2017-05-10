package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class MascaraTest {

	private BehaveContext eng = null;

	public MascaraTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void test() throws Throwable {
		eng.run("/stories/mascara/");
	}
}
