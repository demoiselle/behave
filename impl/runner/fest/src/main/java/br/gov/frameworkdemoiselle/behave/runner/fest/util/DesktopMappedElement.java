package br.gov.frameworkdemoiselle.behave.runner.fest.util;

import java.util.List;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;

public class DesktopMappedElement extends MappedElement implements DesktopElement {

	protected ElementIndex elementIndex;
	private List<String> locatorParameters;

	public String getText() {
		throw new BehaveException("Método não implementado, ele deve ser implementado pelo componente Desktop.");
	}

	public ElementIndex getElementIndex() {
		return elementIndex;
	}

	public void setElementIndex(ElementIndex elementIndex) {
		this.elementIndex = elementIndex;
	}

	public List<String> getLocatorParameter() {
		return locatorParameters;
	}

	public void setLocatorParameters(List<String> locatorParameter) {
		this.locatorParameters = locatorParameter;
	}

	@Override
	public void waitText(String text) {
		throw new BehaveException("Método não implementado (waitText).");
	}

	@Override
	public void waitTextInElement(String text) {
		throw new BehaveException("Método não implementado (waitTextInElement).");
	}

	@Override
	public void waitInvisible() {
		throw new BehaveException("Método não implementado (waitInvisible).");
	}

	@Override
	public void waitVisibleClickableEnabled() {
		throw new BehaveException("Método não implementado (waitVisibleClickableEnabled).");
	}

	@Override
	public void isVisibleDisabled() {
		throw new BehaveException("Método não implementado (isVisibleDisabled).");
	}

	@Override
	public void waitNotText(String text) {
		throw new BehaveException("Método não implementado (waitNotText).");
	}

	@Override
	public void waitTextNotInElement(String text) {
		throw new BehaveException("Método não implementado (waitTextNotInElement).");
	}

}
