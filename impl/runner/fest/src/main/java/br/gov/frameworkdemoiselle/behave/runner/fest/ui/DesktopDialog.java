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

import static org.fest.swing.edt.GuiActionRunner.execute;
import static org.fest.util.Strings.concat;
import static org.fest.util.Strings.quote;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.finder.DialogFinder;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.DialogFixture;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.fest.FestRunner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Dialog;

public class DesktopDialog extends DesktopBase implements Dialog {

	protected BehaveMessage coreMessage = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	@Override
	public void accept() {
		DialogFinder dialogFinder = WindowFinder.findDialog(JDialog.class);
		DialogFixture dialogFixture = dialogFinder.using(((FestRunner) runner).robot);
		java.awt.Dialog dialog = dialogFixture.component();
		JButton button = getDialogButton(dialog);
		button.doClick();
	}

	@Override
	public void accept(String buttonText, String dialogTitle) {
		DialogFinder dialogFinder = WindowFinder.findDialog(new DialogTitleMatcher(dialogTitle));
		DialogFixture dialogFixture = dialogFinder.using(((FestRunner) runner).robot);		
		dialogFixture.button(new JButtonTextMatcher(buttonText)).click();
	}

	@Override
	public void cancel() {
		// TODO Implement for desktop applications
		throw new BehaveException(coreMessage.getString("exception-method-not-implemented", "DesktopDialog.cancel()"));
	}

	@Override
	public void sendKeys(String keys) {
		// TODO Implement for desktop applications
		throw new BehaveException(coreMessage.getString("exception-method-not-implemented", "DesktopDialog.sendKeys(String keys)"));
	}

	@Override
	public String getText() {
		// TODO Implement for desktop applications
		throw new BehaveException(coreMessage.getString("exception-method-not-implemented", "DesktopDialog.getText()"));
	}
	
	private JButton getDialogButton(java.awt.Dialog dialog) {
		ArrayList<Component> components = new ArrayList<Component>(); 
		getDialogComponentes(dialog, components);
		
		for (Component component : components) {
			
			if (component instanceof JButton) {
				return (JButton) component;
			}
			
		}
		
		return null;
	}
	
	private void getDialogComponentes(Container container, ArrayList<Component> returnComponents) {

		for (Component component :  container.getComponents()) {
			returnComponents.add(component);			
			
			if (component instanceof Container) {
				getDialogComponentes((Container) component, returnComponents);
			}
			
		}
		
	}

	private static class DialogTitleMatcher extends GenericTypeMatcher<java.awt.Dialog> {
		private final String matchString;

		public DialogTitleMatcher(String s) {
			super(java.awt.Dialog.class, true);
			this.matchString = s;
		}

		@Override
		protected boolean isMatching(java.awt.Dialog dialog) {
			
			if (dialog == null) {
				return false;
			}
			
			String title = dialog.getTitle();
			
			boolean matchTitle = title.equalsIgnoreCase(matchString);
			boolean isShowing = isShowing(dialog);
			
			return (title != null) && matchTitle && isShowing;
		}

		@RunsInEDT
		private static boolean isShowing(final java.awt.Dialog dialog) {
			
			return execute(new GuiQuery<Boolean>() {
				
				@Override
				protected Boolean executeInEDT() {
					return dialog.isShowing();
				}
				
			});
			
		}

		@Override
		public String toString() {
			return concat(DialogTitleMatcher.class.getSimpleName(), "(", quote(matchString), ")");
		}
	}

	private static class JButtonTextMatcher extends GenericTypeMatcher<JButton> {
		private final String matchString;

		public JButtonTextMatcher(String s) {
			super(JButton.class, true);
			this.matchString = s;
		}

		@Override
		protected boolean isMatching(JButton button) {
			
			if (button == null) {
				return false;
			}
			
			String text = button.getText();
			
			boolean matchText = text.equalsIgnoreCase(matchString);
			boolean isShowing = isShowing(button);
			
			return (text != null) && matchText && isShowing;
		}

		@RunsInEDT
		private static boolean isShowing(final Component component) {
			
			return execute(new GuiQuery<Boolean>() {
				
				@Override
				protected Boolean executeInEDT() {
					return component.isShowing();
				}
				
			});
			
		}

		@Override
		public String toString() {
			return concat(JButtonTextMatcher.class.getSimpleName(), "(", quote(matchString), ")");
		}
	}

}
