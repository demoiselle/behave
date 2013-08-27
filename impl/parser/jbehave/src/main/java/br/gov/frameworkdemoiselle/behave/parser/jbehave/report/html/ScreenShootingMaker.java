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
