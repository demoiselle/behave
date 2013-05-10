package br.gov.frameworkdemoiselle.behave.util;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO: Revisar tratamentos de exceção
 * 
 * @author SERPRO
 * 
 */

public class PropertiesLoaderUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	private static PropertiesLoaderUtil config;
	private Properties allProps;

	private Logger logger = Logger.getLogger(this.toString());

	private PropertiesLoaderUtil() throws IOException {
		this.allProps = loadProperties();
	}

	public static synchronized PropertiesLoaderUtil getInstance() throws IOException {
		if (config == null) {
			config = new PropertiesLoaderUtil();
		}
		return config;
	}

	public Properties getProperties() {
		return allProps;
	}

	private Properties loadProperties() throws IOException {

		ArrayList<ConfigLevelPropertie> confs = new ArrayList<ConfigLevelPropertie>();

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Enumeration<URL> urls = loader.getResources("behave.properties");

		// Adiciona todos os properties (behave.properties) em um array list
		// desordenado
		while (urls.hasMoreElements()) {

			URL url = (URL) urls.nextElement();

			Properties localProp = new Properties();
			localProp.load(url.openStream());

			Integer level = null;
			if (localProp.containsKey("load.level")) {
				level = Integer.parseInt(localProp.getProperty("load.level"));
				confs.add(new ConfigLevelPropertie(level, localProp));
			} else {
				level = Integer.MAX_VALUE;
				confs.add(new ConfigLevelPropertie(level, localProp));
			}
			
			logger.log(Level.INFO, "Carregando configuração [" + url + "] com nível " + level);
		}

		// Ordena por level
		Collections.sort(confs);

		// Faz o merge de todos levando em consideração o level
		Properties allProperties = new Properties();
		for (ConfigLevelPropertie prop : confs) {
			allProperties.putAll(prop.properties);
		}
		
		logger.log(Level.INFO, "Language " + allProperties.getProperty("behave.parser.language"));		

		return allProperties;
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
