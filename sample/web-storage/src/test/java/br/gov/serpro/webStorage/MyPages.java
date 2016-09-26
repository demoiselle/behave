package br.gov.serpro.webStorage;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class MyPages {

	@ScreenMap(name = "WebStorage", location = "http://html5demos.com/storage")
	public class Main {

		@ElementMap(name = "Valor", locatorType = ElementLocatorType.Id, locator = "local")
		private TextField campoValue;

	}
	
	@ScreenMap(name = "Google", location = "http://google.com")
	public class Google {

	}


}
