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
package br.gov.frameworkdemoiselle.behave.parser.jbehave.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.steps.ParameterConverters.ParameterConverter;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.JBehaveParser;

/**
 * Converte uma String numa coleção do tipo {@link Map}. O texto deverá seguir o
 * padrão {nomeCampo1 => valorCampo1, nomeCampo2 => valorCampo2}.
 * 
 */
public class MapConverter implements ParameterConverter {

	private static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);
	private static final String REGEX = "\\s*?(([\\w\\S]{1,}\\s*?=>\\s*?[\\w\\S]*|\".*?\")[\\s,]*?)*\\s*?";

	public boolean accept(Type type) {
		if (type instanceof ParameterizedType) {
			Type rawType = ((ParameterizedType) type).getRawType();
			Type[] argumentTypes = ((ParameterizedType) type).getActualTypeArguments();
			return Map.class.isAssignableFrom((Class<?>) rawType) && String.class.isAssignableFrom((Class<?>) argumentTypes[0]) && Object.class.isAssignableFrom((Class<?>) argumentTypes[1]);
		}
		return false;
	}

	protected Map<String, String> buildDataMap(String value) {
		Map<String, String> map = new HashMap<String, String>();
		String[] parameters = value.substring(0, value.length()).split(",");
		for (String parameter : parameters) {
			String[] token = parameter.split("=>");
			map.put(token[0].trim(), token[1].trim().replaceAll("\"", ""));
		}
		return map;
	}

	public Object convertValue(String value, Type type) {
		if (!value.matches(REGEX)) {
			throw new BehaveException(message.getString("exception-invalid-parameter", value, REGEX));
		}
		return this.buildDataMap(value);
	}
}