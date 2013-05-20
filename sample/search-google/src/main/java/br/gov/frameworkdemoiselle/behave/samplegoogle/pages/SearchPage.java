package br.gov.frameworkdemoiselle.behave.samplegoogle.pages;

import br.gov.frameworkdemoiselle.behave.annotation.Field;
import br.gov.frameworkdemoiselle.behave.annotation.Page;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

@Page(name = "Tela de Busca", url = "http://www.google.com.br")
public class SearchPage {

	@Field(name = "Campo de Busca", locatorType = "id", locator = "gbqfq")
	private Element searchField;

	// Botão de "Estou com sorte"
	@Field(name = "Botão Estou com sorte", locatorType = "id", locator = "gbqfbb")
	private Element buttonSearch;

}
