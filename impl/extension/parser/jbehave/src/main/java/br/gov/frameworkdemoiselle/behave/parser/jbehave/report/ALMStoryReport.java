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
		for (Scenario scenario : story.getScenarios()) {

			// A principio a meta informação do cenário não será utilizada, mas
			// futuramente é possível que seja necessária a utilização
			// Meta meta = scenario.getMeta();

			Hashtable<String, Object> scenarioData = new Hashtable<String, Object>();
			scenarioData.put("name", scenario.getTitle());
			scenarioData.put("startDate", startDateScenario.get(scenario.getTitle()));
			scenarioData.put("endDate", endDateScenario.get(scenario.getTitle()));
			scenarioData.put("failed", failedScenario.get(scenario.getTitle()));
			scenarioData.put("steps", stepsScenario.get(scenario.getTitle()));
			scenarioData.put("testPlanId", BehaveConfig.getIntegrationTestPlanId());

			integration.sendScenario(scenarioData);
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
		String newString = step + "<br/>" + stepsScenario.get(currentScenarioTitle);
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
