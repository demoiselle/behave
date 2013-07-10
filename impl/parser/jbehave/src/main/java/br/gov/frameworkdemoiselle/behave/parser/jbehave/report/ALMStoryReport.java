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

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.integration.Integration;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;

public class ALMStoryReport implements StoryReporter {

	Logger log = Logger.getLogger(ALMStoryReport.class);
	Story story;
	String currentScenarioTitle;

	// Datas para o calculo do tempo
	Hashtable<String, Date> startDateScenario = new Hashtable<String, Date>();
	Hashtable<String, Date> endDateScenario = new Hashtable<String, Date>();
	Hashtable<String, Boolean> failedScenario = new Hashtable<String, Boolean>();
	Hashtable<String, String> stepsScenario = new Hashtable<String, String>();

	protected Integration integration = (Integration) InjectionManager.getInstance().getInstanceDependecy(Integration.class);

	public void storyNotAllowed(Story story, String filter) {
	}

	public void storyCancelled(Story story, StoryDuration storyDuration) {
	}

	public void beforeStory(Story story, boolean givenStory) {
		this.story = story;
	}

	public void afterStory(boolean givenStory) {
		try {
			for (Scenario scenario : story.getScenarios()) {
				// Somente envia para a ALM se o cenário tem Título (Title)
				if (!scenario.getTitle().equals("")) {
					Meta meta = scenario.getMeta();

					Hashtable<String, Object> scenarioData = new Hashtable<String, Object>();
					scenarioData.put("name", scenario.getTitle());
					scenarioData.put("startDate", startDateScenario.get(scenario.getTitle()));
					scenarioData.put("endDate", endDateScenario.get(scenario.getTitle()));
					scenarioData.put("failed", failedScenario.get(scenario.getTitle()));
					scenarioData.put("steps", stepsScenario.get(scenario.getTitle()));
					scenarioData.put("testPlanId", BehaveConfig.getIntegration_TestPlanId());
					scenarioData.put("details", "Resultado enviado pelo Demoiselle Behave");

					if (meta.hasProperty("casodeteste")) {
						scenarioData.put("testCaseId", meta.getProperty("casodeteste"));
					}

					integration.sendScenario(scenarioData);
				}
			}
		} catch (BehaveException e) {
			log.error("Erro no envio de dados para integração.", e);
		}
	}

	public void narrative(Narrative narrative) {
	}

	public void scenarioNotAllowed(Scenario scenario, String filter) {
	}

	public void beforeScenario(String scenarioTitle) {
		currentScenarioTitle = scenarioTitle;

		// Reinicia as variáveis
		startDateScenario.put(scenarioTitle, GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime());
		failedScenario.put(scenarioTitle, false);
		stepsScenario.put(currentScenarioTitle, "");
	}

	public void scenarioMeta(Meta meta) {
	}

	public void afterScenario() {
		endDateScenario.put(currentScenarioTitle, GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime());
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
		String newString = stepsScenario.get(currentScenarioTitle) + "<br/>" + step;
		stepsScenario.put(currentScenarioTitle, newString);
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
		failedScenario.put(currentScenarioTitle, true);

		// Adiciona o erro nos steps para aparecer na ALM
		String newString = stepsScenario.get(currentScenarioTitle) + "<br/><br/><b>Erro:</b> <em>" + cause.getCause() + "</em>";
		stepsScenario.put(currentScenarioTitle, newString);
	}

	public void failedOutcomes(String step, OutcomesTable table) {
	}

	public void restarted(String step, Throwable cause) {
	}

	public void dryRun() {
	}

	public void pendingMethods(List<String> methods) {
	}

}
