package br.gov.frameworkdemoiselle.behave.regression.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.regression.Result;
import br.gov.frameworkdemoiselle.behave.regression.report.exception.BehaveRegressionReportException;
import br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.ImageMagickCompare;
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

			if (defaultType == null)
				throw new BehaveRegressionReportException("Deve ser informado um navegador (Type) padrão para comparação.");

			// Verifica se o defaultType existe nos Locations
			List<String> locationsListForVerifyDefault = FactoryRepository.getInstance().getLocations();
			
			defaultType = (defaultType.indexOf("/") == -1) ? "/" + defaultType : defaultType;
			
			if (locationsListForVerifyDefault.indexOf(defaultType) == -1)
				throw new BehaveRegressionReportException("O navegador parão (Default Type) deve existir nos Locations para comparação.");

			defaultType = defaultType.replaceAll("^/", "");

			List<Result> defaultTypeResults = FactoryRepository.getInstance().getResulstByLocation(defaultType);

			List<File> expectedFilesList = new ArrayList<File>();
			ArrayList<List<File>> browserFilesList = new ArrayList<List<File>>();
			List<String> types = new ArrayList<String>();

			getLog().info("Default Type/Location: " + defaultType);
			for (Result res : defaultTypeResults) {
				getLog().info("Default Type => Location: " + res.getFile().getAbsolutePath());
				expectedFilesList.add(res.getFile());
			}

			// Outros locations para comparação
			List<String> locationsList = FactoryRepository.getInstance().getLocations();
			for (String location : locationsList) {

				List<File> actualFilesList = new ArrayList<File>();
				String actualType = location.replaceAll("^/", "");

				// Se for o navegador padrão ele pula
				if (defaultType != null && defaultType.equals(actualType))
					continue;

				types.add(location);

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

				browserFilesList.add(actualFilesList);

			}

			// Faz todas as comparações
			ImageMagickCompare comp = new ImageMagickCompare(config, getLog());
			comp.compareAndCaptureResultsWithLists(types, browserFilesList, defaultType, expectedFilesList);

		} else {
			getLog().info("Funcionalidade de teste de regressão de layout desativada.");
		}
	}
}
