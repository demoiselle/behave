package br.gov.frameworkdemoiselle.behave.parser.jbehave.report;

import java.util.List;
import java.util.Map;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;

public class DefaultStoryReport implements StoryReporter {

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
		
	}

	public void successful(String step) {
		
	}

	public void ignorable(String step) {
		
	}

	public void pending(String step) {
		BehaveContext.getInstance().fail(step, new BehaveException("passo pendente"));	
	}

	public void notPerformed(String step) {		

	}

	public void failed(String step, Throwable cause) {
		if (cause.getCause() != null && cause.getCause() instanceof AssertionError){
			BehaveContext.getInstance().fail(step, cause.getCause());	
		}else{
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

}
