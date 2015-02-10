package br.gov.frameworkdemoiselle.behave.regression;

import java.util.Properties;

import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.internal.util.PropertiesLoaderUtil;

public class RegressionConfig {

	private static Properties properties;

	private static String currentType;

	private static Logger log = Logger.getLogger(RegressionConfig.class);

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
	 * Verifica se a propriedade foi setada antes no System.properties. Nesta
	 * caso o System sobrescreve todas as outras
	 * 
	 * @param key
	 *            Chave
	 * @param defaultValue
	 *            Valor padrão
	 * @return
	 */
	public static String getProperty(String key, String defaultValue) {
		if (!properties.containsKey(key)) {
			return defaultValue;
		} else {
			String value = System.getProperty(key);
			if (value != null) {
				properties.setProperty(key, value);
			}
			return properties.getProperty(key, defaultValue);
		}
	}

	/**
	 * Obter propriedade sem passagem do valor padrao
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return getProperty(key, "");
	}

	public static void setCoreProperty(String key, String value) {
		properties.setProperty(key, value);
	}

	public static void setCoreProperty(String key, Long value) {
		properties.setProperty(key, value.toString());
	}

	public static void setCoreProperty(String key, Boolean value) {
		properties.setProperty(key, value.toString());
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

	// Localização do driver que faz ligação entre o navegador e o webdriver
	public static String[] getTypes() {
		String[] types = getProperty("behave.regression.types").split(",");

		for (String s : types) {
			log.info("Navegador: " + s);
		}

		return types;
	}

	public static String getCurrentType() {
		return currentType;
	}

	public static void setCurrentType(String currentType) {
		RegressionConfig.currentType = currentType;

		// Seta todas as propriedades do core
		setCoreProperty("behave.runner.screen.maxWait", getRunner_ScreenMaxWait());
		setCoreProperty("behave.runner.screen.minWait", getRunner_ScreenMinWait());
		setCoreProperty("behave.runner.proxy.enabled", getRunner_ProxyEnabled());
		setCoreProperty("behave.runner.proxy.url", getRunner_ProxyURL());
		setCoreProperty("behave.runner.screen.driverPath", getRunner_ScreenDriverPath());
		setCoreProperty("behave.runner.profile.enabled", getRunner_ProfileEnabled());
		setCoreProperty("behave.runner.screen.remote.url", getRunner_RemoteUrl());
		setCoreProperty("behave.runner.screen.remote.name", getRunner_RemoteName());
		setCoreProperty("behave.runner.screen.profilePath", getRunner_ProfilePath());
		setCoreProperty("behave.runner.screen.binaryPath", getRunner_BinaryPath());
		setCoreProperty("behave.runner.screen.type", getRunner_ScreenType());
		setCoreProperty("behave.runner.catchUIException", getRunner_CatchUIException());
		setCoreProperty("behave.runner.window.maximize.enabled", getRunner_WindowMaximizeEnabled());

	}

	// Default Type
	public static String getRunner_DefaultType() {
		return getProperty("behave.regression.defaultType");
	}

	/** RUNNER Properties **/

	// Tempo máximo de espera em uma ação na tela
	public static Long getRunner_ScreenMaxWait() {
		return Long.parseLong(getProperty("behave.regression." + currentType + ".runner.screen.maxWait", "10000"));
	}

	// Tempo mínimo de espera em uma ação na tela
	public static Long getRunner_ScreenMinWait() {
		return Long.parseLong(getProperty("behave.regression." + currentType + ".runner.screen.minWait", "100"));
	}

	// Ativa ou desativa o uso de proxy no navegador
	public static boolean getRunner_ProxyEnabled() {
		return Boolean.parseBoolean(getProperty("behave.regression." + currentType + ".runner.proxy.enabled", "false"));
	}

	// URL do proxy
	public static String getRunner_ProxyURL() {
		return getProperty("behave.regression." + currentType + ".runner.proxy.url", "");
	}

	// Localização do driver que faz ligação entre o navegador e o webdriver
	public static String getRunner_ScreenDriverPath() {
		return getProperty("behave.regression." + currentType + ".runner.screen.driverPath", "");
	}

	// Ativa o uso de profile no navegador
	public static boolean getRunner_ProfileEnabled() {
		return Boolean.parseBoolean(getProperty("behave.regression." + currentType + ".runner.profile.enabled", "false"));
	}

	// Para execução remota
	public static String getRunner_RemoteUrl() {
		return getProperty("behave.regression." + currentType + ".runner.screen.remote.url", "");
	}

	public static String getRunner_RemoteName() {
		return getProperty("behave.regression." + currentType + ".runner.screen.remote.name", "");
	}

	// Localização do profile
	public static String getRunner_ProfilePath() {
		return getProperty("behave.regression." + currentType + ".runner.screen.profilePath", "");
	}

	// Localização do binário do navegador
	public static String getRunner_BinaryPath() {
		return getProperty("behave.regression." + currentType + ".runner.screen.binaryPath", "");
	}

	public static String getRunner_ScreenType() {
		return getProperty("behave.regression." + currentType + ".runner.screen.type", "");
	}

	public static String getRunner_CatchUIException() {
		return getProperty("behave.regression." + currentType + ".runner.catchUIException");
	}

	// Ativa o uso maximizada da janela do navegador
	public static boolean getRunner_WindowMaximizeEnabled() {
		return Boolean.parseBoolean(getProperty("behave.regression." + currentType + ".runner.window.maximize.enabled", "false"));
	}

}
