package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.RichInputNumberSpinner;

@ScreenMap(name = "Showcase inputNumberSpinner", location = "http://showcase.richfaces.org/richfaces/component-sample.jsf?demo=inputNumberSpinner&skin=blueSky")
public class ShowcaseInputNumberSpinner {

	@ElementMap(name = "inputNumberSpinner", locatorType = ElementLocatorType.XPath, locator = "//span[contains(concat(\" \",@class,\" \"),\" rf-insp \")][1]")
	private RichInputNumberSpinner input;

}
