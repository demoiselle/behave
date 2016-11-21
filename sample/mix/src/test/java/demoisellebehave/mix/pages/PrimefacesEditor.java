package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.primefaces.PrimeFacesEditor;

@ScreenMap(name = "Primefaces Editor", location = "http://www.primefaces.org/showcase/ui/input/editor.xhtml")
public class PrimefacesEditor {

	@ElementMap(name = "Editor", locatorType = ElementLocatorType.XPath, locator = { "//*[@class='ui-editor ui-widget-content']/iframe" })
	private PrimeFacesEditor pfEditor;

}