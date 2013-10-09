package demoisellebehave.mix.pages;

import br.gov.frameworkdemoiselle.behave.annotation.Embedded;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;

@ScreenMap(name = "AlertasEmbutidos", location = "http://demoiselle.sourceforge.net/docs/components/behave/samples/alert.html")
public class DialogEmbeddedPage {

	@Embedded
	private DialogPage dialogPage;


}
