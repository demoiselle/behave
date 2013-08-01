package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente rich:select
 * 
 * Utiliza a API Javascript do Richfaces para a correta manipulação do componente. O locator do mapeamento de tela deve retornar o primeiro div gerado pelo componente rich:select, aquele div que possui 'class="rf-sel"' ou ainda que possui o mesmo ID informado no arquivo XHTML, porém, o ID não é obrigatório, basta selecionar o primeiro div gerado pelo componente.
 * 
 * @author lmveloso
 * 
 */
public class RichSelect extends WebBase {

	/**
	 * Clica no campo do rich:select, provocando a abertura ou o fechamento do menu popup.
	 * 
	 * Se após o click o popup estiver aberto e foi informado algum parâmetro para o localizador, então busca o item com label igual ao parâmetro e clica neste campo.
	 * 
	 */
	public void click() {
		if (getLocatorParameter() != null && !getLocatorParameter().isEmpty())
			click(getLocatorParameter().get(0));
		else
			click(null);
	}

	/**
	 * Clica no campo do rich:select, provocando a abertura ou o fechamento do menu popup.
	 * 
	 * Se após o click o popup estiver aberto e foi informado algum parâmetro para o localizador, então busca o item com label igual ao parâmetro e clica neste campo.
	 * 
	 * @param txtMenuItem
	 */
	public void click(String txtMenuItem) {
		waitElement(0);

		checkRichfacesComponent();

		// Abre ou fecha o menu de acordo com o estado do componente
		if ((Boolean) getJavascirptExecutor().executeScript("return RichFaces.$('" + getId() + "').popupList.isVisible();"))
			hidePopup();
		else {
			showPopup();
			clickMenuItem(txtMenuItem);
		}
	}

	/**
	 * Procura no componente rich:select um item com o mesmo label informado e se encontrado envia um evento de click() para o elemento correspondente.
	 * 
	 * @param txtMenuItem
	 */
	public void clickMenuItem(String txtMenuItem) {

		checkRichfacesComponent();

		// Se o label do item de menu foi informado, seleciona o elemento da popupList
		if (txtMenuItem != null && !txtMenuItem.isEmpty()) {
			String jsClickItemCode = "return (function(){ var val = '" + txtMenuItem + "'; var rfs = RichFaces.$('" + getId() + "'); for( var n=0; n < rfs.popupList.options.clientSelectItems.length; n++ ) { if( rfs.popupList.options.clientSelectItems[n].label == val ) { rfs.originalItems[ n ].click(); return true; } } return false; })();";

			Boolean clicked = (Boolean) getJavascirptExecutor().executeScript(jsClickItemCode);
			if (!clicked)
				throw new BehaveException("Não foi possível clicar no item [" + txtMenuItem + "] do elemento [" + this.getElementMap().name() + "].");
		}
	}

	/**
	 * Utiliza a API Javascritp do Richfaces para mostrar o popup com itens do rich:select
	 */
	public void showPopup() {
		checkRichfacesComponent();
		getJavascirptExecutor().executeScript("RichFaces.$('" + getId() + "').showPopup();");
	}

	/**
	 * Utiliza a API Javascritp do Richfaces para ocultar o popup com itens do rich:select
	 */
	public void hidePopup() {
		checkRichfacesComponent();
		getJavascirptExecutor().executeScript("RichFaces.$('" + getId() + "').hidePopup();");
	}

	/**
	 * Verifica se o componente selecionado é realmente um coponente rich:select
	 * 
	 * @return
	 */
	public boolean isRichSelect() {
		String jsCodeCheckComponent = "return (function(tipo, id) { var rf = RichFaces.$(id); return (typeof(rf) == \"object\" && typeof(rf.name) == \"string\" && rf.name == tipo);})('select','" + getId() + "');";
		return (Boolean) getJavascirptExecutor().executeScript(jsCodeCheckComponent);
	}

	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkRichfacesComponent() {
		if (!isRichSelect())
			throw new BehaveException("O elemento [" + this.getElementMap().name() + "] selecionado possui ID [" + getId() + "] mas não é um componente do tipo rich:select.");

	}

}
