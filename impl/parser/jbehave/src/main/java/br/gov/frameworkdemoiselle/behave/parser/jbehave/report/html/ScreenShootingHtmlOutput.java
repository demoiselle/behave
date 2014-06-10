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

import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.failures.UUIDExceptionWrapper;
import org.jbehave.core.model.Story;
import org.jbehave.core.reporters.HtmlOutput;
import org.jbehave.core.reporters.StoryReporterBuilder;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.JBehaveParser;
import br.gov.frameworkdemoiselle.behave.runner.Runner;

public class ScreenShootingHtmlOutput extends HtmlOutput {

	private static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);
	private ScreenShootingMaker maker;
	private static final Logger logger = Logger.getLogger(ScreenShootingHtmlOutput.class);

	public ScreenShootingHtmlOutput(PrintStream output, StoryReporterBuilder reporterBuilder,
			Keywords keywords) {
		super(output, keywords);
		this.maker = new ScreenShootingMaker(reporterBuilder);
		
		// Verifica se existe um runner para ter screenshot
		Runner runner = null;		
		try {
			runner = (Runner) InjectionManager.getInstance().getInstanceDependecy(Runner.class);
		} catch (BehaveException e) {
		}
		
		if (runner != null) {					
			super.overwritePattern("failed", "<div class=\"step failed\">{0} <span class=\"keyword failed\">({1})</span><br/><span class=\"message failed\">{2}</span>" + "<br/><img src=\"screenshots/failed-scenario-{3}.png\" alt=\"failing screenshot\"/><br/><a href=\"screenshots/failed-scenario-{3}.png.html\" alt=\"failing screenshot html\" target=\"_blank\">View Html</a></div>\n");
		} else {
			super.overwritePattern("failed", "<div class=\"step failed\">{0} <span class=\"keyword failed\">({1})</span><br/><span class=\"message failed\">{2}</span></div>\n");	
		}
	}

	@Override
	public void afterStory(boolean givenStory) {
		super.afterStory(givenStory);
		print("\n</body>\n</html>");
	}

	@Override
	public void beforeStory(Story story, boolean givenStory) {
		print("<html>\n<head>\n\t<style type=\"text/css\">@import \"view/style/jbehave-core.css\";</style>\n</head>\n\n<body>\n");
		super.beforeStory(story, givenStory);
	}

	@Override
	public void failed(String step, Throwable storyFailure) {
		super.failed(step, storyFailure);
		try {
			if (storyFailure instanceof UUIDExceptionWrapper) {
				UUIDExceptionWrapper uuidWrappedFailure = (UUIDExceptionWrapper) storyFailure;
				this.maker.afterScenarioFailure(uuidWrappedFailure);				
			} else {
				logger.warn(message.getString("exception-screen-not-save"));
			}
		} catch (Exception ex) {
			logger.warn(message.getString("exception-screen-unexpected"));
		}
	}
}