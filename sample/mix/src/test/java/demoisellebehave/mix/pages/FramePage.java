package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Principal", location = "http://pic.dhe.ibm.com/infocenter/clmhelp/v4r0m4/index.jsp")
public class FramePage {
	
//	@Frame(name="frame01")
	@ElementMap(name = "Introdução ao Rational Solution for CLM", locatorType = ElementLocatorType.XPath, locator = "id('tree_root')/x:div[1]/x:div/x:div[1]/x:div/x:div[3]/x:span/x:a")
	private Link link1;
	@ElementMap(name = "Introdução ao Gerenciamento de Mudança", locatorType = ElementLocatorType.XPath, locator = "id('c_get_started')/x:div[3]/x:div/x:div[1]/x:a")
	private Link link2;
}
