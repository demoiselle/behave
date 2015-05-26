package br.gov.frameworkdemoiselle.behave.regression.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.maven.plugin.logging.Log;

public class ReportConfig {
	
	private Properties properties = new Properties();
	private File target;
	private Log log;
	
	public ReportConfig(File target, Log log) {
		this.target = target;
		this.log = log;
		
		loadBehaveProperties();
		
		log.info("========================================");
		log.info("REGRESSION");
		log.info("========================================");
		log.info("target:" + target);
		log.info("behave.properties");
		log.info("enabled:" + getProperty("behave.regression.enabled"));
		log.info("repository type:" + getProperty("behave.regression.type"));
		log.info("repository url:" + getProperty("behave.regression.url"));
		log.info("repository user:" + getProperty("behave.regression.user"));
		log.info("repository password:" + getProperty("behave.regression.password"));

		log.info("types:" + getProperty("behave.regression.types"));
		log.info("defaultType:" + getProperty("behave.regression.defaultType"));
		log.info("========================================");
	}
	
	public String getProperty(String key){
		if (properties.containsKey(key)){
			return properties.getProperty(key);
		}else{
			return null;
		}
	}

	private void loadBehaveProperties() {
		String behaveProperties = target + "" + File.separatorChar + "test-classes" + File.separatorChar + "behave.properties";
		File file = new File(behaveProperties);
		if (file.exists()) {
			try {
				log.info("Load: " + behaveProperties);
				InputStream in = new FileInputStream(new File(behaveProperties));
				properties.load(in);
			} catch (Exception e) {
				log.error(e);
			}
		} else {
			log.debug(	"File behave.properties not found: " + behaveProperties);
		}		
	}	
}
