package demoisellebehave.mix.tests;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.internal.filter.StoryOrScenarioFilter;

public class PrimeFacesInputTest {

	private BehaveContext eng = null;

	public PrimeFacesInputTest() {
		eng = BehaveContext.getInstance();
	}

	@Test
	public void testTree() throws Throwable {
		eng.setStoryOrScenarioFilter(StoryOrScenarioFilter.scenario("Preenchendo o select checkbox menu"));
		eng.run("/stories/primefaces/input.story");
	}
}
