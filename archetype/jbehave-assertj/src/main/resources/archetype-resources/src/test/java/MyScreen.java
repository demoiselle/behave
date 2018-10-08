package ${packageName};

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Tela de Login", location = "Autenticação")
public class MyScreen {

	@ElementMap(name = "Rótulo Usuário", locatorType = ElementLocatorType.Label, locator = "Usuário:")
	private Label labelUsuario;

	@ElementMap(name = "Campo Usuário", locatorType = ElementLocatorType.Name, locator = "user")
	private TextField campoUsuario;

	@ElementMap(name = "Rótulo Senha", locatorType = ElementLocatorType.Label, locator = "Senha:")
	private Label labelSenha;

	@ElementMap(name = "Campo Senha", locatorType = ElementLocatorType.Name, locator = "password")
	private TextField campoSenha;

	@ElementMap(name = "Entrar", locatorType = ElementLocatorType.Label, locator = "Entrar")
	private Button botaoEnviar;

}
