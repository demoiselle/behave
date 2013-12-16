package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Disabled", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/disabled.html")
public class DisabledPage {

	@ElementMap(locator = "processosDocumentosForm:nomeAutorSelecao", locatorType = ElementLocatorType.Id, name = "Nome")
	private TextField nome;

}
