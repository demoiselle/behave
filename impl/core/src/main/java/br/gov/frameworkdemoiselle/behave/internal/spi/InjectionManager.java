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
package br.gov.frameworkdemoiselle.behave.internal.spi;

import java.util.Hashtable;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe respónsável por utilizer a especificação SPI para encontrar os PARSERS
 * e RUNNERS disponíveis. Ele guarda os objetos em um hashtable para que o
 * objeto não seja instânciado em toda da a chamada.
 * 
 * @author SERPRO
 * 
 */
public class InjectionManager {

	private Hashtable<String, Object> singletons = new Hashtable<String, Object>();
	private static InjectionManager instance;

	private Logger logger = Logger.getLogger(this.toString());

	private InjectionManager() {
	}

	public static InjectionManager getInstance() {
		if (instance == null)
			instance = new InjectionManager();
		return instance;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getInstanceDependecy(Class clazz) {

		if (singletons.containsKey(clazz.toString())) {
			logger.log(Level.INFO, "Recuperada do singleton a classe " + clazz.toString());

			return singletons.get(clazz.toString());
		} else {
			ServiceLoader<Object> service = ServiceLoader.load(clazz);
			int count = 0;

			for (Object object : service) {
				if (count > 0) {
					throw new RuntimeException("Só pode existir 1 classe " + clazz.toString() + " selecionado no pom.xml como dependência.");
				}
				
				logger.log(Level.INFO, "Nova instânciada a classe " + object.getClass().toString());

				singletons.put(clazz.toString(), object);

				count++;
			}

			if (!singletons.containsKey(clazz.toString()))
				throw new RuntimeException("Não foram encontradas classes que implementem " + clazz.toString() + ".");

			return singletons.get(clazz.toString());
		}

	}

}
