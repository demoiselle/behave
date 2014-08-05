package demoisellebehave.serpro.treino.pages.fields;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class LoginFields {

	@ElementMap(name = "Usuário", locatorType = ElementLocatorType.XPath, locator = "(//input[contains(@id, 'formLogin')][contains(@type, 'text')])[1]")
	private TextField campoUsuario;

	@ElementMap(name = "Senha", locatorType = ElementLocatorType.XPath, locator = "(//input[contains(@id, 'formLogin')][contains(@type, 'password')])[1]")
	private TextField campoSenha;

}
