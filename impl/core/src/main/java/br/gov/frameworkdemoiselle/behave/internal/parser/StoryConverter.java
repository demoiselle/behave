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
package br.gov.frameworkdemoiselle.behave.internal.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.filter.ScenarioFilter;
import br.gov.frameworkdemoiselle.behave.internal.filter.StoryOrScenarioFilter;
import br.gov.frameworkdemoiselle.behave.internal.filter.StoryFilter;
import br.gov.frameworkdemoiselle.behave.internal.util.RegularExpressionUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 * 
 */
public class StoryConverter {

	private static final String LINE_BREAK_TOKEN = "\n";

	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	/*
	 * Definições: story=arquivo com um ou mais cenários ;
	 * cenário=identificador+sentenças Algoritmo: Converter todas os cenários de
	 * todos as stories (textos extraídos dos arquivos) para objetos do tipo
	 * Scenario (declaração, identificação e List de sentenças) Varrer a lista
	 * de sentenças para ver quais correspondem à identificação de cenários
	 * (reuso de cenário) Para cada sentença identificada como chamando a um
	 * cenário, caso este não tenha sido convertido, deve ser convertido antes
	 * de ser reutilizado (cenário que reusa um cenário que reutiliza outro
	 * cenário) Os parâmetros formais devem ser substituídos pelos reais (da
	 * chamada) antes de serem reutilizados Converter os objetos Scenario de
	 * volta para um texto correspondente ao arquivo convertido
	 */

	/**
	 * Gera stories a partir de stories originais, substituindo referências à
	 * stories pelo conteúdo das mesmas, além de realizar a adequada
	 * substituição dos parâmetros
	 * 
	 * @param pStories
	 *            : Map com o path do arquivo e o conteúdo
	 * @return Map com o path do arquivo e o conteúdo convertido
	 * @throws IOException
	 */
	public static Map<String, String> convertReusedScenarios(Map<String, String> stories) throws IOException {
		Map<String, String> convertedStories = new LinkedHashMap<String, String>();

		// Pega as definições das histórias (tudo que vem antes do primeiro
		// cenário)
		Map<String, String> storyDefinitions = extractStoryDefinitions(stories);

		// Cria uma lista contendo o identificador da história e uma lista com
		// todos os cenários
		Map<String, List<Scenario>> scenarios = extractScenarios(stories);

		// Faz a reutilização dos cenários
		reuseScenario(scenarios);

		// Evita que os cenários reutilizáveis sejam executados, mesmo que nenhum cenário concreto tenha sido encontrado.
		for(String key : scenarios.keySet()){
			List<Scenario> actual = scenarios.get(key);
			List<Scenario> toRemove = new ArrayList<Scenario>();
			for(Scenario cenario : actual){
				if(cenario.getReusable()){
					toRemove.add(cenario);
				}
			}
			actual.removeAll(toRemove);
		}

		// Converte os objetos dos cenários (com reuso) em histórias novamente
		convertedStories = scenariosToStories(storyDefinitions, scenarios);

		return convertedStories;
	}

	private static Map<String, List<Scenario>> extractScenarios(Map<String, String> stories) {
		Map<String, List<Scenario>> scenarios = new LinkedHashMap<String, List<Scenario>>();
		for (String storyPath : stories.keySet()) {
			scenarios.put(storyPath, extractScenarios(stories.get(storyPath)));
		}

		// Verifica assinatura
		verifyDuplicateScenarios(scenarios);

		return scenarios;
	}

	/**
	 * Verifica se existe algum cenário com a assinatura identica, se tiver para
	 * o teste, não pode existir por causa do reuso que
	 * 
	 * @param scenariosMap
	 */
	private static void verifyDuplicateScenarios(Map<String, List<Scenario>> scenariosMap) {
		ArrayList<String> scenariosSignature = new ArrayList<String>();
		for (String story : scenariosMap.keySet()) {
			List<Scenario> scenarios = scenariosMap.get(story);
			for (Scenario scenario : scenarios) {
				if (!scenariosSignature.contains(scenario.getIdentificationWithoutParametersName())) {
					scenariosSignature.add(scenario.getIdentificationWithoutParametersName());
				} else {
					throw new BehaveException(bm.getString("exception-scenario-duplicated", scenario.getIdentification()));
				}
			}
		}
	}

	/**
	 * 
	 * @param stories
	 *            Todas as histórias que serão utilizadas
	 * @return retorna um mapa contendo o arquivo e a
	 */
	private static Map<String, String> extractStoryDefinitions(Map<String, String> stories) {
		Map<String, String> storyDefinitions = new LinkedHashMap<String, String>();
		for (String storyPath : stories.keySet()) {
			storyDefinitions.put(storyPath, extractStoryDefinition(stories.get(storyPath)));
		}
		return storyDefinitions;
	}

	/**
	 * Retira o "Como um: / Eu quero: / De modo que: /" da história
	 * 
	 * @param storyContent
	 * @return retorna somente o conteúdo "Como um..."
	 */
	private static String extractStoryDefinition(String storyContent) {
		String[] scenarioTokens = storyContent.split(LINE_BREAK_TOKEN);
		String storyDefinition = "";
		for (int i = 0; i < scenarioTokens.length; i++) {
			String scenarioToken = scenarioTokens[i];
			if (RegularExpressionUtil.matches(BehaveConfig.getParser_IdentificationScenarioPattern(), scenarioToken.trim())) {
				return storyDefinition;
			}
			
			// Remove os comentários da história
			String st = removeComment(scenarioToken);
						
			storyDefinition += st.equals("") ? "" : st + LINE_BREAK_TOKEN;
		}
		return storyDefinition;
	}

	/**
	 * Método que retira os comentários da história
	 * 
	 * @param scenarioToken 
	 * @return
	 */
	private static String removeComment(String scenarioToken) {
		return !Pattern.compile("^(!--)(.*)").matcher(scenarioToken).find() ? (scenarioToken) : "";
	}

	private static List<Scenario> extractScenarios(String storyContent) {
		List<Scenario> scenarios = new ArrayList<Scenario>();
		String[] scenarioTokens = storyContent.split(LINE_BREAK_TOKEN);
		Scenario scenario = null;
		for (int i = 0; i < scenarioTokens.length; i++) {
			String scenarioToken = scenarioTokens[i];
			if (RegularExpressionUtil.matches(BehaveConfig.getParser_IdentificationScenarioPattern(), scenarioToken.trim())) {
				scenario = createScenario(scenarioToken);
				if (scenario.getReusable()) {
					scenarios.add(scenario);
				} else {
					// Verifica se existe algum filtro informado
					if (hasFilter(ScenarioFilter.class)) {
						if (matchesStoryOrScenario(scenario.getIdentification())) {
							scenarios.add(scenario);
						}
					} else {
						scenarios.add(scenario);
					}
				}
			} else {
				if (scenario != null) {
					scenario.getSentences().add(scenarioToken);
				}
			}
		}
		return scenarios;
	}

	/**
	 * Verifica se existe algum filtro do tipo ScenarioFilter ou StoryFilter
	 * 
	 * @param c
	 *            ScenarioFilter.class ou StoryFilter.class
	 * @return true ou false, se existe ou não existe
	 */
	private static boolean hasFilter(Class<?> c) {
		StoryOrScenarioFilter filter = BehaveContext.getInstance().getStoryOrScenarioFilter();
		return filter != null && filter.getClass().getName().equals(c.getName());
	}

	/**
	 * Verifica se o nome do cenário ou história é válido segundo a expressão
	 * regular informada no Filter (ScenarioFilter ou StoryFilter)
	 * 
	 * @param value nome do cenário ou história
	 * @return true ou false, se é valido ou não segundo a expressão regular do filtro
	 */
	private static boolean matchesStoryOrScenario(String value) {
		String filter = BehaveContext.getInstance().getStoryOrScenarioFilter().getValue();
		boolean result = Pattern.compile(filter).matcher(value).find();
		return result;
	}

	private static Scenario createScenario(String scenarioToken) {
		String scenarioIdentification = RegularExpressionUtil.getGroup(BehaveConfig.getParser_IdentificationScenarioPattern(), scenarioToken, 3).trim();
		String scenarioIdentificationWithoutParametersName = ScenarioParameter.removeParameterNames(scenarioIdentification.toUpperCase());
		Scenario scenario = new Scenario();
		scenario.setConverted(false);
		scenario.setDeclaration(scenarioToken);
		scenario.setIdentification(scenarioIdentification);
		scenario.setIdentificationWithoutParametersName(scenarioIdentificationWithoutParametersName);
		scenario.setSentences(new ArrayList<String>());

		// Se a identificação do cenário com e sem parâmetros não for igual ele
		// é um cenário que tem parâmetros, e por tanto é reutilizável
		if (!scenario.getIdentification().toLowerCase().equals(scenario.getIdentificationWithoutParametersName().toLowerCase())) {
			scenario.setReusable(true);
		}

		return scenario;
	}

	private static Map<String, String> scenariosToStories(Map<String, String> storyDefinitions, Map<String, List<Scenario>> scenarios) {
		Map<String, String> stories = new LinkedHashMap<String, String>();
		for (String storyPath : scenarios.keySet()) {
			String sd = storyDefinitions.get(storyPath);
			if (hasFilter(StoryFilter.class) || hasFilter(ScenarioFilter.class)) {
				if (hasFilter(StoryFilter.class) && matchesStoryOrScenario(sd)) {
					stories.put(storyPath, sd + scenariosToText(scenarios.get(storyPath)));
				}
				if (hasFilter(ScenarioFilter.class) && scenarios.get(storyPath).size() > 0) {
					stories.put(storyPath, sd + scenariosToText(scenarios.get(storyPath)));
				}
			} else {
				stories.put(storyPath, sd + scenariosToText(scenarios.get(storyPath)));
			}
		}
		return stories;
	}

	/**
	 * Gera o arquivo processado com as quebras de linhas
	 * 
	 * @param scenarios
	 * @return
	 */
	private static String scenariosToText(List<Scenario> scenarios) {
		String text = "";
		for (Scenario scenario : scenarios) {
			if (!scenario.getReusable()) {
				if (text.length() > 0) {
					text += LINE_BREAK_TOKEN;
				}
				text += scenario.getDeclaration().replaceAll("\t", "") + LINE_BREAK_TOKEN;
				for (String sentence : scenario.getSentences()) {
					String s = removeComment(sentence);
					if (s.trim().length() > 0)
						text += s.replaceAll("\t", "") + LINE_BREAK_TOKEN;
				}
			}
		}
		return text;
	}

	private static void reuseScenario(Map<String, List<Scenario>> scenarios) {
		Map<String, Scenario> scenariosIdentificationMap = createScenariosIdentificationMap(scenarios);
		for (Entry<String, Scenario> entrySet : scenariosIdentificationMap.entrySet()) {
			reuseScenarioSentences(entrySet.getValue(), entrySet.getValue(), scenariosIdentificationMap);
		}
	}

	private static Map<String, Scenario> createScenariosIdentificationMap(Map<String, List<Scenario>> scenarios) {
		// Converte todos os cenários de todas as stories em um map
		// <Identificacao do cenário, cenário>
		Map<String, Scenario> scenariosIdentificationMap = new LinkedHashMap<String, Scenario>();
		for (Entry<String, List<Scenario>> entrySet : scenarios.entrySet()) {
			for (Scenario scenario : entrySet.getValue()) {
				scenariosIdentificationMap.put(scenario.getIdentificationWithoutParametersName(), scenario);
			}
		}
		return scenariosIdentificationMap;
	}

	/**
	 * @param topScenario
	 *            : utilizado para o tratamento de loop infinito no reuso de
	 *            histórias
	 * @param scenario
	 * @param scenariosIdentificationMap
	 */
	private static void reuseScenarioSentences(Scenario topScenario, Scenario scenario, Map<String, Scenario> scenariosIdentificationMap) {
		List<String> sentences = new ArrayList<String>();
		for (String sentence : scenario.getSentences()) {
			// Removida a condição que impedia o reuso de passos negócio dentro
			// de passos de negócio
			String sentenceWithoutPrefixAndParametersName = RegularExpressionUtil.getGroup(BehaveConfig.getParser_PrefixesBddPattern(), sentence.trim(), 3);
			if (sentenceWithoutPrefixAndParametersName == null) {
				sentenceWithoutPrefixAndParametersName = sentence;
			}
			sentenceWithoutPrefixAndParametersName = sentenceWithoutPrefixAndParametersName.trim();
			sentenceWithoutPrefixAndParametersName = ScenarioParameter.removeParameterNames(sentenceWithoutPrefixAndParametersName).toUpperCase();

			// Tratamento para loop infinito no reuso de histórias
			if (sentenceWithoutPrefixAndParametersName.equals(topScenario.getIdentificationWithoutParametersName())) {
				throw new BehaveException(bm.getString("exception-scenario-cyclic-reference", topScenario.getIdentification()));
			}

			if (scenariosIdentificationMap.containsKey(sentenceWithoutPrefixAndParametersName)) {
				// A sentença é na verdade uma referência a outro cenário
				Scenario scenarioReused = scenariosIdentificationMap.get(sentenceWithoutPrefixAndParametersName);
				if (!scenarioReused.getConverted()) {
					// Foi utilizada recursão pois é possível que um cenário
					// chame outro cenário que chame outro cenário
					reuseScenarioSentences(topScenario, scenarioReused, scenariosIdentificationMap);
				}
				List<String> sentencesReplacedCallParameters = ScenarioParameter.replaceCallParameters(sentence.trim(), scenarioReused);
				sentences.addAll(sentencesReplacedCallParameters);
			} else {
				sentences.add(sentence);
			}
		}
		scenario.setConverted(true);
		scenario.setSentences(sentences);
	}

}