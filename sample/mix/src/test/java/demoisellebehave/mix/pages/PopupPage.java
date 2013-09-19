package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Principal de Pop-ups", location = "http://allwebco-templates.com/support/S_add_pop.htm")
public class PopupPage {

	@ElementMap(name = "link de popup", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Click here to see a sample']")
	private Link linkPopup;
	
	@ScreenMap(name = "Popup", location = "http://allwebco-templates.com/support/scripts/pop-up.html")
	public class Poup{
		
		@ElementMap(name = "Fechar Janeja", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Close Window']")
		private Button btClose;
		
	}

}



