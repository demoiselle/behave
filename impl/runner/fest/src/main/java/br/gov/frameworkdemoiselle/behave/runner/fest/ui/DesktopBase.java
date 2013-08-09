/*
 * Demoiselle Framework
 * Copyright (C) 2013 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package br.gov.frameworkdemoiselle.behave.runner.fest.ui;

import java.awt.Component;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.fest.swing.core.BasicComponentFinder;
import org.fest.swing.core.ComponentFinder;
import org.fest.swing.core.ComponentMatcher;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.ui.MappedElement;
import br.gov.frameworkdemoiselle.behave.runner.fest.FestRunner;
import br.gov.frameworkdemoiselle.behave.runner.ui.BaseUI;

public class DesktopBase extends MappedElement implements BaseUI {

	Logger log = Logger.getLogger(DesktopBase.class);
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
		log.debug("Total de elementos encontrados: " + findedComponents.size() + " | Tela: " + runner.getTitle() + " | Locator: " + getElementMap().locator()[0]);

		if (findedComponents.size() == 0) {
			throw new BehaveException("Elemento não encontrado. \rContainer: \r" + runner.currentContainer.toString() + "\r----------------------------------------------\rÁrvore de objetos: \r" + runner.getHierarchy() + "\r----------------------------------------------");
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

		if (component instanceof JLabel) {
			JLabel label = (JLabel) component;

			if (label.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && label.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && label.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JSpinner) {
			JSpinner spinner = (JSpinner) component;

			if (spinner.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && spinner.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JMenu) {
			JMenu menu = (JMenu) component;

			if (menu.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && menu.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && menu.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem) component;

			if (menuItem.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && menuItem.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && menuItem.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JCheckBox) {
			JCheckBox checkBox = (JCheckBox) component;

			if (checkBox.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && checkBox.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && checkBox.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JRadioButton) {
			JRadioButton radio = (JRadioButton) component;

			if (radio.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && radio.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && radio.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JFileChooser) {
			JFileChooser fileChooser = (JFileChooser) component;

			if (fileChooser.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && fileChooser.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			}
		}

		if (component instanceof JTabbedPane) {
			JTabbedPane tabbedPane = (JTabbedPane) component;

			for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
				// Busca no título, mas o locator esta como LABEL!
				if (getElementMap().locatorType() == ElementLocatorType.Label && tabbedPane.getTitleAt(i).equalsIgnoreCase(getElementMap().locator()[0])) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void setLocatorParameters(List<String> Parameters) {

	}

	@Override
	public String getText() {
		throw new BehaveException("Método não implementado, ele deve ser implementado pelo componente Desktop.");
	}

	protected void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			throw new BehaveException("Thread sleep interrompido", ex);
		}
	}

}
