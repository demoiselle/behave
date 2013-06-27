package br.gov.frameworkdemoiselle.behave.parser.jbehave.report;

import java.io.Writer;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jbehave.core.reporters.PostStoryStatisticsCollector;
import org.jbehave.core.reporters.TemplateProcessor;

public class ALMTemplateProcessor implements TemplateProcessor {

	Logger log = Logger.getLogger(ALMTemplateProcessor.class);

	public ALMTemplateProcessor() {
		log.info(">> Carregou o processador da ALM");
	}

	public void process(String resource, Map<String, Object> dataModel, Writer writer) {
		log.info("-------------------- INICIO");

		for (String key : dataModel.keySet()) {
			if (dataModel.get(key) instanceof PostStoryStatisticsCollector) {
				PostStoryStatisticsCollector reportTable = (PostStoryStatisticsCollector) dataModel.get(key);
				log.info(">> " + reportTable.toString());
			}
			log.info(">> " + key + " - " + dataModel.get(key));
		}

		log.info("-------------------- FIM");
	}

}
