package br.gov.frameworkdemoiselle.behave.runner.fest;

import org.junit.Test;

public class FestRunnerTest {

	@Test
	public void testRun() {
		FestRunner runner=new FestRunner();
		
		runner.run(new Object());
		
		
	}

}
