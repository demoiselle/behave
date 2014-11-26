package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;

@ScreenMap(name = "Primefaces Select One Menu", location = "http://www.primefaces.org/showcase/ui/input/oneMenu.xhtml")
public class PrimefacesSelectOneMenu {

	@ElementMap(name = "Select", locatorType = ElementLocatorType.XPath, locator = { "//*[@id='j_idt88:console_label']", "//*[@id='j_idt88:console_panel']/div/ul" })
	private Select select;

}