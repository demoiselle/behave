package demoisellebehave.serpro.treino;

import java.util.ArrayList;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;

public class ComponentsTests {
	private BehaveContext eng = BehaveContext.getInstance();

	@Test
	public void testAllComponents() throws Throwable {
		ArrayList<String> stories = new ArrayList<String>();
		stories.add("/stories/acesso/acessar-sistema.story");
		stories.add("/stories/components/components.story");

		eng.run(stories);
	}

}