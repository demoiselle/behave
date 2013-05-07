package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.StepFinder;

import br.gov.frameworkdemoiselle.behave.parser.Parser;

public class JBehaveParser extends ConfigurableEmbedder implements Parser {

	private Logger logger = Logger.getLogger(this.toString());
	private Configuration configuration;

	public JBehaveParser() {
		logger.log(Level.INFO, "Configurando o JBheave");

		ParameterConverters parameterConverters = new ParameterConverters();
		parameterConverters.addConverters(new DateConverter(new SimpleDateFormat("dd/MM/yyyy")));

		configuration = new Configuration() {
		};

		configuration.useParameterConverters(parameterConverters);
		configuration.useKeywords(getKeywordsLocale());
		configuration.useStepFinder(new StepFinder());
		configuration.useStoryControls(new StoryControls());
		configuration.useStoryParser(new RegexStoryParser(configuration.keywords()));
		configuration.useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.HTML, Format.STATS));

		EmbedderControls embedderControls = configuredEmbedder().embedderControls();
		embedderControls.doBatch(false);
		embedderControls.doGenerateViewAfterStories(true);
		embedderControls.doIgnoreFailureInStories(false);
		embedderControls.doIgnoreFailureInView(false);
		embedderControls.doSkip(false);
		embedderControls.doVerboseFailures(false);
		embedderControls.doVerboseFiltering(false);
		embedderControls.useStoryTimeoutInSecs(60 * 60 * 24);
		embedderControls.useThreads(1);

	}

	public Keywords getKeywordsLocale() {
		return new LocalizedKeywords(new Locale("pt"));
	}

	public void run() throws Throwable {

		logger.log(Level.INFO, "Iniciou o PARSER JBehave");

		Embedder embedder = configuredEmbedder();
		try {
			embedder.runStoriesAsPaths(storyPaths());
		} finally {
			embedder.generateCrossReference();
		}

		logger.log(Level.INFO, "Finalizou PARSER JBehave");

	}

	@Override
	public Configuration configuration() {
		return configuration;
	}

	@Override
	public List<String> storyPaths() {
		ArrayList<String> stories = new ArrayList<String>();
		stories.add("stories/google.story");
		return stories;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new CommonSteps());
	}

}
