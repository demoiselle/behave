package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class InputMaskPage {

	@ScreenMap(name = "Formulário com Máscaras do Primefaces", location = "http://www.primefaces.org/showcase/ui/input/inputMask.xhtml")
	public class InputMask {
		
		@ElementMap(name = "Data", locatorType = ElementLocatorType.XPath, locator = "//input[contains(@id, 'date')]")
		private TextField data;

		@ElementMap(name = "Telefone", locatorType = ElementLocatorType.XPath, locator = "(//input[contains(@id, 'phone')])[1]")
		private TextField telefone;
		
		@ElementMap(name = "Fax", locatorType = ElementLocatorType.XPath, locator = "(//input[contains(@id, 'phone')])[2]")
		private TextField fax;

		@ElementMap(name = "Id", locatorType = ElementLocatorType.XPath, locator = "//input[contains(@id, 'taxId')]")
		private TextField id;

		@ElementMap(name = "SSN", locatorType = ElementLocatorType.XPath, locator = "//input[contains(@id, 'ssn')]")
		private TextField ssn;
		
		@ElementMap(name = "Chave", locatorType = ElementLocatorType.XPath, locator = "//input[contains(@id, 'key')]")
		private TextField chave;		
		
		@ElementMap(name = "Submit", locatorType = ElementLocatorType.XPath, locator = "//button[contains(@type, 'submit')]")
		private Button submit;
		
	}


}
