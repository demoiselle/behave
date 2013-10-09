package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

@ScreenMap(name = "Alertas", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/alert.html")
public class DialogPage {
	
		@ElementMap(name = "Alerta", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Alerta']")
		private Button alert;

		@ElementMap(name = "Prompt", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Prompt']")
		private Button prompt;

		@ElementMap(name = "Confirm", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Confirm']")
		private Button confirm;	
}
