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
package br.gov.frameworkdemoiselle.behave.internal.util;

import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.Embedded;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 * 
 */
public class ReflectionUtil {

	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	public static String getLocation(String name) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		String urlFinal = "";
		for (Class<?> clazz : annotatedClasses) {
			ScreenMap annotation = clazz.getAnnotation(ScreenMap.class);
			if (annotation.name().equals(name)) {
				String base = "";
				if (BehaveConfig.contains(annotation.base())) {
					base = BehaveConfig.getProperty(annotation.base());
				} else {
					base = annotation.base();
				}
				urlFinal = (!base.equals("")) ? base + annotation.location() : annotation.location();
				break;
			}
		}

		if (urlFinal.equals("")) {
			throw new BehaveException(bm.getString("exception-screen-not-found", name));
		}

		return urlFinal;
	}

	public static Field getElementMap(String pageName, String elementName) {
		Class<?> clazz = getScreenMapClass(pageName);
		Field f = recursive(clazz, elementName);
		if (f == null) {
			throw new BehaveException(bm.getString("exception-element-not-found", elementName, pageName));
		}
		return f;
	}

	@SuppressWarnings("unchecked")
	private static Field recursive(Class<?> clazz, String elementName) {
		Set<Field> fields = ReflectionUtils.getAllFields(clazz, ReflectionUtils.withAnnotation(ElementMap.class));
		Field f = null;
		for (Field fieldI : fields) {
			ElementMap annotation = fieldI.getAnnotation(ElementMap.class);
			if (annotation.name().equals(elementName)) {
				f = fieldI;
				return f;
			}
		}
		// Se não encontrar, procura nas classes agregadas, recursivamente.
		Set<Field> embeddeds = ReflectionUtils.getAllFields(clazz, ReflectionUtils.withAnnotation(Embedded.class));
		for (Field field : embeddeds) {
			f = recursive(field.getType(), elementName);
			if (f != null) {
				return f;
			}
		}
		return f;
	}

	public static Class<?> getScreenMapClass(String pageName) {
		Reflections reflections = new Reflections("");
		Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(ScreenMap.class);

		Class<?> clazz = null;

		for (Class<?> clazzI : annotatedClasses) {
			ScreenMap annotation = clazzI.getAnnotation(ScreenMap.class);
			if (annotation.name().equals(pageName)) {
				clazz = clazzI;
				break;
			}
		}

		if (clazz == null)
			throw new BehaveException(bm.getString("exception-screen-not-found", pageName));
		return clazz;
	}

}
