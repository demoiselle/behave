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
package br.gov.frameworkdemoiselle.behave.runner.ui.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author SERPRO
 *
 */
public enum StateUI {

	PRESENT("Present"), ABSENT("Absent"), VISIBLE("Visible"), INVISIBLE("Invisible"), EDITABLE("Editable"), NOTEDITABLE("Not Editable"), ENABLE("Enable"), DISABLE("Disable"), OTHER("Other");

	private String text;

	private StateUI(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static StateUI fromString(String text) {
		StateUI state = null;
		if (text != null) {
			for (StateUI e : StateUI.values()) {
				if (text.equalsIgnoreCase(e.text)) {
					state = e;
				}
			}
		}
		if (state == null) {
			throw new RuntimeException("Estado '" + text + "' não encontrado na lista: " + StateUI.listar());
		}
		return state;
	}

	public static String listar() {
		List<String> lista = new ArrayList<String>();
		for (StateUI e : StateUI.values()) {
			lista.add(e.text);
		}
		return lista.toString();
	}

}
