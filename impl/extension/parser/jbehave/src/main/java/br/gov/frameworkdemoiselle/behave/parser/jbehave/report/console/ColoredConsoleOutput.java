package br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console;

import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.BOLD;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.CYAN;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.GREEN;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.RED;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.RESET;
import static br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ANSIColor.YELLOW;
import static org.jbehave.core.steps.StepCreator.PARAMETER_VALUE_END;
import static org.jbehave.core.steps.StepCreator.PARAMETER_VALUE_START;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.ConsoleOutput;

public class ColoredConsoleOutput extends ConsoleOutput implements Serializable {

private static final long serialVersionUID = 1L;
	
	private Map<String, ANSIColor> outputTypeColor = new ColeredHash();
	
	class ColeredHash extends HashMap<String, ANSIColor> {

		private static final long serialVersionUID = 1L;

		ColeredHash() {
			put("successful", GREEN);
			put("pending", YELLOW);
			put("pendingMethod", YELLOW);
			put("notPerformed", YELLOW);
			put("ignorable", CYAN);
			put("failed", RED);
		}
	}

	public ColoredConsoleOutput() {
		super();

	}

	public ColoredConsoleOutput(Keywords keywords) {
		super(keywords);
	}

	public ColoredConsoleOutput(Properties outputPatterns, Keywords keywords, boolean reportFailureTrace) {
		super(outputPatterns, keywords, reportFailureTrace);
	}

	public void assignColorToOutputType(String outputType, ANSIColor color) {
		outputTypeColor.put(outputType, color);
	}

	private String boldifyParams(String formatted, ANSIColor currentColor) {
		final String valueStart = lookupPattern(PARAMETER_VALUE_START, PARAMETER_VALUE_START);
		final String valueEnd = lookupPattern(PARAMETER_VALUE_END, PARAMETER_VALUE_END);
		return formatted.replaceAll(valueStart, escapeCodeFor(BOLD, currentColor)).replaceAll(valueEnd, escapeCodeFor(RESET, currentColor));
	}

	private String escape(String code) {
		return (char) 27 + "[" + code;
	}

	private String escapeCodeFor(ANSIColor code) {
		return escape(code + "m");
	}

	private String escapeCodeFor(ANSIColor first, ANSIColor second) {
		return escape(first + ";" + second + "m");
	}

	@Override
	protected String format(String outputType, String defaultPattern, Object... args) {
		final String formatted = super.format(outputType, defaultPattern, args);

		if (outputTypeColor.containsKey(outputType)) {
			ANSIColor color = outputTypeColor.get(outputType);
			return escapeCodeFor(color) + boldifyParams(formatted, color) + escapeCodeFor(RESET);
		}

		return formatted;
	}

	@Override
	public void overwritePattern(String key, String pattern) {
		super.overwritePattern(key, pattern);
	}
}