package demoisellebehave.mix.steps;

import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;

public class MySteps extends CommonSteps {
	
	@Then("expando o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenExpandNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.expandByLabel(label);
	}

	@Then("expando o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenExpandNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.expandByPath(path);
	}

	@Then("colapso o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenCollapseNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.collapseByPath(path);
	}

	@Then("colapso o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenCollapseNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.collapseByLabel(label);
	}

	@Then("seleciono o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenSelectNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.selectByLabel(label);
	}

	@Then("seleciono o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenSelectNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.selectByPath(path);
	}

	@Then("deseleciono o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenUnselectNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.unselectByLabel(label);
	}

	@Then("desseleciono o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenUnselectNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.unselectByPath(path);
	}

	@Then("alterno o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenToggleNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.toggleByLabel(label);
	}

	@Then("alterno o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenToggleNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.toggleByPath(path);
	}


}
