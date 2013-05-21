package br.gov.frameworkdemoiselle.behave.samplegoogle.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.PageMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

@PageMap(name = "Tela de Busca", url = "http://www.google.com.br")
public class SearchPage {

	@ElementMap(name = "Campo de Busca", locatorType = "id", locator = "gbqfq")
	private Element searchField;

	// Botão de "Estou com sorte"
	@ElementMap(name = "Botão Estou com sorte", locatorType = "id", locator = "gbqfbb")
	private Element buttonSearch;

}
