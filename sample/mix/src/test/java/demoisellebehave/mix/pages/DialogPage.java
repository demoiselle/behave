package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebButton;

@ScreenMap(name = "Alertas", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/alert.html")
public class DialogPage {
	
		@ElementMap(name = "Alerta", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Alerta']")
		private Button alert;

		@ElementMap(name = "Prompt", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Prompt']")
		private Button prompt;

		@ElementMap(name = "Confirm", locatorType = ElementLocatorType.XPath, locator = "//input[@value='Confirm']")
		private Button confirm;	
		
		@ElementMap(name = "Botao Sair", locatorType = ElementLocatorType.XPath, locator = "(//input[@value='Sair'][contains(@style, '%param1%')])")		
		private WebButton botaoSair;
}
