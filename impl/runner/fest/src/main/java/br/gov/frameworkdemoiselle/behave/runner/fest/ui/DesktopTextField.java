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

import javax.swing.text.JTextComponent;

import org.fest.swing.fixture.JTextComponentFixture;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

public class DesktopTextField extends DesktopBase implements TextField {

	public void sendKeys(CharSequence... keysToSend) {
		try {
			JTextComponentFixture textFix = new JTextComponentFixture(runner.robot, (JTextComponent) getElement());
			for (CharSequence cs : keysToSend)
				textFix.setText(cs.toString());
		}
		catch (Exception e) {
			throw new BehaveException(runner.getHierarchy(), e);
		}
	}

	public void sendKeysWithTries(CharSequence... keysToSend) {
		sendKeys(keysToSend);
	}

	public void clear() {
		sendKeys("");
	}

	@Override
	public String getText() {
		JTextComponentFixture textFix = new JTextComponentFixture(runner.robot, (JTextComponent) getElement());
		return textFix.text();
	}

	@Override
	public void isVisibleDisabled() {
		JTextComponent component = (JTextComponent) getElement();
		if (component == null)
			throw new BehaveException(message.getString("exception-element-not-found", getElementMap().name()));

		// Alguns componentens usam isEditable e outros usam isEnabled
		if (!component.isVisible() || (component.isEditable() && component.isEnabled())) {
			throw new BehaveException(message.getString("exception-element-not-displayed-or-enabled", getElementMap().name()));
		}
	}

	@Override
	public void sendKeysTriggerEvent(String event, CharSequence... keysToSend) {

	}

}
