package demoisellebehave.serpro.treino.screens;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

// Hoje o location pega o Title da janela
@ScreenMap(name = "Tela de Login", location = "Aplicação de Treino Desktop - Login")
public class LoginScreen {

	@ElementMap(name = "Campo Usuário", locatorType = ElementLocatorType.Name, locator = "user")
	private TextField campoUsuario;

	@ElementMap(name = "Campo Senha", locatorType = ElementLocatorType.Name, locator = "password")
	private TextField campoSenha;

	@ElementMap(name = "Entrar", locatorType = ElementLocatorType.Label, locator = "Entrar")
	private Button botaoEnviar;

}
