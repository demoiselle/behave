package br.gov.frameworkdemoiselle.behave.runner.ui;

import java.util.List;

import br.gov.frameworkdemoiselle.behave.annotation.Page;

public interface Element {

	/**
	 * 
	 * @param fieldName
	 *            Nome do atributo do {@link Page} anotado atributo da anotação
	 *            "name"
	 * @return Lista de {@link Element}
	 */
	public List<Element> find(String fieldName);

}
