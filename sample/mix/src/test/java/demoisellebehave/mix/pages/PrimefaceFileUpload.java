package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebFileUpload;

@ScreenMap(name = "Upload Auto", location = "http://www.primefaces.org/showcase/ui/file/upload/auto.xhtml")
public class PrimefaceFileUpload {

	@ElementMap(name = "FileUpload", locatorType = ElementLocatorType.XPath, locator = "//input[@type='file']")
	private WebFileUpload richFileUpload;

}
