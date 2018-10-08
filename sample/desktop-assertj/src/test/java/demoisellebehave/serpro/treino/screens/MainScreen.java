package demoisellebehave.serpro.treino.screens;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Menu;
import br.gov.frameworkdemoiselle.behave.runner.ui.MenuItem;

@ScreenMap(name = "Painel Principal", location = "Painel Principal")
public class MainScreen {

	@ElementMap(name = "Menu Principal Obras", locatorType = ElementLocatorType.Label, locator = "Obras")
	private Menu mainLevelObras;

	@ElementMap(name = "Obras", locatorType = ElementLocatorType.Label, locator = "Todas as Obras")
	private MenuItem secondLevelObras;
	
	@ElementMap(name = "Menu Principal Sair", locatorType = ElementLocatorType.Label, locator = "Sair")
	private Menu mainLevelSair;

	@ElementMap(name = "Sair", locatorType = ElementLocatorType.Label, locator = "Sair do Sistema")
	private MenuItem secondLevelSair;

}
