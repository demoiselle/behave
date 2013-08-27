package ${packageName};

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

@ScreenMap(name = "Mensagem de Erro", location = "Erro")
public class MyErrorScreen {
	
	@ElementMap(name = "OK", locatorType = ElementLocatorType.Label, locator = "OK")
	private Button btOk;
	
}
