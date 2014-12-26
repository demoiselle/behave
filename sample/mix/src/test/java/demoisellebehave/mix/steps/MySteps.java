package demoisellebehave.mix.steps;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.CommonSteps;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebButton;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebFileUpload;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.primefaces.Tree;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.RichFileUpload;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.RichInputNumberSpinner;

public class MySteps extends CommonSteps {
	
	@Then("expando o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenExpandNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.expandByLabel(label);
	}

	@Then("expando o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenExpandNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.expandByPath(path);
	}

	@Then("colapso o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenCollapseNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.collapseByPath(path);
	}

	@Then("colapso o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenCollapseNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.collapseByLabel(label);
	}

	@Then("seleciono o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenSelectNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.selectByLabel(label);
	}

	@Then("seleciono o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenSelectNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.selectByPath(path);
	}

	@Then("deseleciono o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenUnselectNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.unselectByLabel(label);
	}

	@Then("desseleciono o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenUnselectNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.unselectByPath(path);
	}

	@Then("alterno o n\u00F3 com label \"$label\" do componente \"$elementName\"")
	public void thenToggleNodeByLabel(String label, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.toggleByLabel(label);
	}

	@Then("alterno o n\u00F3 com caminho \"$path\" do componente \"$elementName\"")
	public void thenToggleNodeByPath(String path, String elementName) {
		Tree element = (Tree) runner.getElement(currentPageName, elementName);
		element.toggleByPath(path);
	}

	
	@Then("ser\u00E1 exibido o \"$elementName\" com estilo \"$params\"")	
	public void thenSeraExibidoComEstilo(String elementName, List<String> params) {
		try {			
			WebButton element = (WebButton) runner.getElement(currentPageName, elementName);
			element.setLocatorParameters(params);
			List<WebElement> list = element.getElements();
			Assert.assertEquals(1, list.size());
		} catch (BehaveException e) {
			Assert.fail("elemento não encontrado");
		}
	}

	@When("informo no \"$element\" o arquivo \"$arquivo\"")
	public void adicionarArquivo(String element, String arquivo) throws UnsupportedEncodingException{
		try {
			RichFileUpload fu = (RichFileUpload) runner.getElement(currentPageName, element);

			String pathFile = MySteps.class.getResource(arquivo).getPath();
			pathFile = java.net.URLDecoder.decode(pathFile, "UTF-8");

			// Testa se o arquivo existe
			File f = new File(pathFile);
			if (!f.exists()) {
				throw new BehaveException("O arquivo informado não existe!");
			}

			fu.add(f.getPath());
		} catch (ClassCastException e) {
			
			WebFileUpload fu = (WebFileUpload) runner.getElement(currentPageName, element);

			String pathFile = MySteps.class.getResource(arquivo).getPath();
			pathFile = java.net.URLDecoder.decode(pathFile, "UTF-8");

			// Testa se o arquivo existe
			File f = new File(pathFile);
			if (!f.exists()) {
				throw new BehaveException("O arquivo informado não existe!");
			}
			
			fu.sendKeys(pathFile);

			

		}
	}
	
	
	

	@When("aciono \"$funcionalidade\" no campo \"$element\"")
	public void acionarFuncionalidade(String funcionalidade, String element){
		RichFileUpload fu = (RichFileUpload)runner.getElement(currentPageName, element);
		if( "Upload".equals(funcionalidade)) {
			fu.upload();
			fu.waitUntilSubmitItAll();
		}
		else if( "Clear All".equals(funcionalidade))
			fu.clearAll();
	}

	@Then("no \"$element\" o estado do arquivo \"$item\" ser\u00E1 \"$estado\"")
	public void thenEstadoDoItemSera(String element, String item, String estado) {
		RichFileUpload fu = (RichFileUpload)runner.getElement(currentPageName, element);
		String state = fu.getSubmitedItemState( item );
		Assert.assertNotNull(state);
		Assert.assertEquals(state, estado);
	}	
	
	
	@When("defino o valor \"$value\" para o campo \"$element\"")
	public void whenDefionoOValorParaOCampoInputNumberSpinner(String value, String element) {
		RichInputNumberSpinner is = (RichInputNumberSpinner)runner.getElement(currentPageName, element);
		is.setValue( Long.valueOf(value) );
	}
	
	@Then("o valor do campo \"$element\" ser\u00E1 \"$value\"")
	public void thenOValorDoCampoinputNumberSpinnerSerá(String element, String value) {
		RichInputNumberSpinner is = (RichInputNumberSpinner)runner.getElement(currentPageName, element);
		Long isValue = is.getValue();
		Assert.assertNotNull(isValue);
		Assert.assertEquals(isValue.longValue(), Long.parseLong(value));
	}

	@When("aumento o valor do campo \"$element\"")
	public void whenAumentoOValorDoCampoinputNumberSpinner(String element) {
		RichInputNumberSpinner is = (RichInputNumberSpinner)runner.getElement(currentPageName, element);
		is.increase();
	}

	@When("diminuo o valor do campo \"$element\"")
	public void whenDiminuoOValorDoCampoinputNumberSpinner(String element) {
		RichInputNumberSpinner is = (RichInputNumberSpinner)runner.getElement(currentPageName, element);
		is.decrease();
	}

	
}
