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
import java.lang.reflect.Method;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.fest.swing.core.BasicComponentFinder;
import org.fest.swing.core.ComponentFinder;
import org.fest.swing.core.ComponentMatcher;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.fest.FestRunner;
import br.gov.frameworkdemoiselle.behave.runner.fest.util.DesktopMappedElement;
import br.gov.frameworkdemoiselle.behave.runner.ui.BaseUI;

public class DesktopBase extends DesktopMappedElement implements BaseUI {

	private BehaveMessage message = new BehaveMessage(FestRunner.MESSAGEBUNDLE);
	private Logger log = Logger.getLogger(DesktopBase.class);
	protected FestRunner runner = (FestRunner) getRunner();

	public Component getElement() {
		waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());

		ComponentFinder cf = BasicComponentFinder.finderWithCurrentAwtHierarchy();

		// Finder
		Collection<Component> findedComponents = cf.findAll(runner.currentContainer, new ComponentMatcher() {
			@Override
			public boolean matches(Component c) {
				return matcher(c);
			}
		});

		// Se encontrar mais de um elemento com o finder utiliza a anotação do índice
		log.debug(message.getString("message-elements-found", findedComponents.size(), runner.getTitle(), getElementMap().locator()[0]));

		if (findedComponents.size() == 0) {
			throw new BehaveException(message.getString("exception-elements-not-found", runner.currentContainer.toString(), runner.getHierarchy()));
		} else if (findedComponents.size() > 1) {
			// Pega pelo indice
			return (Component) findedComponents.toArray()[getElementIndex().index()];
		} else {
			return (Component) findedComponents.toArray()[0];
		}

	}

	/**
	 * 
	 * @param component
	 * @return
	 */
	// TODO Melhoria geral deste método, tentar generalizar a maneira com que os objetos são encontrados
	private boolean matcher(Component component) {
		if (component instanceof JButton) {
			JButton button = (JButton) component;

			if (button.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && button.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (button.getText() != null && getElementMap().locatorType() == ElementLocatorType.Label && button.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JButton")) {
				return true;
			}
		}

		if (component instanceof JTextField) {
			JTextField textField = (JTextField) component;

			if (textField.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && textField.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (textField.getText() != null && getElementMap().locatorType() == ElementLocatorType.Label && textField.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JTextField")) {
				return true;
			}
		}

		if (component instanceof JLabel) {
			JLabel label = (JLabel) component;

			if (label.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && label.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.Label && label.getText() != null && label.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JLabel")) {
				return true;
			}
		}

		if (component instanceof JSpinner) {
			JSpinner spinner = (JSpinner) component;

			if (spinner.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && spinner.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JSpinner")) {
				return true;
			}
		}

		if (component instanceof JMenu) {
			JMenu menu = (JMenu) component;

			if (menu.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && menu.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (menu.getText() != null && getElementMap().locatorType() == ElementLocatorType.Label && menu.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JMenu")) {
				return true;
			}
		}

		if (component instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem) component;

			if (menuItem.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && menuItem.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (menuItem.getText() != null && getElementMap().locatorType() == ElementLocatorType.Label && menuItem.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JMenuItem")) {
				return true;
			}
		}

		if (component instanceof JCheckBox) {
			JCheckBox checkBox = (JCheckBox) component;

			if (checkBox.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && checkBox.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (checkBox.getText() != null && getElementMap().locatorType() == ElementLocatorType.Label && checkBox.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JCheckBox")) {
				return true;
			}
		}

		if (component instanceof JRadioButton) {
			JRadioButton radio = (JRadioButton) component;

			if (radio.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && radio.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (radio.getText() != null && getElementMap().locatorType() == ElementLocatorType.Label && radio.getText().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JRadioButton")) {
				return true;
			}
		}

		if (component instanceof JFileChooser) {
			JFileChooser fileChooser = (JFileChooser) component;

			if (fileChooser.getName() != null && getElementMap().locatorType() == ElementLocatorType.Name && fileChooser.getName().equalsIgnoreCase(getElementMap().locator()[0])) {
				return true;
			} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JFileChooser")) {
				return true;
			}
		}

		if (component instanceof JTabbedPane) {
			JTabbedPane tabbedPane = (JTabbedPane) component;

			for (int i = 0; i < tabbedPane.getComponentCount(); i++) {
				// Busca no título, mas o locator esta como LABEL!
				if (tabbedPane.getTitleAt(i) != null && getElementMap().locatorType() == ElementLocatorType.Label && tabbedPane.getTitleAt(i).equalsIgnoreCase(getElementMap().locator()[0])) {
					return true;
				} else if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JTabbedPane")) {
					return true;
				}
			}
		}

		if (component instanceof JTable) {
			if (getElementMap().locatorType() == ElementLocatorType.ClassName && getElementMap().locator()[0].equals("JTable")) {
				return true;
			}
		}

		if (component.getClass().getCanonicalName() != null && getElementMap().locatorType() == ElementLocatorType.ClassName && component.getClass().getCanonicalName().equalsIgnoreCase(getElementMap().locator()[0])) {
			if (getElementMap().locator().length > 1) {
				try {
					Method getInformacaoMethod = component.getClass().getMethod("getText");
					String resultado = (String) getInformacaoMethod.invoke(component);
					return resultado.equalsIgnoreCase(getElementMap().locator()[1]);
				} catch (Exception e) {
					return false;
				}
			} else {
				return true;
			}
		}

		return false;
	}

	protected void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
			throw new BehaveException(message.getString("exception-thread-sleep"), ex);
		}
	}

}
