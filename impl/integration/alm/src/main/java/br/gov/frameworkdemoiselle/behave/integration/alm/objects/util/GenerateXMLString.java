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
package br.gov.frameworkdemoiselle.behave.integration.alm.objects.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.integration.ScenarioState;

import com.ibm.rqm.xml.bind.Details;
import com.ibm.rqm.xml.bind.Executionresult;
import com.ibm.rqm.xml.bind.Executionworkitem;
import com.ibm.rqm.xml.bind.Richtext;
import com.ibm.rqm.xml.bind.State;
import com.ibm.rqm.xml.bind.Testcase;
import com.ibm.rqm.xml.bind.Testplan;

public class GenerateXMLString {

	// private static Logger log = Logger.getLogger(GenerateXMLString.class);

	public static String getTestplanString(String urlServer, String projectAreaAlias, String encoding, String testCaseId, Testplan currentPlan) throws JAXBException {

		// Adiciona o novo test case se não existir
		boolean exists = false;
		String newTestCaseId = urlServer + "resources/" + projectAreaAlias + "/testcase/" + testCaseId;

		if (currentPlan.getTestcase() != null) {
			for (com.ibm.rqm.xml.bind.Testplan.Testcase link : currentPlan.getTestcase()) {
				if (link.getHref().equals(newTestCaseId)) {
					exists = true;
					break;
				}
			}
		}

		if (!exists) {
			com.ibm.rqm.xml.bind.Testplan.Testcase testcase = new com.ibm.rqm.xml.bind.Testplan.Testcase();
			testcase.setHref(newTestCaseId);
			currentPlan.getTestcase().add(testcase);
		}

		JAXBContext jaxb = JAXBContext.newInstance(Testplan.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		StringWriter testPlanString = new StringWriter();
		marshaller.marshal(currentPlan, testPlanString);

		return testPlanString.toString();
	}

	public static String getTestcaseString(String urlServer, String projectAreaAlias, String encoding, String name, String steps, Testcase currentTestCase) throws JAXBException {

		Richtext textDesgin = new Richtext();
		textDesgin.getContent().add(escapeHTMLForAlm(steps));

		currentTestCase.setTitle(name);
		currentTestCase.setSuspect(false);
		currentTestCase.setWeight(100);
		currentTestCase.setComIbmRqmPlanningEditorSectionTestCaseDesign(textDesgin);

		// Valor da Categoria
		String categoryTipoExecucao = BehaveConfig.getIntegration_CategoryTipoExecucao();

		// Verifica se no caso de teste vindo da ALM existe a categoria
		// "Tipo de Execução", se não existe cria.
		boolean objExists = false;
		for (Testcase.Category c : currentTestCase.getCategory()) {
			if (c.getTerm().toLowerCase().trim().equals("tipo de execução")) {
				objExists = true;
				// Altera para "Automática"
				c.setValue(categoryTipoExecucao);
				break;
			}
		}

		if (!objExists) {
			Testcase.Category newC = new Testcase.Category();
			newC.setTerm("Tipo de Execução");
			newC.setValue(categoryTipoExecucao);
			currentTestCase.getCategory().add(newC);
		}

		JAXBContext jaxb = JAXBContext.newInstance(Testcase.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		StringWriter testCaseString = new StringWriter();
		marshaller.marshal(currentTestCase, testCaseString);

		return testCaseString.toString();
	}

	public static Testcase getTestcaseObject(HttpResponse response) throws IOException, JAXBException {

		Testcase testcase = null;
		StringBuffer xmlString = new StringBuffer();
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
				String line = "";
				while ((line = reader.readLine()) != null) {
					xmlString.append(line);
				}
			} finally {
				instream.close();
			}
		}

		if (!xmlString.equals("")) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Testcase.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlString.toString());
			testcase = (Testcase) unmarshaller.unmarshal(reader);
		}

		return testcase;

	}

	public static String getExecutionworkitemString(String urlServer, String projectAreaAlias, String encoding, String testCaseId, String testPlanId) throws JAXBException {

		// Workitem
		com.ibm.rqm.xml.bind.Executionworkitem.Testcase workTest = new com.ibm.rqm.xml.bind.Executionworkitem.Testcase();
		workTest.setHref(urlServer + "resources/" + projectAreaAlias + "/testcase/" + testCaseId);

		// Testplan
		com.ibm.rqm.xml.bind.Executionworkitem.Testplan testPlan = new com.ibm.rqm.xml.bind.Executionworkitem.Testplan();
		testPlan.setHref(urlServer + "resources/" + projectAreaAlias + "/testplan/urn:com.ibm.rqm:testplan:" + testPlanId);

		// Criação do Execution Work Item
		Executionworkitem work = new Executionworkitem();
		work.setFrequency("Once");
		work.setRegression(false);
		work.setTitle("Registro de Execução Automatizado - Plano de Teste " + testPlanId);
		work.setWeight(100);
		work.setTestcase(workTest);
		work.setTestplan(testPlan);

		JAXBContext jaxb = JAXBContext.newInstance(Executionworkitem.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		StringWriter resourceString = new StringWriter();
		marshaller.marshal(work, resourceString);

		return resourceString.toString();
	}

	public static String getExecutionresultString(String urlServer, String projectAreaAlias, String encoding, String executionWorkItemUrl, ScenarioState stateOf, Date _startDate, Date _endDate, String details) throws JAXBException, DatatypeConfigurationException {

		Date startDate = (Date) _startDate.clone();
		Date endDate = (Date) _endDate.clone();

		com.ibm.rqm.xml.bind.Executionresult.Executionworkitem workTest = new com.ibm.rqm.xml.bind.Executionresult.Executionworkitem();
		workTest.setHref(executionWorkItemUrl);

		State state = new State();
		Executionresult result = new Executionresult();
		if (stateOf.equals(ScenarioState.FAILED)) {
			state.setContent("com.ibm.rqm.execution.common.state.failed");
		} else {
			if (stateOf.equals(ScenarioState.PENDING)) {
				state.setContent("com.ibm.rqm.execution.common.state.blocked");
			} else {
				state.setContent("com.ibm.rqm.execution.common.state.passed");
			}
		}

		result.setState(state);
		result.setExecutionworkitem(workTest);

		// Datas de início e fim do teste
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(startDate);
		XMLGregorianCalendar startDateXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		result.setStarttime(startDateXml);

		c.setTime(endDate);
		XMLGregorianCalendar endDateXml = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		result.setEndtime(endDateXml);

		// Details
		Details d = new Details();
		d.getContent().add(details);
		result.setDetails(d);

		JAXBContext jaxb = JAXBContext.newInstance(Executionresult.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
		StringWriter resourceString = new StringWriter();
		marshaller.marshal(result, resourceString);

		return resourceString.toString();
	}

	public static Testplan getTestPlanObject(HttpResponse response) throws IOException, JAXBException {

		Testplan plan = null;
		StringBuffer xmlString = new StringBuffer();
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
				String line = "";
				while ((line = reader.readLine()) != null) {
					xmlString.append(line);
				}
			} finally {
				instream.close();
			}
		}

		if (!xmlString.equals("")) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Testplan.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlString.toString());
			plan = (Testplan) unmarshaller.unmarshal(reader);
		}

		return plan;

	}

	/**
	 * Trata todas as tags para serem enviadas para a ALM, exceto a quebra de
	 * linha <br/>
	 * 
	 * @param s
	 *            string a ser tratada
	 * @return string tatada
	 */
	public static String escapeHTMLForAlm(String s) {

		// Substitui as quebras de linha para não serem tratadas
		s = s.replace("<br/>", "\n");

		StringBuilder out = new StringBuilder(Math.max(16, s.length()));
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
				out.append("&#");
				out.append((int) c);
				out.append(';');
			} else {
				out.append(c);
			}
		}

		// Volta as quebras de linha
		String stringRet = out.toString().replace("\n", "<br/>");

		return stringRet;
	}

}
