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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.util.RegularExpressionUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 *
 */
public class ScenarioParameter {

	private static final String PARAMETER_PATTERN = "(\"([^\"]*)\")";

	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

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
		if (scenarioReused.getIdentification() == null) {
			throw new BehaveException(bm.getString("exception-scenario-null"));
		}
		Map<String, String> parametersCalled = getReusedParameters(scenarioReused.getIdentification(), scenarioCall);
		if (parametersCalled.isEmpty()) {
			return scenarioReused.getSentences();
		}
		List<String> newSentences = new ArrayList<String>();
		for (String sentence : scenarioReused.getSentences()) {
			for (String parameterCall : parametersCalled.keySet()) {
				sentence = sentence.replace(parameterCall, parametersCalled.get(parameterCall));
			}
			newSentences.add(sentence);
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
			parametersMap.put(formalParameters.get(i).replaceAll("\"", ""), realParameters.get(i).replaceAll("\"", ""));
		}
		return parametersMap;
	}

}
