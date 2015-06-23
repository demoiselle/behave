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
package br.gov.frameworkdemoiselle.behave.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.filter.StepsFilter;
import br.gov.frameworkdemoiselle.behave.internal.filter.StoryOrScenarioFilter;
import br.gov.frameworkdemoiselle.behave.internal.parser.StoryFileConverter;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.Parser;
import br.gov.frameworkdemoiselle.behave.parser.Step;

/**
 * 
 * @author SERPRO
 * 
 */
public class BehaveContext {

	public static final BehaveContext instance = new BehaveContext();

	private Parser parser;

	private static Logger log = Logger.getLogger(BehaveContext.class);

	private ArrayList<String> allOriginalStoriesPath = new ArrayList<String>();

	private StoryOrScenarioFilter storyOrScenarioFilter = null;

	private List<Step> steps = new ArrayList<Step>();

	private List<String> storiesPath = new ArrayList<String>();

	private List<String> storiesReusePath = new ArrayList<String>();

	private Throwable fail;

	private String failStep;

	private String currentScenario = "";

	private BehaveMessage bm;

	private BehaveContext() {
		bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);
	}

	public static BehaveContext getInstance() {
		return instance;
	}

	public void addSteps(Step step) {
		steps.add(step);
	}

	public List<Step> getSteps() {
		return steps;
	}

	// Métodos para rodar o teste
	public void run(List<String> storiesFiles) {
		try {
			log.info("--------------------------------");
			log.info(bm.getString("message-behave-start"));
			log.info("Demoiselle Behave " + BehaveConfig.getProperty("behave.version"));
			log.info("--------------------------------");

			BehaveConfig.logValueProperties();

			if (storiesFiles == null || storiesFiles.isEmpty()) {
				throw new BehaveException(bm.getString("exception-empty-story-list"));
			}

			// Correção de bug: Substitui as barras por File.separator para
			// funcionar de acordo com o SO
			ArrayList<String> listNewPaths = new ArrayList<String>();
			for (String s : storiesFiles) {
				listNewPaths.add(s.replace("\\", File.separator).replace("/", File.separator));
			}

			// Adiciono as novas histórias no array com TODAS, inclusive as da
			// execução anterior
			allOriginalStoriesPath.addAll(listNewPaths);

			// Lista de historias só para reuso de cenários
			ArrayList<String> listNewPathsReuse = new ArrayList<String>();
			for (String s : storiesReusePath) {
				listNewPathsReuse.add(s.replace("\\", File.separator).replace("/", File.separator));
			}

			// Adiciono as novas historias só para reuso de cenários
			allOriginalStoriesPath.addAll(listNewPathsReuse);

			// Faz a conversão
			List<String> allStoriesConverted = StoryFileConverter.convertReusedScenarios(allOriginalStoriesPath, BehaveConfig.getParser_OriginalStoryFileExtension(), BehaveConfig.getParser_ConvertedStoryFileExtension(), true);

			// Cria um novo array contendo somente as histórias atuais
			// Correção de bug: Quando a história é explicitamente enviada novamente ao run ela tem que rodar
			// Correção de bug: Quando existe reutilização de história ele alterava a ordem da execução atual de acordo com a reutilização
			List<String> finalArray = new ArrayList<String>();
			for (String storyFile : listNewPaths) {
				for (String storyFileC : allStoriesConverted) {
					if (storyFileC.contains(storyFile)) {
						finalArray.add(storyFileC);
					}
				}
			}

			// Roda o runner com as histórias convertidas
			parser = (Parser) InjectionManager.getInstance().getInstanceDependecy(Parser.class);
			// parser.setSteps(steps); // Na versão 3.9 do JBehave foi alterada a ordem de carregamento dos steps
			parser.setStoryPaths(finalArray);
			parser.run();
			if (fail != null) {
				Assert.fail(bm.getString("exception-fail-step", failStep, fail.getMessage()));
			}
		} catch (BehaveException ex) {
			log.error(bm.getString("exception-general"), ex);
			throw ex;
		} finally {
			fail = null;
			failStep = null;
			storyOrScenarioFilter = null;
			storiesPath.clear();
			storiesReusePath.clear();
			steps.clear();

			log.info("--------------------------------");
			log.info(bm.getString("message-behave-end"));
			log.info("--------------------------------");
		}
	}

	public void run(String storiesPath) {
		ArrayList<String> stories = new ArrayList<String>();
		stories.add(storiesPath);
		run(stories);
	}

	public void run() {
		run(storiesPath);
	}

	public void run(String storiesPath, StoryOrScenarioFilter storyOrScenarioFilter) {
		setStoryOrScenarioFilter(storyOrScenarioFilter);
		run(storiesPath);
	}

	public void runWithScenarioFilter(String storiesPath, String scenarioFilter) {
		run(storiesPath, StoryOrScenarioFilter.scenario(scenarioFilter));
	}

	public void runWithStoryFilter(String storiesPath, String storyFilter) {
		run(storiesPath, StoryOrScenarioFilter.story(storyFilter));
	}

	public BehaveContext addStories(String storiesPath) {
		log.debug("addStories:" + storiesPath);
		this.storiesPath.add(storiesPath);
		return this;
	}

	public BehaveContext addStoriesReuse(String storiesPath) {
		log.debug("addStoriesReuse:" + storiesPath);
		this.storiesReusePath.add(storiesPath);
		return this;
	}

	public String getCurrentScenario() {
		return this.currentScenario;
	}

	public void setCurrentScenario(String scenario) {
		this.currentScenario = scenario;
	}

	public void fail(String step, Throwable fail) {
		this.failStep = step;
		this.fail = fail;
	}

	public void clearAllOriginalStories() {
		allOriginalStoriesPath.clear();
	}

	// Seleciona o filtro para História OU Cenário
	public void setStoryOrScenarioFilter(StoryOrScenarioFilter filter) {
		this.storyOrScenarioFilter = filter;
	}

	public StoryOrScenarioFilter getStoryOrScenarioFilter() {
		return this.storyOrScenarioFilter;
	}

	// Métodos para tratamento de filtro nos Steps
	public void setStepsPackage(String name) {
		steps.addAll(StepsFilter.scanPackage(name, new Class[] {}));
	}

	public void setStepsPackage(String name, String excludes) {
		steps.addAll(StepsFilter.scanPackage(name, excludes));
	}

	@SuppressWarnings("rawtypes")
	public void setStepsPackage(String name, Class... excludes) {
		steps.addAll(StepsFilter.scanPackage(name, excludes));
	}

}
