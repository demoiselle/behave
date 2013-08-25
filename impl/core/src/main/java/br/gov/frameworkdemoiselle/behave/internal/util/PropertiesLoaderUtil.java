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

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 * 
 */
public class PropertiesLoaderUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	private static PropertiesLoaderUtil config;
	private Properties allProps;
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE, Locale.getDefault());

	private static Logger log = Logger.getLogger(PropertiesLoaderUtil.class);

	private PropertiesLoaderUtil() throws IOException {
		this.allProps = loadProperties();
	}

	public static synchronized PropertiesLoaderUtil getInstance() {
		try {
			if (config == null) {
				config = new PropertiesLoaderUtil();
			}
			return config;
		} catch (IOException e) {
			throw new BehaveException(bm.getString("exception-error-load-properties-file"), e);
		}
	}

	public Properties getProperties() {
		return allProps;
	}

	private Properties loadProperties() {

		try {
			ArrayList<ConfigLevelPropertie> confs = new ArrayList<ConfigLevelPropertie>();

			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> urls = loader.getResources("behave.properties");

			// Adiciona todos os properties (behave.properties) em um array list
			// desordenado
			while (urls.hasMoreElements()) {

				URL url = (URL) urls.nextElement();

				Properties localProp = new Properties();
				localProp.load(url.openStream());

				log.debug("open: " + url.getFile().toString());

				Integer level = null;
				if (localProp.containsKey("load.level")) {
					level = Integer.parseInt(localProp.getProperty("load.level"));
					confs.add(new ConfigLevelPropertie(level, localProp));
				} else {
					level = Integer.MAX_VALUE;
					confs.add(new ConfigLevelPropertie(level, localProp));
				}

			}

			// Ordena por level
			Collections.sort(confs);

			// Faz o merge de todos levando em consideração o level
			Properties allProperties = new Properties();
			for (ConfigLevelPropertie prop : confs) {
				allProperties.putAll(prop.properties);
			}

			// logger.log(Level.INFO, "Language " +
			// allProperties.getProperty("behave.parser.language"));
			return allProperties;
		} catch (Exception ex) {
			throw new BehaveException(bm.getString("exception-error-load-properties-file"), ex);
		}
	}

	/**
	 * Classe auxiliar para ordenação das propriedades de cada jar
	 * 
	 * @author SERPRO
	 * 
	 */
	private class ConfigLevelPropertie implements Comparable<ConfigLevelPropertie> {

		public Integer level;
		public Properties properties;

		public ConfigLevelPropertie(Integer level, Properties prop) {
			this.level = level;
			this.properties = prop;
		}

		@Override
		public int compareTo(ConfigLevelPropertie o2) {
			return level.compareTo(o2.level);
		}

	}

}
