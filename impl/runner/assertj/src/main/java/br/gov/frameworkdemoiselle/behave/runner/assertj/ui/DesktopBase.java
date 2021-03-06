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
package br.gov.frameworkdemoiselle.behave.runner.assertj.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.log4j.Logger;
import org.assertj.swing.core.BasicComponentFinder;
import org.assertj.swing.core.ComponentFinder;
import org.assertj.swing.core.ComponentMatcher;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.assertj.AssertJRunner;
import br.gov.frameworkdemoiselle.behave.runner.assertj.annotation.ElementIndex;
import br.gov.frameworkdemoiselle.behave.runner.assertj.util.DesktopMappedElement;
import br.gov.frameworkdemoiselle.behave.runner.ui.BaseUI;

public class DesktopBase extends DesktopMappedElement implements BaseUI {

	protected BehaveMessage message = new BehaveMessage(AssertJRunner.MESSAGEBUNDLE);
	private Logger log = Logger.getLogger(DesktopBase.class);
	protected AssertJRunner runner = (AssertJRunner) getRunner();

	public Component getElement() {
		boolean isTimeOver = false;
		long startedTime = GregorianCalendar.getInstance().getTimeInMillis();
		Long timeout = BehaveConfig.getRunner_ScreenMaxWait();
		
		while (!isTimeOver) {
			ComponentFinder cf = BasicComponentFinder.finderWithCurrentAwtHierarchy();
	
			// Active window finder.
			Container activeWindow = getActiveWindow(cf);
			
			// If no active window were found, searches from root.
			if (activeWindow == null) {
				activeWindow = runner.currentContainer;
			}
	
			// Component finder.
			Collection<Component> findedComponents = cf.findAll(activeWindow, new ComponentMatcher() {
				@Override
				public boolean matches(Component c) {
					return matcher(c);
				}
			});

			log.debug(message.getString("message-elements-found", findedComponents.size(), runner.getTitle(), getElementMap().locator()[0]));
	
			if (findedComponents.size() > 0) {
								
				if (findedComponents.size() > 1) {
					// Se encontrar mais de um elemento com o finder utiliza a anotação do índice
					ElementIndex elementIndex = getElementIndex();
					
					return (Component) findedComponents.toArray()[elementIndex.index()];
				} else {
					return (Component) findedComponents.toArray()[0];
				}
				
			}
				
			isTimeOver = (GregorianCalendar.getInstance().getTimeInMillis() - startedTime) > timeout;			
			waitThreadSleep(BehaveConfig.getRunner_ScreenMinWait());
		}

		throw new BehaveException(message.getString("exception-elements-not-found", runner.currentContainer.toString(), runner.getHierarchy()));
	}
	
	/**
	 * Find the active window among all {@link Frame Frames} and {@link Dialog Dialogs}.
	 * 
	 * @param cf Component finder to search over all AWT hierarchy.
	 * @return the active window
	 */
	private Container getActiveWindow(ComponentFinder cf) {

		Collection<Component> activeScreens = cf.findAll(runner.currentContainer, new ComponentMatcher() {
			@Override
			public boolean matches(Component c) {
				boolean match = ((c instanceof Frame) && ((Frame)c).isActive()) 
						|| ((c instanceof Dialog) && ((Dialog)c).isActive())
						|| ((c instanceof JOptionPane) && (((Dialog)((JOptionPane)c).getRootPane().getParent()).isActive()));
								
				return match;
			}
		});
		
		if (activeScreens.size() == 1) {
			return (Container) activeScreens.toArray()[0];
		} else {
			
			if (activeScreens.size() > 1) {
				
				for (Component screen : activeScreens) {
					
					if (screen instanceof JOptionPane) {
						return (Container) screen;
					}
					
				}
				
				throw new BehaveException(message.getString("exception-active-window-not-found", activeScreens.size(), runner.currentContainer.toString(), runner.getHierarchy()));				
			} else {
				return null;
			}
			
		}
		
	}

	/**
	 * @param component
	 * @return
	 */
	/*
	 * TODO Melhoria geral deste método, tentar generalizar a maneira com que os
	 * objetos são encontrados
	 */
	private boolean matcher(Component component) {

		String locator = getLocatorWithParameters(getElementMap().locator()[0]);
		ElementLocatorType locatorType = getElementMap().locatorType();

		if (component instanceof JButton) {
			JButton button = (JButton) component;
			
			switch (locatorType) {
			case Name:
				if (button.getName() != null && button.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (button.getText() != null && button.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JButton"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JComboBox) {
			JComboBox combo = (JComboBox) component;
			
			switch (locatorType) {
			case Name:
				if (combo.getName() != null && combo.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JComboBox"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JTextField) {
			JTextField textField = (JTextField) component;
			
			switch (locatorType) {
			case Name:
				if (textField.getName() != null && textField.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (textField.getText() != null && textField.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JTextField"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JLabel) {
			JLabel label = (JLabel) component;
			
			switch (locatorType) {
			case Name:
				if (label.getName() != null && label.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (label.getText() != null && label.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JLabel"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JSpinner) {
			JSpinner spinner = (JSpinner) component;
			
			switch (locatorType) {
			case Name:
				if (spinner.getName() != null && spinner.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JSpinner"))
					return true;
			default:
				break;
			}
		} else if (component instanceof JMenu) {
			JMenu menu = (JMenu) component;
			
			switch (locatorType) {
			case Name:
				if (menu.getName() != null && menu.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (menu.getText() != null && menu.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JMenu"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JMenuItem) {
			JMenuItem menuItem = (JMenuItem) component;
			
			switch (locatorType) {
			case Name:
				if (menuItem.getName() != null && menuItem.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (menuItem.getText() != null && menuItem.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JMenuItem"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JCheckBox) {
			JCheckBox checkBox = (JCheckBox) component;
			
			switch (locatorType) {
			case Name:
				if (checkBox.getName() != null && checkBox.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (checkBox.getText() != null && checkBox.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JCheckBox"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JRadioButton) {
			JRadioButton radio = (JRadioButton) component;
			
			switch (locatorType) {
			case Name:
				if (radio.getName() != null && radio.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case Label:
				if (radio.getText() != null && radio.getText().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JRadioButton"))
					return true;
			default:
				break;
			}
			
		} else if (component instanceof JFileChooser) {
			JFileChooser fileChooser = (JFileChooser) component;
			switch (locatorType) {
			case Name:
				if (fileChooser.getName() != null && fileChooser.getName().equalsIgnoreCase(locator))
					return true;
				break;
			case ClassName:
				if (locator.equals("JFileChooser"))
					return true;
			default:
				break;
			}
		} else if (component instanceof JTabbedPane) {
			JTabbedPane tabbedPane = (JTabbedPane) component;
			
			for (int i = 0; i < tabbedPane.getTabCount(); i++) {				
				// Busca no título, mas o locator esta como LABEL!
				if (tabbedPane.getTitleAt(i) != null && locatorType == ElementLocatorType.Label && tabbedPane.getTitleAt(i).equalsIgnoreCase(locator))
					return true;
				else if (locatorType == ElementLocatorType.ClassName && locator.equals("JTabbedPane"))
					return true;
			}
			
		} else if (component instanceof JTable) {
			
			if (locatorType == ElementLocatorType.ClassName && locator.equals("JTable"))
				return true;
			
		}
		
		if (component.getClass().getCanonicalName() != null && locatorType == ElementLocatorType.ClassName && component.getClass().getCanonicalName().equalsIgnoreCase(locator)) {
			
			try {
				Method isShowingMethod = component.getClass().getMethod("isShowing");
				boolean isShowing = (Boolean) isShowingMethod.invoke(component);
				if (!isShowing)
					return false;

				if (getElementMap().locator().length > 1) {
					Method getInformacaoMethod = component.getClass().getMethod("getText");
					String resultado = (String) getInformacaoMethod.invoke(component);
					String locatorAux = getLocatorWithParameters(getElementMap().locator()[1]);
					return resultado.equalsIgnoreCase(locatorAux);
				}
				
			} catch (Exception e) {
				return false;
			}
			
			return true;
		}
		
		return false;
	}

	private String getLocatorWithParameters(String locator) {
		if (getLocatorParameter() != null && !getLocatorParameter().isEmpty() && locator.matches(".*%param[0-9]+%.*")) {
			int n = 1;
			for (String parameter : getLocatorParameter()) {
				String tag = "%param" + n + "%";
				if (locator.contains(tag)) {
					locator = locator.replace(tag, parameter);
				}
				n++;
			}
		}
		return locator;
	}

	protected void waitThreadSleep(Long delay) {
		try {
			Thread.sleep(delay);
		}
		catch (InterruptedException ex) {
			throw new BehaveException(message.getString("exception-thread-sleep"), ex);
		}
	}

	@Override
	public void isVisibleDisabled() {
		JComponent component = (JComponent) getElement();
		if (component == null)
			throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));
		if (!component.isVisible() || component.isEnabled())
			throw new BehaveException(message.getString("exception-element-not-displayed-or-enabled", getElementMap().name()));
	}

}
