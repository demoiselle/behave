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
package br.gov.frameworkdemoiselle.behave.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.util.PropertiesLoaderUtil;

/**
 * Gerecia das configurações do Demoiselle Behave. Utiliza o arquivo behave.properties com a recurso
 * de sobrescrita no qual o arquivo do usuário sobrescreve qualquer outra propriedade.
 * 
 * Caso a propriedade seja informada na JVM está sobrescreverá as demais.
 * 
 * @author SERPRO
 *
 */
public class BehaveConfig {

	public static Properties properties;

	private static Logger log = Logger.getLogger(BehaveConfig.class);

	/**
	 * Carrega o behave.properties quando a classe é inicializada
	 */
	static {
		properties = PropertiesLoaderUtil.getInstance().getProperties();
	}	
	

	/**
	 * Retorna uma propriedade qualquer. Util quando o usuário deseja adicionar
	 * uma nova proprieade em seu projeto
	 * 
	 * Verifica se a propriedade foi setada antes no System.properties.
	 * Nesta caso o System sobrescreve todas as outras
	 * 
	 * @param key Chave
	 * @param defaultValue Valor padrão
	 * @return
	 */
	public static String getProperty(String key, String defaultValue) {
		if (!properties.containsKey(key)) {
			return defaultValue;
		} else {
			String value = System.getProperty(key);
			if (value != null){
				properties.setProperty(key, value);
			}		
			return properties.getProperty(key, defaultValue);
		}
	}
	
	/**
	 * Obter propriedade sem passagem do valor padrao
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return getProperty(key, "");
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

	/****** PARSER PROPERTIES ***********/

	//linguagem das estorias
	public static String getParser_Language() {
		return getProperty("behave.parser.language", "pt");
	}

	public static String getParser_IdentificationScenarioPattern() {
		return getProperty("behave.parser.identification.scenario.pattern." + getParser_Language());
	}

	public static String getParser_PrefixesBddPattern() {
		return getProperty("behave.parser.prefixes.bdd.pattern." + getParser_Language());
	}

	//prefixo do arquivo bdd
	public static String getParser_OriginalStoryFileExtension() {
		return getProperty("behave.parser.story.extension.original", "bdd");
	}
	
	//prefixo do arquivo de estorias
	public static String getParser_ConvertedStoryFileExtension() {
		return getProperty("behave.parser.story.extension.converted", "story");
	}

	public static boolean getParser_CommonsStepsEnabled() {
		return Boolean.parseBoolean(getProperty("behave.parser.commonssteps.enabled", "true"));
	}

	/** INTEGRATION PROPERTIES **/
	
	//habilita a integracao
	public static boolean getIntegration_Enabled() {
		return Boolean.parseBoolean(getProperty("behave.integration.alm.enabled", "false"));
	}
	
	//url de autenticacao
	public static String getIntegration_UrlSecurity() {
		return getProperty("behave.integration.alm.url.security");
	}
	
	//url de servicos
	public static String getIntegration_UrlServices() {
		return getProperty("behave.integration.alm.url.services");
	}
	
	//area de projeto
	public static String getIntegration_ProjectArea() {
		return getProperty("behave.integration.alm.projectArea");
	}
	
	//identifcicado do plano de testes
	public static String getIntegration_TestPlanId() {
		return getProperty("behave.integration.alm.testPlanId");
	}

	/** RUNNER Properties **/

	//Temo máximo para timeout de espera da tela
	public static Long getRunner_ScreenMaxWait() {
		return Long.parseLong(getProperty("behave.runner.screen.maxWait", "10000"));
	}

	//Tempo mínimo de espera da tela
	public static Long getRunner_ScreenMinWait() {
		return Long.parseLong(getProperty("behave.runner.screen.minWait", "100"));
	}
	
	//Modo proxy do navegador
	public static boolean getRunner_ProxyEnabled() {
		return Boolean.parseBoolean(getProperty("behave.runner.proxy.enabled", "false"));
	}
	//URL do proxy
	public static String getRunner_ProxyURL() {
		return getProperty("behave.runner.proxy.url");
	}
	
	//URL do proxy
	public static String getRunner_ScreenDriverPath() {
		return getProperty("behave.runner.screen.driverPath");
	}	
	
	public static String getRunner_ScreenType() {
		return getProperty("behave.runner.screen.type");
	}

	/**
	 * Exibe o valor das propriedades do DBehave caso o log esteja no modo debug
	 */
	public static void logValueProperties(){
		if (log.isDebugEnabled()) {
			ArrayList<String> propertieList = new ArrayList<String>();			
			log.debug("------- Propriedades ----------");
			Enumeration<Object> keys = properties.keys();
			while (keys.hasMoreElements()) {
				String key = (String) keys.nextElement();
				propertieList.add(key + "=" + properties.getProperty(key));
			}
			Collections.sort(propertieList);
			for(String properties: propertieList){
				log.debug(properties);
			}
			log.debug("-------------------------------");
		}
	}


}
