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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
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

	private List<Step> steps = new ArrayList<Step>();

	private List<String> storiesPath = new ArrayList<String>();

	private String step;
	private Throwable fail;

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

	@SuppressWarnings("unchecked")
	public void run(List<String> storiesPath) {
		try {
			log.info("------------ZCLH FI--------------------");
			log.info(bm.getString("message-behave-start"));
			log.info("--------------------------------");

			BehaveConfig.logValueProperties();

			if (storiesPath == null || storiesPath.isEmpty()) {
				throw new BehaveException(bm.getString("exception-empty-story-list"));
			}
			// Armazena o array antigo para retirar as histórias depois
			List<String> oldsStories = StoryFileConverter.convertReusedScenarios((List<String>) allOriginalStoriesPath.clone(), BehaveConfig.getParser_OriginalStoryFileExtension(), BehaveConfig.getParser_ConvertedStoryFileExtension(), true);
			
			// Cria a lista de histórias para serem executadas (Somente para validação, não utilizar esta lista para no final Array)
			List<String> storiesConvertedAr = StoryFileConverter.convertReusedScenarios(storiesPath, BehaveConfig.getParser_OriginalStoryFileExtension(), BehaveConfig.getParser_ConvertedStoryFileExtension(), true);
			
			// Adiciono as novas histórias no array com TODAS, inclusive as da execução anterior
			allOriginalStoriesPath.addAll(storiesPath);

			// Faz a conversão
			List<String> allStoriesConverted = StoryFileConverter.convertReusedScenarios(allOriginalStoriesPath, BehaveConfig.getParser_OriginalStoryFileExtension(), BehaveConfig.getParser_ConvertedStoryFileExtension(), true);

			// Cria um novo array contendo somente as histórias atuais, sem as  antigas
			// Correção de bug: Quando a história é explicitamente enviada novamente ao run ela tem que rodar
			List<String> finalArray = new ArrayList<String>();
			for (String storyFile : allStoriesConverted) {
				if (!oldsStories.contains(storyFile) || storiesConvertedAr.contains(storyFile)) {
					finalArray.add(storyFile);
				}
			}
			
			// Roda o runner com as histórias convertidas
			parser = (Parser) InjectionManager.getInstance().getInstanceDependecy(Parser.class);
			parser.setSteps(steps);
			parser.setStoryPaths(finalArray);
			parser.run();
			if (fail != null) {
				Assert.fail(bm.getString("exception-fail-step", step, fail.getMessage()));
			}
		} catch (BehaveException ex) {
			log.error(bm.getString("exception-general"), ex);
			throw ex;
		} finally {
			fail = null;
			storiesPath.clear();
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
		this.fail = null;
		this.step = null;
	}

	public BehaveContext addStories(String storiesPath) {
		log.debug("addStories:" + storiesPath);
		this.storiesPath.add(storiesPath);
		return this;
	}

	public void fail(String step, Throwable fail) {
		this.step = step;
		this.fail = fail;
	}
}
