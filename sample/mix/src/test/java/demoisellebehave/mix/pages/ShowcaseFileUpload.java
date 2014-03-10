package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.RichFileUpload;

@ScreenMap(name = "Showcase FileUpload", location = "http://showcase.richfaces.org/richfaces/component-sample.jsf?demo=fileUpload&skin=blueSky")
public class ShowcaseFileUpload {

	@ElementMap(name = "FileUpload", locatorType = ElementLocatorType.CssSelector, locator = "div.rf-fu")
	private RichFileUpload richFileUpload;

}
