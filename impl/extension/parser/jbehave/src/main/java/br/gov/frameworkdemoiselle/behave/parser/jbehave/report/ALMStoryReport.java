package br.gov.frameworkdemoiselle.behave.parser.jbehave.report;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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

import br.gov.frameworkdemoiselle.behave.integration.Integration;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;

public class ALMStoryReport implements StoryReporter {

	Logger log = Logger.getLogger(ALMStoryReport.class);
	Story story;
	Boolean failed;

	protected Integration integration = (Integration) InjectionManager.getInstance().getInstanceDependecy(Integration.class);

	public void storyNotAllowed(Story story, String filter) {
		// TODO Auto-generated method stub

	}

	public void storyCancelled(Story story, StoryDuration storyDuration) {
		// TODO Auto-generated method stub

	}

	public void beforeStory(Story story, boolean givenStory) {
		this.story = story;
		this.failed = false;
	}

	public void afterStory(boolean givenStory) {
		log.info("--------------------------------------> START AFTER");

		for (Scenario scenario : story.getScenarios()) {

			Meta meta = scenario.getMeta();

			if (this.failed) {

			} else {

			}

			//

			integration.sendScenario(new Hashtable<String, Object>());

			log.info("----------- " + scenario.getTitle() + " ---------------");
			log.info(meta.toString());
		}

		log.info("---------------------------------------> END AFTER");
	}

	public void narrative(Narrative narrative) {
		// TODO Auto-generated method stub

	}

	public void scenarioNotAllowed(Scenario scenario, String filter) {
		// TODO Auto-generated method stub

	}

	public void beforeScenario(String scenarioTitle) {
		// TODO Auto-generated method stub

	}

	public void scenarioMeta(Meta meta) {
		// TODO Auto-generated method stub

	}

	public void afterScenario() {
		// TODO Auto-generated method stub

	}

	public void givenStories(GivenStories givenStories) {
		// TODO Auto-generated method stub

	}

	public void givenStories(List<String> storyPaths) {
		// TODO Auto-generated method stub

	}

	public void beforeExamples(List<String> steps, ExamplesTable table) {
		// TODO Auto-generated method stub

	}

	public void example(Map<String, String> tableRow) {
		// TODO Auto-generated method stub

	}

	public void afterExamples() {
		// TODO Auto-generated method stub

	}

	public void beforeStep(String step) {
		// TODO Auto-generated method stub

	}

	public void successful(String step) {
		// TODO Auto-generated method stub

	}

	public void ignorable(String step) {
		// TODO Auto-generated method stub

	}

	public void pending(String step) {
		// TODO Auto-generated method stub

	}

	public void notPerformed(String step) {
		// TODO Auto-generated method stub

	}

	public void failed(String step, Throwable cause) {
		// TODO Auto-generated method stub

		this.failed = true;

	}

	public void failedOutcomes(String step, OutcomesTable table) {
		// TODO Auto-generated method stub

	}

	public void restarted(String step, Throwable cause) {
		// TODO Auto-generated method stub

	}

	public void dryRun() {
		// TODO Auto-generated method stub

	}

	public void pendingMethods(List<String> methods) {
		// TODO Auto-generated method stub

	}

}
