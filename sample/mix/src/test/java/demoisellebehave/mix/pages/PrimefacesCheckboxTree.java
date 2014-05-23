package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.primefaces.Tree;

@ScreenMap(name = "Primefaces Checkbox Tree", location = "http://www.primefaces.org/showcase/ui/data/tree/selection.xhtml")
public class PrimefacesCheckboxTree {

	@ElementMap(name = "árvore", locatorType = ElementLocatorType.Id, locator = "j_idt87:j_idt111")
	private Tree arvore;

}