package br.gov.frameworkdemoiselle.behave.internal.parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gov.frameworkdemoiselle.behave.util.RegularExpressionUtil;

public class ScenarioParameter {

	private static final String PARAMETER_PATTERN = "(\"([^\"]*)\")";

	/**
	 * Substitui os nome de parâmetro por parâmetros vazios, viabilizando a
	 * comparação entre a chamada e a definição de um cenário Ex: Cenário: logar
	 * como "{nome do usuario}" ... Cenário: fazer pedido ... logar como
	 * "claudio" ... A função irá substituir tanto 'logar como
	 * "{nome do usuário}"' quando 'logar como "claudio"' em 'logar como
	 * ("([^"]*)")'
	 * 
	 * @param scenarioIdentification
	 * @return
	 */
	public static String removeParameterNames(String scenarioIdentification) {
		return RegularExpressionUtil.replaceAll(PARAMETER_PATTERN, scenarioIdentification, PARAMETER_PATTERN);
	}

	/**
	 * Substitui os parâmetros formais pelos parâmetros reais Ex: Cenário: fazer
	 * pedido ... logar como "claudio" ... Cenário: logar como
	 * "{nome do usuario}" ... Dado que foi preenchido o nome com
	 * "{nome do usuario}" ... A função irá substituir tanto 'Dado que foi
	 * preenchido o nome com "{nome do usuario}"' quando 'Dado que foi
	 * preenchido o nome com "claudio"'
	 * 
	 * @param scenarioIdentification
	 * @return
	 */
	public static List<String> replaceCallParameters(String scenarioCall, Scenario scenarioReused) {
		Map<String, String> parametersCalled = getReusedParameters(scenarioReused.getIdentification(), scenarioCall);
		if (parametersCalled.isEmpty()) {
			return scenarioReused.getSentences();
		}
		List<String> newSentences = new ArrayList<String>();
		for (String sentence : scenarioReused.getSentences()) {
			for (String parameterCall : parametersCalled.keySet()) {
				newSentences.add(sentence.replace(parameterCall, parametersCalled.get(parameterCall)));
			}
		}
		return newSentences;
	}

	private static Map<String, String> getReusedParameters(String scenarioIdentification, String scenarioCall) {
		Map<String, String> parametersMap = new HashMap<String, String>();
		List<String> formalParameters = new ArrayList<String>();
		Pattern pattern = Pattern.compile(PARAMETER_PATTERN);
		Matcher matcher = pattern.matcher(scenarioIdentification);
		while (matcher.find()) {
			formalParameters.add(matcher.group(1));
		}
		List<String> realParameters = new ArrayList<String>();
		pattern = Pattern.compile(PARAMETER_PATTERN);
		matcher = pattern.matcher(scenarioCall);
		while (matcher.find()) {
			String lParametro = matcher.group(1);
			realParameters.add(lParametro);
		}
		for (int i = 0; i < formalParameters.size(); i++) {
			parametersMap.put(formalParameters.get(i), realParameters.get(i));
		}
		return parametersMap;
	}

}
