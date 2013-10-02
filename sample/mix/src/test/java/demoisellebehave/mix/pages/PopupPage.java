package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Janela", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/windows.html")
public class PopupPage {

	@ElementMap(name = "link POP-up", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='POP-up']")
	private Link linkPopup;

	@ElementMap(name = "Nova Guia", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Nova Guia']")
	private Link novaGuia;	

	@ScreenMap(name = "Nova Janela")
	public class Popup {

		@ElementMap(name = "Fechar", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Fechar']")
		private Link fechar;

	}

}
