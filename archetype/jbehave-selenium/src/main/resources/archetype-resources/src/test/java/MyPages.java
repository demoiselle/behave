package ${packageName};

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;

public class MyPages {

	@ScreenMap(name = "dbehave", location = "http://dbehave.com")
	public class DBheave {
	}

	@ScreenMap(name = "Github", location = "https://github.com/demoiselle/behave")
	public class Main {

		@ElementMap(name = "Dúvidas e Questões", locatorType = ElementLocatorType.XPath, locator = "//a//span[./text()='Issues']")
		private Link linkIssues;

		@ElementMap(name = "uma dúvida", locatorType = ElementLocatorType.XPath, locator = "(//a[contains(@class, 'issue-title')])[2]")
		private Link linkIssue;
	}

	@ScreenMap(name = "Documentação", location = "http://demoiselle.sourceforge.net/docs/components/behave/reference/lastversion/html/index.html")
	public class Popup {

		@ElementMap(name = "Roteiro Rápido", locatorType = ElementLocatorType.XPath, locator = "//a[contains(./text(),'Roteiro Rápido')]")
		private Link linkRR;

		@ElementMap(name = "Link Principal", locatorType = ElementLocatorType.XPath, locator = "//a//strong[contains(./text(),'Principal')]")
		private Link linkP;

		@ElementMap(name = "Testes de Regressão", locatorType = ElementLocatorType.XPath, locator = "//a[contains(./text(),'Testes de Regressão')]")
		private Link lintTR;
	}

}
