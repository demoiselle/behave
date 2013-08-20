package br.gov.frameworkdemoiselle.behave.runner.fest.util;

import java.util.List;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;

public class DesktopMappedElement extends MappedElement implements DesktopElement {

	protected ElementIndex elementIndex;

	public String getText() {
		throw new BehaveException("Método não implementado, ele deve ser implementado pelo componente Desktop.");
	}

	public ElementIndex getElementIndex() {
		return elementIndex;
	}

	public void setElementIndex(ElementIndex elementIndex) {
		this.elementIndex = elementIndex;
	}

	public void setLocatorParameters(List<String> Parameters) {
		throw new BehaveException("Método não implementado.");
	}

}
