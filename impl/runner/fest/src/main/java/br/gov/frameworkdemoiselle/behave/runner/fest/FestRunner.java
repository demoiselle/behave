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
package br.gov.frameworkdemoiselle.behave.runner.fest;

import java.awt.Container;
import java.awt.Window;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.fest.swing.core.BasicComponentPrinter;
import org.fest.swing.core.ComponentPrinter;
import org.fest.swing.core.Robot;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JComponentFixture;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;

public class FestRunner implements Runner {

	private Logger logger = Logger.getLogger(this.toString());

	public Robot robot;
	public Object application;
	public Container mainContainer;
	public Container currentContainer;
	public FrameFixture mainFixture;
	public JComponentFixture currentFixture;
	public String currentTitle;

	@Override
	public void start() {
		logger.info("Iniciou o FEST...");

		// A aplicação tem que estar no classpath do projeto maven
		if (application == null) {

			JFrame frame = GuiActionRunner.execute(new GuiQuery<JFrame>() {

				protected JFrame executeInEDT() {
					String className = BehaveConfig.getRunner_MainClass();

					logger.info("Iniciando aplicação com a classe " + className);

					try {
						application = Class.forName(className).newInstance();
					} catch (ClassNotFoundException ex) {
						throw new BehaveException("A classe " + className + " não foi encontrada no classpath da aplicação, é necessário incluir o JAR da aplicação desktop no projeto.");
					} catch (Exception ex) {
						throw new BehaveException(ex);
					}

					return (JFrame) application;
				}

			});

			mainContainer = frame;
			mainContainer.setVisible(true);

			mainFixture = new FrameFixture((JFrame) mainContainer);
			robot = mainFixture.robot;
		}

		currentContainer = mainContainer;
	}

	@Override
	public void get(String url) {

	}

	@Override
	public void navigateTo(String title) {
		// Procura por Dialogs
		for (Window w : JDialog.getWindows()) {
			if (w instanceof JDialog && w.isVisible()) {
				if (title.trim().equalsIgnoreCase(((JDialog) w).getTitle().trim())) {
					currentContainer = (JPanel) ((JDialog) w).getRootPane().getContentPane();
					currentContainer.setFocusTraversalKeysEnabled(true);
					currentContainer.setVisible(true);
					currentContainer.setEnabled(true);

					currentTitle = title;
					return;
				}
			}
		}

		// Procura por Frames
		for (Window w : JFrame.getWindows()) {
			if (w instanceof JFrame && w.isVisible()) {
				if (title.trim().equalsIgnoreCase(((JFrame) w).getTitle().trim())) {
					currentContainer = (JPanel) ((JFrame) w).getRootPane().getContentPane();
					currentContainer.setFocusTraversalKeysEnabled(true);
					currentContainer.setVisible(true);
					currentContainer.setEnabled(true);

					currentTitle = title;
					return;
				}
			}
		}

		throw new BehaveException("Nenhuma tela encontrada.");

	}

	public String getHierarchy() {
		ComponentPrinter printer = BasicComponentPrinter.printerWithCurrentAwtHierarchy();		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(out, true);
		printer.printComponents(printStream, currentContainer);
		printStream.flush();
		return new String(out.toByteArray());
	}

	@Override
	public String getCurrentUrl() {
		return null;
	}

	@Override
	public String getTitle() {
		return currentTitle;
	}

	@Override
	public Element getElement(String currentPageName, String elementName) {
		if ((currentPageName == null) || (currentPageName.equals("")))
			throw new RuntimeException("Não existe tela selecionada.");

		ElementMap map = ReflectionUtil.getElementMap(currentPageName, elementName);

		Class<?> clazz = ReflectionUtil.getElementType(currentPageName, elementName);

		Element element = null;
		// Comportamento padrão usa o InjectionManager para resolver quem implementa a interface
		if (clazz.isInterface())
			element = (Element) InjectionManager.getInstance().getInstanceDependecy(clazz);
		// Instancia a classe fornecida explicitamente como implementação da interface Element
		else if (Element.class.isAssignableFrom(clazz))
			try {
				element = (Element) clazz.newInstance();
			} catch (Exception e) {
				element = null;
			}
		else
			throw new RuntimeException("A class [" + clazz.getName() + "] no elemento [" + elementName + "] da tela [" + currentPageName + "] não é uma interface para 'Element'.");

		if (element == null)
			throw new RuntimeException("Não foi possível instanciar o elemento [" + elementName + "] da tela [" + currentPageName + "].");

		element.setElementMap(map);

		return element;
	}

	@Override
	public String getPageSource() {
		return null;
	}

	@Override
	public void close() {

	}

	@Override
	public void quit() {

	}

	@Override
	public Object getDriver() {
		return robot;
	}

	@Override
	public Screen getScreen() {
		return null;
	}

}
