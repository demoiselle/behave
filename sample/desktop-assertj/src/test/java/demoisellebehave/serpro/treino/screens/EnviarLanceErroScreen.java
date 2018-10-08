package demoisellebehave.serpro.treino.screens;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;

@ScreenMap(name = "Enviar Lance - Erro", location = "Erro")
public class EnviarLanceErroScreen {

	@ElementMap(name = "OK", locatorType = ElementLocatorType.Label, locator = "OK")
	private Button btnOk;

}
