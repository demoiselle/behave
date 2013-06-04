package br.gov.frameworkdemoiselle.behave.parser.jbehave.report;

import org.jbehave.core.io.UnderscoredToCapitalized;
import org.jbehave.core.reporters.TemplateableViewGenerator;

public class ALMViewGenerator extends TemplateableViewGenerator {

	public ALMViewGenerator() {
		this(new UnderscoredToCapitalized());
	}

	public ALMViewGenerator(UnderscoredToCapitalized underscoredToCapitalized) {
		super(underscoredToCapitalized, new ALMTemplateProcessor());
	}

}
