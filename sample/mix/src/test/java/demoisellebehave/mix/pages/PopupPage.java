package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Janela", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/windows.html")
public class PopupPage {

	@ElementMap(name = "link POP-up", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='POP-up']")
	private Link linkPopup;
	

}



