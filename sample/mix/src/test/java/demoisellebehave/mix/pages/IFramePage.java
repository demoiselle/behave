package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Principal", location = "http://pic.dhe.ibm.com/infocenter/clmhelp/v4r0m4/index.jsp")
public class IFramePage {

	@ElementMap(name = "Rational Reporting 4.0.4", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='Rational Reporting 4.0.4']")
	private Link link1;

}