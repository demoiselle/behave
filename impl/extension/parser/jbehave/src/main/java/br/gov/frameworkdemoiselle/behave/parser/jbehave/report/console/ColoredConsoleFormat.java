package br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console;

import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class ColoredConsoleFormat extends Format {

	public ColoredConsoleFormat() {
		super("COLORED_CONSOLE");
	}

	@Override
	public StoryReporter createStoryReporter(FilePrintStreamFactory factory, StoryReporterBuilder storyReporterBuilder) {
		return new ColoredConsoleOutput(storyReporterBuilder.keywords())
				.doReportFailureTrace(storyReporterBuilder.reportFailureTrace())
				.doCompressFailureTrace(storyReporterBuilder.compressFailureTrace());
	}
}