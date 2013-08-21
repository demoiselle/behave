package demoisellebehave.serpro.treino.screens;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Enviar Lance", location = "Enviar Lance")
public class EnviarLanceScreen {

	@ElementMap(name = "Novo Valor", locatorType = ElementLocatorType.ClassName, locator = "JTextField")
	@ElementIndex(index = 0)
	private TextField campoValor;

	@ElementMap(name = "Novo Prazo", locatorType = ElementLocatorType.ClassName, locator = "JTextField")
	@ElementIndex(index = 1)
	private TextField campoPrazo;

	@ElementMap(name = "Enviar Lance", locatorType = ElementLocatorType.Label, locator = "Enviar Lance")
	private Button btnEnviar;

	@ElementMap(name = "Cancelar", locatorType = ElementLocatorType.Label, locator = "Cancelar")
	private Button btnCancelar;
	
}
