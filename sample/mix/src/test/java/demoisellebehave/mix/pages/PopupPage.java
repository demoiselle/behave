package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

public class PopupPage {

	@ScreenMap(name = "Janela", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/windows.html")
	public class Main {
		@ElementMap(name = "link POP-up", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='POP-up']")
		private Link linkPopup;

		@ElementMap(name = "Nova Guia", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Nova Guia']")
		private Link novaGuia;

	}

	@ScreenMap(name = "Outra Janela", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/new_window.html")
	public class Popup {

		@ElementMap(name = "Fechar", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Fechar']")
		private Link fechar;

		@ElementMap(name = "DBehave", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='DBehave']")
		private Link dbehave;

	}

	@ScreenMap(name = "demoiselle/behave")
	public class DBehave {

		@ElementMap(name = "Wiki", locatorType = ElementLocatorType.XPath, locator = "//a/span[./text()='Wiki']")
		private Link wiki;

	}

}
