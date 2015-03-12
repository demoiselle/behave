package br.gov.frameworkdemoiselle.behave.regression.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.regression.Result;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.ImageMagickCompare;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util.ImageUtil;
import br.gov.frameworkdemoiselle.behave.regression.repository.FactoryRepository;

public class ReportContext {

	private ReportConfig config;
	private static Log log;

	public Log getLog() {
		if (log == null) {
			log = new SystemStreamLog();
		}
		return log;
	}

	public void run(File target) {
		// Carrega as configurações
		config = new ReportConfig(target, getLog());

		String enabled = config.getProperty("behave.regression.enabled");
		if (enabled != null && Boolean.parseBoolean(enabled)) {

			String defaultType = config.getProperty("behave.regression.defaultType");
			List<Result> defaultTypeResults = FactoryRepository.getInstance().getResulstByLocation(defaultType);

			List<File> expectedFilesList = new ArrayList<File>();
			List<File> actualFilesList = new ArrayList<File>();

			getLog().info("Default Type/Location: " + defaultType);
			for (Result res : defaultTypeResults) {
				getLog().info("Default Type => Location: " + res.getFile().getAbsolutePath());
				expectedFilesList.add(res.getFile());
			}

			// Outros locations para comparação
			List<String> locationsList = FactoryRepository.getInstance().getLocations();
			for (String location : locationsList) {

				// Se for o navegador padrão ele pula
				if (defaultType.replaceAll("^/", "").equals(location.replaceAll("^/", "")))
					continue;

				getLog().info("Location: " + location);

				List<Result> results = FactoryRepository.getInstance().getResulstByLocation(location);
				for (Result res : results) {
					if (res.getFile() != null) {
						getLog().info("Location: " + res.getFile().getAbsolutePath());
						actualFilesList.add(res.getFile());
					}
				}

				if (actualFilesList.size() != expectedFilesList.size())
					throw new BehaveException("Erro: os arrays não tem a mesma quantidade de cópias de tela! actualFilesList: " + actualFilesList.size() + " / expectedFilesList: " + expectedFilesList.size());

				try {
					// Tratamento da imagem
					for (int i = 0; i < actualFilesList.size(); i++) {
						ImageUtil.imageConvert(actualFilesList.get(i).getAbsolutePath(), expectedFilesList.get(i).getAbsolutePath());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				ImageMagickCompare comp = new ImageMagickCompare(config, getLog());
				comp.compareAndCaptureResultsWithList("report-teste-dbehave", actualFilesList, expectedFilesList);

				actualFilesList.clear();
			}

		}
	}

}
