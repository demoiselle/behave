package br.gov.frameworkdemoiselle.behave.internal.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.util.RegularExpressionUtil;

public class StoryConverter {

	private static final String LINE_BREAK_TOKEN = "\n";

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
		Map<String, String> convertedStories = new HashMap<String, String>();
		Map<String, String> storyDefinitions = extractStoryDefinitions(stories);
		Map<String, List<Scenario>> scenarios = extractScenarios(stories);
		reuseScenario(scenarios);
		convertedStories = scenariosToStories(storyDefinitions, scenarios);
		return convertedStories;
	}

	private static Map<String, List<Scenario>> extractScenarios(Map<String, String> stories) {
		Map<String, List<Scenario>> scenarios = new HashMap<String, List<Scenario>>();
		for (String storyPath : stories.keySet()) {
			scenarios.put(storyPath, extractScenarios(stories.get(storyPath)));
		}
		return scenarios;
	}

	private static Map<String, String> extractStoryDefinitions(Map<String, String> stories) {
		Map<String, String> storyDefinitions = new HashMap<String, String>();
		for (String storyPath : stories.keySet()) {
			storyDefinitions.put(storyPath, extractStoryDefinition(stories.get(storyPath)));
		}
		return storyDefinitions;
	}

	private static String extractStoryDefinition(String storyContent) {
		String[] scenarioTokens = storyContent.split(LINE_BREAK_TOKEN);
		String storyDefinition = "";
		for (int i = 0; i < scenarioTokens.length; i++) {
			String scenarioToken = scenarioTokens[i];
			if (RegularExpressionUtil.matches(BehaveConfig.IDENTIFICATION_SCENARIO_PATTERN, scenarioToken.trim())) {
				return storyDefinition;
			}
			storyDefinition += scenarioToken+LINE_BREAK_TOKEN;
		}
		return storyDefinition;
	}

	private static List<Scenario> extractScenarios(String storyContent) {
		List<Scenario> scenarios = new ArrayList<Scenario>();
		String[] scenarioTokens = storyContent.split(LINE_BREAK_TOKEN);
		Scenario scenario = null;
		for (int i = 0; i < scenarioTokens.length; i++) {
			String scenarioToken = scenarioTokens[i];
			if (RegularExpressionUtil.matches(BehaveConfig.IDENTIFICATION_SCENARIO_PATTERN, scenarioToken.trim())) {
				scenario = createScenario(scenarioToken);
				scenarios.add(scenario);
			} else if (scenario != null) {
				scenario.getSentences().add(scenarioToken);
			}
		}
		return scenarios;
	}

	private static Scenario createScenario(String scenarioToken) {
		String scenarioIdentification = RegularExpressionUtil.getGroup(BehaveConfig.IDENTIFICATION_SCENARIO_PATTERN, scenarioToken, 3).trim();
		String scenarioIdentificationWithoutParametersName = ScenarioParameter.removeParameterNames(scenarioIdentification.toUpperCase());
		Scenario scenario = new Scenario();
		scenario.setConverted(false);
		scenario.setDeclaration(scenarioToken);
		scenario.setIdentification(scenarioIdentification);
		scenario.setIdentificationWithoutParametersName(scenarioIdentificationWithoutParametersName);
		scenario.setSentences(new ArrayList<String>());
		return scenario;
	}

	private static Map<String, String> scenariosToStories(Map<String, String> storyDefinitions, Map<String, List<Scenario>> scenarios) {
		Map<String, String> stories = new HashMap<String, String>();
		for (String storyPath : scenarios.keySet()) {
			stories.put(storyPath, storyDefinitions.get(storyPath)+scenariosToText(scenarios.get(storyPath)));
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
			text += scenario.getDeclaration() + LINE_BREAK_TOKEN;
			for (String sentence : scenario.getSentences()) {
				if (sentence.trim().length() > 0)
					text += sentence + LINE_BREAK_TOKEN;
			}
		}
		return text;
	}

	private static void reuseScenario(Map<String, List<Scenario>> scenarios) {
		Map<String, Scenario> scenariosIdentificationMap = createScenariosIdentificationMap(scenarios);
		for (Entry<String, Scenario> entrySet : scenariosIdentificationMap.entrySet()) {
			reuseScenario(entrySet.getValue(), scenariosIdentificationMap);
		}
	}

	private static Map<String, Scenario> createScenariosIdentificationMap(Map<String, List<Scenario>> scenarios) {
		// Converte todos os cenários de todas as stories em um map
		// <Identificacao do cenário, cenário>
		Map<String, Scenario> scenariosIdentificationMap = new HashMap<String, Scenario>();
		for (Entry<String, List<Scenario>> entrySet : scenarios.entrySet()) {
			for (Scenario scenario : entrySet.getValue()) {
				scenariosIdentificationMap.put(scenario.getIdentificationWithoutParametersName(), scenario);
			}
		}
		return scenariosIdentificationMap;
	}

	private static void reuseScenario(Scenario scenario, Map<String, Scenario> scenariosIdentificationMap) {
		List<String> sentences = new ArrayList<String>();
		for (String sentence : scenario.getSentences()) {
			String sentenceWithoutPrefixAndParametersName = RegularExpressionUtil.getGroup(BehaveConfig.PREFIXES_BDD_PATTERN, sentence.trim(), 3);
			if(sentenceWithoutPrefixAndParametersName==null){
				sentenceWithoutPrefixAndParametersName = sentence;
			}
			sentenceWithoutPrefixAndParametersName = sentenceWithoutPrefixAndParametersName.trim();
			sentenceWithoutPrefixAndParametersName = ScenarioParameter.removeParameterNames(sentenceWithoutPrefixAndParametersName).toUpperCase();
			if (scenariosIdentificationMap.containsKey(sentenceWithoutPrefixAndParametersName)) {
				// A sentença é na verdade uma referência a outro cenário
				Scenario scenarioReused = scenariosIdentificationMap.get(sentenceWithoutPrefixAndParametersName);
				if (!scenarioReused.getConverted()) {
					// Foi utilizada recursão pois é possível que um cenário
					// chame outro cenário que chame outro cenário
					reuseScenario(scenarioReused, scenariosIdentificationMap);
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