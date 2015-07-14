/*
 * Demoiselle Framework
 * Copyright (C) 2015 SERPRO
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
package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.StoryLocation;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.FilePrintStreamFactory.AbstractPathResolver;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ParameterConverter;
import org.jbehave.core.steps.StepFinder;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.util.FileUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.Parser;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.converter.MapConverter;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.report.ALMStoryReport;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.report.DefaultStoryReport;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.report.console.ColoredConsoleFormat;
import br.gov.frameworkdemoiselle.behave.parser.jbehave.report.html.ScreenShootingHtmlFormat;

public class JBehaveParser extends ConfigurableEmbedder implements Parser {

	private Logger logger = Logger.getLogger(JBehaveParser.class);
	private Configuration configuration;

	public static String MESSAGEBUNDLE = "demoiselle-parser-jbehave-bundle";
	private static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);

	private List<String> storyPaths = new ArrayList<String>();
	private List<Step> steps = new ArrayList<Step>();

	public JBehaveParser() {
		try {
			logger.info(message.getString("message-parser-config"));

			StoryReporter storyReporter = BehaveConfig.getIntegration_Enabled() ? new ALMStoryReport() : new DefaultStoryReport();

			ParameterConverters parameterConverters = new ParameterConverters();
			parameterConverters.addConverters(new ParameterConverter[] { new DateConverter(new SimpleDateFormat("dd/MM/yyyy")), new MapConverter() });

			configuration = new Configuration() {
			};

			// Utilizado para possibilitar a utilização de cenários
			// parametrizados (Exemplos)
			configuration.useParameterControls(new ParameterControls().useDelimiterNamedParameters(true));
			configuration.useParameterConverters(parameterConverters);
			configuration.useKeywords(getKeywordsLocale());
			configuration.useStepFinder(new StepFinder());
			configuration.useStoryControls(new StoryControls());
			configuration.useStoryParser(new RegexStoryParser(configuration.keywords()));
			configuration.useStoryReporterBuilder(new StoryReporterBuilder().withReporters(storyReporter).withFormats(getFormats()).withPathResolver(new ResolveReportPathFix()));

		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-init-parser"), e);
		}
	}

	public static class ResolveReportPathFix extends AbstractPathResolver {
		public String resolveName(StoryLocation storyLocation, String extension) {
			String name = storyLocation.getPath();
			if (StringUtils.contains(name, File.separator)) {
				name = StringUtils.substringAfterLast(name, File.separator);
			}
			return StringUtils.substringBeforeLast(name, ".") + "." + extension;
		}
	}

	public Keywords getKeywordsLocale() {
		return new LocalizedKeywords(new Locale("pt"));
	}

	public void run() {
		logger.info(message.getString("message-parser-started"));

		// Embedded controls
		EmbedderControls embedderControls = configuredEmbedder().embedderControls();
		embedderControls.useStoryTimeouts(BehaveConfig.getParser_StoryTimeout());
		embedderControls.doGenerateViewAfterStories(true);
		embedderControls.doIgnoreFailureInStories(true);
		embedderControls.doIgnoreFailureInView(true);
		embedderControls.doSkip(false);
		embedderControls.doVerboseFailures(true);

		Embedder embedder = new Embedder();

		// Seleciona os Embedder Controls
		embedder.useEmbedderControls(embedderControls);

		// Seleciona as configurações
		embedder.useConfiguration(configuration);

		// Sempre seleciona o steps factory
		embedder.useStepsFactory(stepsFactory());

		try {
			logger.info(message.getString("message-execute-history", storyPaths.toString()));
			embedder.runStoriesAsPaths(storyPaths);
		} finally {
			embedder.generateCrossReference();
		}
		logger.info(message.getString("message-parser-end"));
	}

	@Override
	public Configuration configuration() {
		return configuration;
	}

	@Override
	public InjectableStepsFactory stepsFactory() {

		// Limpa os passos atuais
		steps.clear();

		// Pega os steps do Context
		steps.addAll(BehaveContext.getInstance().getSteps());

		if (BehaveConfig.getParser_BeforeAfterStepsEnabled()) {
			steps.add(new BeforeAfterSteps());
		}

		if (BehaveConfig.getParser_CommonsStepsEnabled()) {
			steps.add(new CommonSteps());
			steps.add(new DataProviderSteps());
			steps.add(new DialogSteps());
			steps.add(new DebugSteps());
			steps.add(new TableSteps());
			steps.add(new MouseControlSteps());
			steps.add(new DataGenerationSteps());
			steps.add(new CheckBoxRadioSteps());
		}

		return new InstanceStepsFactory(configuration(), steps.toArray());
	}

	@Override
	public void setStoryPaths(List<String> storyPaths) {
		List<String> aux = new ArrayList<String>();
		for (String str : storyPaths) {
			aux.add(str.replace(FileUtil.getAbsolutePath() + File.separatorChar, ""));
		}
		this.storyPaths = aux;
	}

	@Override
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	private Format[] getFormats() {

		Format console = Format.CONSOLE;
		// Verifica se existe uma variável de ambiente chamada COLORED_CONSOLE e
		// ela possui valor diferente de zero.
		// No console é necessário fazer: export COLORED_CONSOLE=1
		String ambiente = System.getenv("COLORED_CONSOLE");
		if (!StringUtils.isEmpty(ambiente) && !"0".equals(ambiente.toLowerCase())) {
			console = new ColoredConsoleFormat();
		}

		Format screenshootingFormat = new ScreenShootingHtmlFormat(getKeywordsLocale());

		return new Format[] { console, screenshootingFormat, Format.STATS };
	}

}
