package br.gov.frameworkdemoiselle.behave.config;

import java.io.IOException;
import java.util.Properties;

import br.gov.frameworkdemoiselle.behave.util.PropertiesLoaderUtil;

public class BehaveConfig {

	public static Properties properties;

	public static String LANGUAGE = "pt";
	public static String IDENTIFICATION_SCENARIO_PATTERN = "";
	public static String PREFIXES_BDD_PATTERN = "";

	static {
		try {
			properties = PropertiesLoaderUtil.getInstance().getProperties();

			// Parser Properties
			LANGUAGE = properties.getProperty("behave.parser.language");
			IDENTIFICATION_SCENARIO_PATTERN = properties.getProperty("behave.parser.identification.scenario.pattern." + LANGUAGE);
			PREFIXES_BDD_PATTERN = properties.getProperty("behave.parser.prefixes.bdd.pattern." + LANGUAGE);
			
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
