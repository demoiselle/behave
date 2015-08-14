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
package br.gov.frameworkdemoiselle.behave.internal.dataprovider;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.internal.util.DataProviderUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 * 
 */
public class DefaultDataProvider implements DataProvider {
	
	private static Hashtable<String, Object> data;
	private static Logger logger = Logger.getLogger(DefaultDataProvider.class);
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);
	
	public DefaultDataProvider() {
		data = new Hashtable<String, Object>();
	}

	public void put(String key, Object value) {
		key = key.trim();
		data.put(key, value);
		logger.debug(bm.getString("message-dataprovider-found", key+":"+data.get(key).toString()));
	}
	
	public Object get(String key) {
		key = key.trim();
		return data.get(key);
	}

	public boolean containsKey(String key) {
		key = key.trim();
		return data.containsKey(key);
	}

	public void clear() {
		data.clear();
	}
}
