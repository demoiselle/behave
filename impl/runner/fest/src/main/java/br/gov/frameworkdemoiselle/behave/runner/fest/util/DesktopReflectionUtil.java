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
package br.gov.frameworkdemoiselle.behave.runner.fest.util;

import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;

public class DesktopReflectionUtil {

	@SuppressWarnings("unchecked")
	public static ElementIndex getElementIndex(String pageName, String elementName) {
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
			throw new RuntimeException("Nenhuma Tela foi encontrada com o nome [" + pageName + "].");

		Set<Field> fields = ReflectionUtils.getAllFields(clazz, ReflectionUtils.withAnnotation(ElementIndex.class));

		ElementIndex index = null;

		for (Field fieldI : fields) {
			ElementMap annotation = fieldI.getAnnotation(ElementMap.class);
			if (annotation.name().equals(elementName)) {
				index = fieldI.getAnnotation(ElementIndex.class);
				break;
			}
		}

		return index;
	}

}
