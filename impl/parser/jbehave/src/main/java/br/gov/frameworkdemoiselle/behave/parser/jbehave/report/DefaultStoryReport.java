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
package br.gov.frameworkdemoiselle.behave.parser.jbehave.report;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.JBehaveParser;

public class DefaultStoryReport implements StoryReporter {

	private static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);
	private Logger log = Logger.getLogger(DefaultStoryReport.class);

	public void storyNotAllowed(Story story, String filter) {

	}

	public void storyCancelled(Story story, StoryDuration storyDuration) {

	}

	public void beforeStory(Story story, boolean givenStory) {

	}

	public void afterStory(boolean givenStory) {

	}

	public void narrative(Narrative narrative) {

	}

	public void scenarioNotAllowed(Scenario scenario, String filter) {

	}

	public void beforeScenario(String scenarioTitle) {
		BehaveContext.getInstance().setCurrentScenario(scenarioTitle);
	}

	public void scenarioMeta(Meta meta) {

	}

	public void afterScenario() {

	}

	public void givenStories(GivenStories givenStories) {

	}

	public void givenStories(List<String> storyPaths) {

	}

	public void beforeExamples(List<String> steps, ExamplesTable table) {

	}

	public void example(Map<String, String> tableRow) {

	}

	public void afterExamples() {

	}

	public void beforeStep(String step) {
		if (BehaveConfig.getParser_DelayBetweenSteps() != 0) {
			log.debug(message.getString("message-parser-delay-between-steps", BehaveConfig.getParser_DelayBetweenSteps()));
			try {
				Thread.sleep(BehaveConfig.getParser_DelayBetweenSteps() * 1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public void successful(String step) {

	}

	public void ignorable(String step) {

	}

	public void pending(String step) {

	}

	public void notPerformed(String step) {

	}

	public void failed(String step, Throwable cause) {
		if (cause.getCause() != null && cause.getCause() instanceof AssertionError) {
			BehaveContext.getInstance().fail(step, cause.getCause());
		} else {
			BehaveContext.getInstance().fail(step, cause);
		}
	}

	public void failedOutcomes(String step, OutcomesTable table) {

	}

	public void restarted(String step, Throwable cause) {

	}

	public void dryRun() {

	}

	public void pendingMethods(List<String> methods) {

	}

	public void lifecyle(Lifecycle lifecycle) {

	}

	public void restartedStory(Story story, Throwable cause) {
		
	}
}
