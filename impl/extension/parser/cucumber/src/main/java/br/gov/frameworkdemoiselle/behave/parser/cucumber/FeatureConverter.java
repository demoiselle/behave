package br.gov.frameworkdemoiselle.behave.parser.cucumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FeatureConverter {

//	private static final String IDENTIFICATION_SCENARIO_PATTERN = "^(\\s)*(SCENARIO|Scenario|scenario):(.*)";
//	private static final String PREFIXES_BDD_PATTERN = "^(\\s)*(GIVEN|WHEN|THEN|AND|BUT|Given|When|Then|And|But|given|when|then|and|but)(.*)";
	private static final String LINE_BREAK_TOKEN = "\n";

	/*
	 * Definições: feature=arquivo com um ou mais cenários ; cenário=identificador+sentenças
	 * Algoritmo:
	 * 	Converter todas os cenários de todos as features (textos extraídos dos arquivos) para objetos do tipo Scenario (declaração, identificação e List de sentenças)
	 *  Varrer a lista de sentenças para ver quais correspondem à identificação de cenários (reuso de cenário)
	 *  	Para cada sentença identificada como chamando a um cenário, caso este não tenha sido convertido, deve ser convertido antes de ser reutilizado (cenário que reusa um cenário que reutiliza outro cenário)
	 *  	Os parâmetros formais devem ser substituídos pelos reais (da chamada) antes de serem reutilizados
	 *  Converter os objetos Scenario de volta para um texto correspondente ao arquivo convertido
	 */
	
	/**
	 * Gera features a partir de features originais, substituindo referências à features 
	 * pelo conteúdo das mesmas, além de realizar a adequada substituição dos parâmetros 
	 * @param pFeatures: Map com o path do arquivo e o conteúdo
	 * @return Map com o path do arquivo e o conteúdo convertido
	 * @throws IOException 
	 */
	public static Map<String,String> convertReusedScenarios(Map<String,String> features) throws IOException{
		Map<String,String> convertedFeatures = new HashMap<String,String>();
		Map<String, List<Scenario>> scenarios = extractScenarios(features);
		reuseScenario(scenarios);
		convertedFeatures = scenariosToFeatures(scenarios);
		return convertedFeatures;
	}

	private static Map<String, List<Scenario>> extractScenarios(Map<String, String> features) {
		Map<String, List<Scenario>> scenarios = new HashMap<String, List<Scenario>>();
		for(String featurePath : features.keySet()){
			scenarios.put(featurePath, extractScenarios(features.get(featurePath)));
		}
		return scenarios;
	}

	private static List<Scenario> extractScenarios(String featureContent) {
		List<Scenario> scenarios = new ArrayList<Scenario>();
		String[] scenarioTokens = featureContent.split(LINE_BREAK_TOKEN);
		Scenario scenario = null;
		for(int i=0; i<scenarioTokens.length; i++){
			String scenarioToken = scenarioTokens[i];
			if(RegularExpressionUtil.matches(CucumberConfig.IDENTIFICATION_SCENARIO_PATTERN, scenarioToken.trim())){
				scenario = createScenario(scenarioToken);
				scenarios.add(scenario);
			}else if(scenario!=null){
				scenario.getSentences().add(scenarioToken);
			}
		}
		return scenarios;
	}

	private static Scenario createScenario(String scenarioToken) {
		String scenarioIdentification = RegularExpressionUtil.getGroup(CucumberConfig.IDENTIFICATION_SCENARIO_PATTERN, scenarioToken, 3).trim();
		String scenarioIdentificationWithoutParametersName = ScenarioParameterUtil.removeParameterNames(scenarioIdentification.toUpperCase());
		Scenario scenario = new Scenario();
		scenario.setConverted(false);
		scenario.setDeclaration(scenarioToken);
		scenario.setIdentification(scenarioIdentification);
		scenario.setIdentificationWithoutParametersName(scenarioIdentificationWithoutParametersName);
		scenario.setSentences(new ArrayList<String>());
		return scenario;
	}
	
	private static Map<String, String> scenariosToFeatures(Map<String, List<Scenario>> scenarios) {
		Map<String, String> features = new HashMap<String, String>();
		for(String featurePath : scenarios.keySet()){
			features.put(featurePath, scenariosToText(scenarios.get(featurePath)));
		}
		return features;
	}

	private static String scenariosToText(List<Scenario> scenarios) {
		String text = "";
		for(Scenario scenario:scenarios){
			text += scenario.getDeclaration()+LINE_BREAK_TOKEN;
			for(String sentence:scenario.getSentences()){
				text += sentence+LINE_BREAK_TOKEN;
			}
		}
		return text;
	}

	private static void reuseScenario(Map<String, List<Scenario>> scenarios) {
		Map<String,Scenario> scenariosIdentificationMap = createScenariosIdentificationMap(scenarios);
		for(Entry<String, Scenario>  entrySet: scenariosIdentificationMap.entrySet()){
			reuseScenario(entrySet.getValue(), scenariosIdentificationMap);
		}
	}

	private static Map<String, Scenario> createScenariosIdentificationMap(Map<String, List<Scenario>> scenarios) {
		//Converte todos os cenários de todas as features em um map <Identificacao do cenário, cenário>
		Map<String,Scenario> scenariosIdentificationMap = new HashMap<String, Scenario>();
		for(Entry<String, List<Scenario>>  entrySet: scenarios.entrySet()){
			for(Scenario scenario : entrySet.getValue()){
				scenariosIdentificationMap.put(scenario.getIdentificationWithoutParametersName(), scenario);
			}
		}
		return scenariosIdentificationMap;
	}

	private static void reuseScenario(Scenario scenario, Map<String, Scenario> scenariosIdentificationMap){
		List<String> sentences = new ArrayList<String>();
		for(String sentence:scenario.getSentences()){
			String sentenceWithoutPrefixAndParametersName = RegularExpressionUtil.getGroup(CucumberConfig.PREFIXES_BDD_PATTERN, sentence.trim(), 3).trim();
			sentenceWithoutPrefixAndParametersName = ScenarioParameterUtil.removeParameterNames(sentenceWithoutPrefixAndParametersName).toUpperCase();
			if(scenariosIdentificationMap.containsKey(sentenceWithoutPrefixAndParametersName)){ 
				//A sentença é na verdade uma referência a outro cenário
				Scenario scenarioReused = scenariosIdentificationMap.get(sentenceWithoutPrefixAndParametersName);
				if(!scenarioReused.getConverted()){
					// Foi utilizada recursão pois é possível que um cenário chame outro cenário que chame outro cenário
					reuseScenario(scenarioReused, scenariosIdentificationMap); 
				}
				List<String> sentencesReplacedCallParameters = ScenarioParameterUtil.replaceCallParameters(sentence.trim(), scenarioReused);
				sentences.addAll(sentencesReplacedCallParameters);
			}else{
				sentences.add(sentence);
			}
		}
		scenario.setConverted(true);
		scenario.setSentences(sentences);
	}

}