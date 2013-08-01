package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.ui.Calendar;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente rich:calendar
 * 
 * Utiliza a API Javascript do Richfaces para a correta manipulação do componente. O locator do mapeamento de tela deve retornar o primeiro div gerado pelo componente rich:calendar, aquele div que possui 'class="rf-cal"' ou ainda que possui o mesmo ID informado no arquivo XHTML, porém, o ID não é obrigatório, basta selecionar o primeiro div gerado pelo componente.
 * 
 * @author lmveloso
 * 
 */
public class RichCalendar extends WebBase implements Calendar {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#click()
	 */
	@Override
	public void click() {
		waitElement(0);

		checkRichfacesComponent();

		// Abre ou fecha o menu de acordo com o estado do componente
		if ((Boolean) getJavascirptExecutor().executeScript("return RichFaces.$('" + getId() + "').isVisible;"))
			hideCalendar();
		else {
			showCalendar();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		checkRichfacesComponent();
		getJavascirptExecutor().executeScript("RichFaces.$('" + getId() + "').setValue('" + value + "');");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#clear()
	 */
	public void clear() {
		checkRichfacesComponent();
		setValue("");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#sendKeys(java.lang.CharSequence)
	 */
	public void sendKeys(CharSequence... keysToSend) {
		checkRichfacesComponent();
		setValue((String) keysToSend[0]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#showCalendar()
	 */
	public void showCalendar() {
		checkRichfacesComponent();
		getJavascirptExecutor().executeScript("RichFaces.$('" + getId() + "').showPopup();");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#hideCalendar()
	 */
	public void hideCalendar() {
		checkRichfacesComponent();
		getJavascirptExecutor().executeScript("RichFaces.$('" + getId() + "').hidePopup();");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar#today()
	 */
	public void today() {
		checkRichfacesComponent();
		getJavascirptExecutor().executeScript("RichFaces.$('" + getId() + "').today();");
	}

	/**
	 * Verifica se o componente selecionado é realmente um coponente rich:calendar
	 * 
	 * @return
	 */
	public boolean isRichCalendar() {
		String jsCodeCheckComponent = "return (function(tipo, id) { var rf = RichFaces.$(id); return (typeof(rf) == \"object\" && typeof(rf.name) == \"string\" && rf.name == tipo);})('Calendar','" + getId() + "');";
		return (Boolean) getJavascirptExecutor().executeScript(jsCodeCheckComponent);
	}

	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkRichfacesComponent() {
		if (!isRichCalendar())
			throw new BehaveException("O elemento [" + this.getElementMap().name() + "] selecionado possui ID [" + getId() + "] mas não é um componente do tipo rich:calendar.");

	}
}
