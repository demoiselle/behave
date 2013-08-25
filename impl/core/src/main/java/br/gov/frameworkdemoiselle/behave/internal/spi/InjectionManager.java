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

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

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
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	void setSingletons(Hashtable<String, Object> singletons) {
		this.singletons = singletons;
	}

	Logger log = Logger.getLogger(InjectionManager.class);

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
			return singletons.get(clazz.toString());
		} else {
			ServiceLoader<Object> service = ServiceLoader.load(clazz);
			for (Object object : service) {
				singletons.put(clazz.toString(), object);
				break;
			}
			if (!singletons.containsKey(clazz.toString())){
				throw new BehaveException(bm.getString("exception-injection-class-not-found", clazz.toString()));
			}
			return singletons.get(clazz.toString());
		}

	}

}
