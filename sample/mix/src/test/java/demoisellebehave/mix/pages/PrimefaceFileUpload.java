package demoisellebehave.mix.pages;

import demoisellebehave.mix.ui.WebFileUpload;
import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;

@ScreenMap(name = "Upload Auto", location = "http://www.primefaces.org/showcase/ui/file/upload/auto.xhtml")
public class PrimefaceFileUpload {

	@ElementMap(name = "FileUpload", locatorType = ElementLocatorType.XPath, locator = "//input[@type='file']")
	private WebFileUpload richFileUpload;

}
