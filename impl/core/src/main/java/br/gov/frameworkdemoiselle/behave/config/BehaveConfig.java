package br.gov.frameworkdemoiselle.behave.config;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.util.PropertiesLoaderUtil;

public class BehaveConfig {

	public static Properties properties;

	static void setProperties(Properties properties) {
		BehaveConfig.properties = properties;
	}

	private static String LANGUAGE = "pt";
	private static String IDENTIFICATION_SCENARIO_PATTERN = "";
	private static String PREFIXES_BDD_PATTERN = "";
	private static String ORIGINAL_STORY_FILE_EXTENSION = "bdd";
	private static String CONVERTED_STORY_FILE_EXTENSION = "story";
	private static boolean PARSER_COMMONS_STEPS_ENABLED = true;
	private static boolean INTEGRATION_ENABLED = false;

	private static Long BROWSER_MAX_WAIT = 10000L;
	private static Long BROWSER_MIN_WAIT = 100L;

	private static Logger log = Logger.getLogger(BehaveConfig.class);

	static {
		try {
			properties = PropertiesLoaderUtil.getInstance().getProperties();

			// Parser Properties
			LANGUAGE = properties.getProperty("behave.parser.language");
			IDENTIFICATION_SCENARIO_PATTERN = properties.getProperty("behave.parser.identification.scenario.pattern." + LANGUAGE);
			PREFIXES_BDD_PATTERN = properties.getProperty("behave.parser.prefixes.bdd.pattern." + LANGUAGE);

			ORIGINAL_STORY_FILE_EXTENSION = properties.getProperty("behave.parser.story.extension.original");
			CONVERTED_STORY_FILE_EXTENSION = properties.getProperty("behave.parser.story.extension.converted");
			PARSER_COMMONS_STEPS_ENABLED = Boolean.parseBoolean(properties.getProperty("behave.parser.commonssteps.enabled"));

			// Integration Properties
			INTEGRATION_ENABLED = Boolean.parseBoolean(properties.getProperty("behave.integration.alm.enabled"));

			if (properties.getProperty("behave.runner.browser.maxWait") != null)
				BROWSER_MAX_WAIT = Long.parseLong(properties.getProperty("behave.runner.browser.maxWait"));

			if (properties.getProperty("behave.runner.browser.minWait") != null)
				BROWSER_MIN_WAIT = Long.parseLong(properties.getProperty("behave.runner.browser.minWait"));
			if (log.isDebugEnabled()) {
				log.debug("Configurações do Demoiselle Behave:");
				Enumeration<Object> keys = properties.keys();
				while (keys.hasMoreElements()) {
					String key = (String) keys.nextElement();
					log.debug(key + "=" + properties.getProperty(key));
				}
				log.debug("--------------------------------");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna uma propriedade qualquer. Util quando o usuário deseja adicionar
	 * uma nova proprieade em seu projeto
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		if (properties == null || !properties.containsKey(key)) {
			throw new BehaveException("chave [" + key + "] não encontrondada");
		} else {
			return properties.getProperty(key);
		}
	}

	/**
	 * Retorna uma propriedade qualquer. Util quando o usuário deseja adicionar
	 * uma nova proprieade em seu projeto
	 * 
	 * @param key
	 * @return
	 */
	public static boolean contains(String key) {
		return properties.containsKey(key);
	}

	/****** Get Properties ***********/

	public static String getLanguage() {
		return LANGUAGE;
	}

	public static String getIdentificationScenarioPattern() {
		return IDENTIFICATION_SCENARIO_PATTERN;
	}

	public static String getPrefixesBddPattern() {
		return PREFIXES_BDD_PATTERN;
	}

	public static String getOriginalStoryFileExtension() {
		return ORIGINAL_STORY_FILE_EXTENSION;
	}

	public static String getConvertedStoryFileExtension() {
		return CONVERTED_STORY_FILE_EXTENSION;
	}

	public static boolean isParserCommonsSteosEnabled() {
		return PARSER_COMMONS_STEPS_ENABLED;
	}

	public static boolean isIntegrationEnabled() {
		return INTEGRATION_ENABLED;
	}

	public static Long getBrowserMaxWait() {
		return BROWSER_MAX_WAIT;
	}

	public static Long getBrowserMinWait() {
		return BROWSER_MIN_WAIT;
	}

}
