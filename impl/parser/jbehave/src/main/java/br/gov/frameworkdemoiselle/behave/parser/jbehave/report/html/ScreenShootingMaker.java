package br.gov.frameworkdemoiselle.behave.parser.jbehave.report.html;

import java.io.File;
import java.text.MessageFormat;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.jbehave.core.failures.PendingStepFound;
import org.jbehave.core.failures.UUIDExceptionWrapper;
import org.jbehave.core.reporters.StoryReporterBuilder;

import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.runner.Runner;

public class ScreenShootingMaker {

	private static final String DEFAULT_SCREENSHOT_PATH_PATTERN = "{0}/view/screenshots/failed-scenario-{1}.png";
	private static final Logger logger = Logger.getLogger(ScreenShootingMaker.class);
	
	protected final StoryReporterBuilder reporterBuilder;
	protected final String screenshotPathPattern;

	public ScreenShootingMaker() {
		this(new StoryReporterBuilder());
	}

	public ScreenShootingMaker(StoryReporterBuilder reporterBuilder) {
		this(reporterBuilder, DEFAULT_SCREENSHOT_PATH_PATTERN);
	}

	public ScreenShootingMaker(StoryReporterBuilder reporterBuilder, String screenshotPathPattern) {
		this.reporterBuilder = reporterBuilder;
		this.screenshotPathPattern = screenshotPathPattern;
	}

	public void afterScenarioFailure(UUIDExceptionWrapper uuidWrappedFailure) throws Exception {
		
		Runner runner = (Runner) InjectionManager.getInstance().getInstanceDependecy(Runner.class);	
		
		// Não captura tela dos passos pendentes
		if (uuidWrappedFailure instanceof PendingStepFound) {
			return;
		}
		String screenshotPath = screenshotPath(uuidWrappedFailure.getUUID());

		String currentUrl = "";
		try {
			currentUrl = runner.getCurrentUrl();
		} catch (Exception e) {
		}
		
		try {
			runner.saveScreenshotTo(screenshotPath);
		} catch (Exception ex) {			
			logger.warn("Erro ao salvar screenshot da página '" + currentUrl + "'. Caminho: " + screenshotPath
					+ ". Causa: " + ex.getMessage() + ".");
			ex.printStackTrace();
			return;			
		}

		logger.info("Screenshot da página '" + currentUrl + "' salvo em '" + screenshotPath + "' com "
					+ new File(screenshotPath).length() + " bytes");
	}

	protected String screenshotPath(UUID uuid) {
		return MessageFormat.format(screenshotPathPattern, reporterBuilder.outputDirectory(), uuid);
	}
}
