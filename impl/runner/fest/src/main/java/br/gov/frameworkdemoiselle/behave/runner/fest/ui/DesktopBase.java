package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import java.awt.Component;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.fest.swing.core.BasicComponentFinder;
import org.fest.swing.core.ComponentFinder;
import org.fest.swing.core.ComponentMatcher;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.fest.FestRunner;
import br.gov.frameworkdemoiselle.behave.runner.ui.BaseUI;

public class DesktopBase extends MappedElement implements BaseUI {

	private Logger logger = Logger.getLogger(this.toString());
	protected FestRunner runner = (FestRunner) getRunner();

	public Component getElement() {
		ComponentFinder cf = BasicComponentFinder.finderWithCurrentAwtHierarchy();

		// Finder
		Collection<Component> findedComponents = cf.findAll(runner.currentContainer, new ComponentMatcher() {
			@Override
			public boolean matches(Component c) {
				return matcher(c);
			}
		});

		// Se encontrar mais de um elemento com o finder utiliza a anotação do índice
		logger.info("Total de elementos encontrados: " + findedComponents.size() + " | Tela: " + runner.getTitle());

		if (findedComponents.size() == 0) {
			throw new BehaveException("Elemento não encontrado.");
		} else {
			return (Component) findedComponents.toArray()[0];
		}
	}

	private boolean matcher(Component component) {
		if (component instanceof JButton) {
			JButton button = (JButton) component;

			if (button.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && button.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && button.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JTextField) {
			JTextField textField = (JTextField) component;

			if (textField.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && textField.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && textField.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void setLocatorParameters(List<String> Parameters) {

	}

	@Override
	public String getText() {
		return null;
	}

	protected void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			throw new BehaveException("Thread sleep interrompido", ex);
		}
	}

}
