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
package br.gov.frameworkdemoiselle.behave.parser.jbehave.report.html;

import java.io.File;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.jbehave.core.failures.PendingStepFound;
import org.jbehave.core.failures.UUIDExceptionWrapper;
import org.jbehave.core.reporters.StoryReporterBuilder;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.JBehaveParser;
import br.gov.frameworkdemoiselle.behave.runner.Runner;

public class ScreenShootingMaker {

	private static final String DEFAULT_SCREENSHOT_PATH_PATTERN = "{0}" + File.separator + "view" + File.separator + "screenshots" + File.separator + "failed-scenario-{1}.png";
	private static final String DEFAULT_SCREENSHOT_PATH_PATTERN_WITH_SCENARIO = "{0}" + File.separator + "view" + File.separator + "screenshots-with-scenario" + File.separator + "failed-scenario-{1}-{2}.png";
	private static final Logger logger = Logger.getLogger(ScreenShootingMaker.class);
	private static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);

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

		// Não captura tela dos passos pendentes
		if (uuidWrappedFailure instanceof PendingStepFound) {
			return;
		}
		
		// Ignora o erro quando não existe o runner
		Runner runner = null;		
		try {
			runner = (Runner) InjectionManager.getInstance().getInstanceDependecy(Runner.class);
		} catch (BehaveException e) {
		}
		
		if (runner == null) {
			return;
		}
		
		String scenario = BehaveContext.getInstance().getCurrentScenario();
		String screenshotPathWithScenario = "";
		
		// Convert string to path
		if (scenario != null) {
			String ret = Normalizer.normalize(scenario, Normalizer.Form.NFD).replace(" ", "").replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			scenario = ret.replaceAll("[-]", "").replaceAll("[:]", "").replaceAll("[.]", "").replaceAll("[#]", "");
			screenshotPathWithScenario = screenshotPathWithScenario(scenario, uuidWrappedFailure.getUUID());
		}

		String screenshotPath = screenshotPath(uuidWrappedFailure.getUUID());
		
		String currentUrl = "";
		try {
			currentUrl = runner.getCurrentUrl();
		} catch (Exception e) {
		}

		try {
			runner.saveScreenshotTo(screenshotPath);
			if (!screenshotPathWithScenario.equals("")) {
				runner.saveScreenshotTo(screenshotPathWithScenario);
			}
		} catch (Exception ex) {
			logger.error(message.getString("exception-screen-save", currentUrl, screenshotPath, ex.getMessage()));
			logger.error(ex);
			return;
		}
		
		logger.info(message.getString("message-screen-save", currentUrl, screenshotPath, new File(screenshotPath).length()));

	}

	protected String screenshotPathWithScenario(String scenario, UUID uuid) {
		return MessageFormat.format(DEFAULT_SCREENSHOT_PATH_PATTERN_WITH_SCENARIO, reporterBuilder.outputDirectory(), scenario, uuid);
	}

	protected String screenshotPath(UUID uuid) {
		return MessageFormat.format(screenshotPathPattern, reporterBuilder.outputDirectory(), uuid);
	}
}
