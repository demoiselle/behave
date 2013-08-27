package br.gov.frameworkdemoiselle.behave.parser.jbehave.report.html;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class ScreenShootingHtmlFormat extends Format {
	
	private Keywords keywords;

	public ScreenShootingHtmlFormat(Keywords keywords) {
		super("HTML");
		
		this.keywords = keywords;
	}

	@Override
	public StoryReporter createStoryReporter(FilePrintStreamFactory factory, StoryReporterBuilder builder) {
		factory.useConfiguration(builder.fileConfiguration("html"));

		return new ScreenShootingHtmlOutput(factory.createPrintStream(), builder, keywords)
				.doReportFailureTrace(builder.reportFailureTrace())
				.doCompressFailureTrace(builder.compressFailureTrace());
	}
}