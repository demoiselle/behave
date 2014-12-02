package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.AutoComplete;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

@ScreenMap(name = "ShowCase Autocomplete Component", location = "http://www.primefaces.org/showcase/ui/input/autoComplete.xhtml")
public class PrimefacesAutocompleteComponent {

	@ElementMap(name = "Simple", locatorType = ElementLocatorType.XPath, locator = {"//*[@id='j_idt88:acSimple_input']","//*[@id='j_idt88:acSimple_panel']"})
	private AutoComplete completeSimple;
	
	@ElementMap(name = "DropDown", locatorType = ElementLocatorType.XPath, locator = {"//*[@id='j_idt88:dd_input']","//*[@id='j_idt88:dd_panel']"})
	private AutoComplete completeDropdown;

	@ElementMap(name = "Submit", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:j_idt117']")
	private Button btnSubmit;
	
	@ElementMap(name = "Label Simple", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:output']/tbody/tr[1]/td[2]")
	private Button labelSimple;
	
	@ElementMap(name = "Label DropDown", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt88:output']/tbody/tr[6]/td[2]")
	private Button labelDropDown;

}