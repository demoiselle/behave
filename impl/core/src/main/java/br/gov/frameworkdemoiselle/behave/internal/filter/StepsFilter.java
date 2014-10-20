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
package br.gov.frameworkdemoiselle.behave.internal.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import br.gov.frameworkdemoiselle.behave.parser.Step;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;

public abstract class StepsFilter {

	@SuppressWarnings("rawtypes")
	public static List<Step> scanPackage(String name, Class... excludes) {

		List<Step> list = new ArrayList<Step>();

		for (PojoClass pc : PojoClassFactory.enumerateClassesByExtendingType(name, Step.class, null)) {
			try {
				if (excludes.length > 0) {
					if (!Arrays.asList(excludes).contains(pc.getClazz())) {
						list.add(createInstanceOf(Class.forName(pc.getClazz().getName())));
					}
				} else {
					list.add(createInstanceOf(Class.forName(pc.getClazz().getName())));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public static List<Step> scanPackage(String name, String excludes) {

		List<Step> list = new ArrayList<Step>();

		for (PojoClass pc : PojoClassFactory.enumerateClassesByExtendingType(name, Step.class, null)) {
			try {
				if (excludes != null) {
					if (!Pattern.compile(excludes).matcher(pc.getClazz().getName()).find()) {
						list.add(createInstanceOf(Class.forName(pc.getClazz().getName())));
					}
				} else {
					list.add(createInstanceOf(Class.forName(pc.getClazz().getName())));
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	private static Step createInstanceOf(Class<?> clazz) throws Throwable {
		return (Step) clazz.newInstance();
	}

}
