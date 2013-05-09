package br.gov.frameworkdemoiselle.behave.parser.cucumber;

import java.util.ResourceBundle;

//TODO Verificar a melhor forma de utilizar o resourcebundle no contexto do config
public class CucumberConfig {
	 
	public static ResourceBundle resources;
	 
	public static final String LANGUAGE;
	public static final String IDENTIFICATION_SCENARIO_PATTERN;
	public static final String PREFIXES_BDD_PATTERN;
	
	static{
//		resources = ResourceBundle.getBundle("/home/64392074587/Serpro/workspace-behave/behave/impl/extension/parser/cucumber/src/main/resources/br/gov/frameworkdemoiselle/behave/parser/cucumber/demoiselle.properties");
		resources = ResourceBundle.getBundle("br.gov.frameworkdemoiselle.behave.parser.cucumber.demoiselle");
		LANGUAGE = resources.getString("behave.parser.cucumber.language");
		IDENTIFICATION_SCENARIO_PATTERN = resources.getString("behave.parser.cucumber.identification.scenario.pattern."+LANGUAGE);
		PREFIXES_BDD_PATTERN = resources.getString("behave.parser.cucumber.prefixes.bdd.pattern."+LANGUAGE);
	}
	 
}
