package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;

@ScreenMap(name = "Primefaces Select Checkbox Menu", location = "http://www.primefaces.org/showcase/ui/input/checkboxMenu.xhtml")
public class PrimefacesSelectCheckboxMenu {

	@ElementMap(name = "Select", locatorType = ElementLocatorType.XPath, locator = { "//*[@id='j_idt87:menu']/div[contains(@class, 'ui-selectcheckboxmenu-trigger')]", "//*[@id='j_idt87:menu_panel']/div/ul" })
	private Select select;
	
	@ElementMap(name = "Select Panel", locatorType = ElementLocatorType.XPath, locator = { "//*[@id='j_idt87:menu_panel']/div/ul" })
	private Select selectPanel;
	
	@ElementMap(name = "Submit", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt87:j_idt91']")
	private Button btnSubmit;

	@ElementMap(name = "Lista de Países", locatorType = ElementLocatorType.XPath, locator = "(//*[contains(@id, ':display')]/div/div)[1]")
	private Label listaPaises;

	@ElementMap(name = "Fechar", locatorType = ElementLocatorType.XPath, locator = "//*[@id='j_idt87:menu_panel']/div[1]/a")
	private Button fechar;
}