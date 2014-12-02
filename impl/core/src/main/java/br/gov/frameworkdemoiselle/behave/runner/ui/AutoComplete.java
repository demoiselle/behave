package br.gov.frameworkdemoiselle.behave.runner.ui;

public interface AutoComplete extends BaseUI {
	
	/**
	 * Seleciona a opção que contém o valor correspondente ao parâmetro. Ou
	 * seja, passando "foo" como parâmetro, este será informado no campo de texto,
	 * aguardará um tempo para aparecer a lista na tela, e depois disso,
	 * selecionará o valor correspondente na tag <li> ou <td> dentro da <div class="ui-autocomplete-panel"/>
	 * 
	 * @param value
	 *            O valor da opção na combobox.
	 */
	public void selectByValue(String value);
	
	/**
	 * Informa um valor de busca no campo de texto
	 * do autocomplete, e seleciona um texto distinto
	 * na lista de resultados
	 * 
	 * @param String searchValue Valor que será informado no campo de texto para busca
	 * @param String selectValue Valor que será selecionado na lista de resultados
	 */
	public void searchAndSelectValue(String searchValue , String selectValue);
}
