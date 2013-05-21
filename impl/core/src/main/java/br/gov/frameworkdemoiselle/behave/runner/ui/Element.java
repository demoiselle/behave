package br.gov.frameworkdemoiselle.behave.runner.ui;

import java.util.List;

import br.gov.frameworkdemoiselle.behave.annotation.PageMap;

public interface Element {

	/**
	 * 
	 * @param fieldName
	 *            Nome do atributo do {@link PageMap} anotado atributo da anotação
	 *            "name"
	 * @return Lista de {@link Element}
	 */
	public List<Element> find(String fieldName);

}
