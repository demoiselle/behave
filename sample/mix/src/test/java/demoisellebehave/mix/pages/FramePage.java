package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Teste de Frame", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/frame/frame.html")
public class FramePage {

	@ElementMap(name = "Sistema", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Sistema']")
	private Link sistema;
	
	@ElementMap(name = "Carros", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='--->Carros']")
	private Link carros;

	@ElementMap(name = "Motos", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='--->Motos']")
	private Link motos;

}