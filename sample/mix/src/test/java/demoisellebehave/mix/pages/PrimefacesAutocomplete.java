package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "ShowCase Autocomplete", location = "http://www.primefaces.org/showcase/ui/input/autoComplete.xhtml")
public class PrimefacesAutocomplete {

	@ElementMap(name = "Simple", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:acSimple_input']")
	private TextField txtSimple;

	@ElementMap(name = "DropDown", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:dd_input']")
	private TextField txtDropDown;

	@ElementMap(name = "Submit", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:j_idt117']")
	private Button btnSubmit;
	
	@ElementMap(name = "Label Simple", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:output']/tbody/tr[1]/td[2]")
	private Button labelSimple;
	
	@ElementMap(name = "Label DropDown", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:output']/tbody/tr[6]/td[2]")
	private Button labelDropDown;

}
