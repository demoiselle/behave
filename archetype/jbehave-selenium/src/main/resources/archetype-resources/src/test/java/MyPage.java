package ${packageName};

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Tela de Busca", location = "http://www.google.com.br")
public class MyPage {

	@ElementMap(name = "Campo de Busca", locatorType = ElementLocatorType.Id, locator = "gbqfq")
	private TextField searchField;

	@ElementMap(name = "Estou com sorte", locatorType = ElementLocatorType.Id, locator = "gbqfbb")
	private Button buttonLuckSearch;

}
