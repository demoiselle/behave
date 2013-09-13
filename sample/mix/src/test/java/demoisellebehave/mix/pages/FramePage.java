package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Principal", location = "http://pic.dhe.ibm.com/infocenter/clmhelp/v4r0m4/index.jsp")
public class FramePage {

	@ElementMap(name = "Get started", locatorType = ElementLocatorType.XPath, locator = "//a[@href='../com.ibm.help.common.jazz.calm.doc/topics/c_get_started.html']")
	private Link link1;

}