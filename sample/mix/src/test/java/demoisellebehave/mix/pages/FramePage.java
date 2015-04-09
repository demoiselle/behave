package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

@ScreenMap(name = "Javadoc do Hibernate", location = "http://docs.jboss.org/hibernate/orm/3.5/javadocs/")
public class FramePage {

	@ElementMap(name = "org.hibernate", locatorType = ElementLocatorType.XPath, locator = "//a[./text()='org.hibernate' and @target='packageFrame']")
	private Link link1;
	
	@ElementMap(name = "Cache", locatorType = ElementLocatorType.XPath, locator = "//a/i[./text()='Cache']")
	private Link link2;

}