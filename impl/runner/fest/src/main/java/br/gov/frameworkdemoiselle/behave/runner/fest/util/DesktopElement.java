package br.gov.frameworkdemoiselle.behave.runner.fest.util;

import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;

public interface DesktopElement extends Element {

	public ElementIndex getElementIndex();

	public void setElementIndex(ElementIndex elementIndex);

}
