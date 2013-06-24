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
package br.gov.frameworkdemoiselle.behave.integration.alm;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URLEncoder;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.integration.Integration;
import br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorClient;
import br.gov.frameworkdemoiselle.behave.integration.alm.httpsclient.HttpsClient;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.util.GenerateXMLString;

public class ALMIntegration implements Integration {

	private static Logger log = Logger.getLogger(ALMIntegration.class);

	/**
	 * ERRO 400 - Posssivelmente o nome da área não esta correto
	 */

	public String urlServer = BehaveConfig.getIntegrationUrlServices();
	public String urlServerAuth = BehaveConfig.getIntegrationUrlSecurity();
	public String projectAreaAlias = BehaveConfig.getIntegrationProjectArea();
	private Boolean started = false;

	private String username;
	private String password;

	public final String ENCODING = "UTF-8";

	/**
	 * A integração presupõe que cada Cenário de cada história é um Caso de
	 * Teste na ALM
	 */
	public void sendScenario(Hashtable<String, Object> result) {

		try {
			// TODO Fazer verificação dos dados da hastable (name...)
			// TODO Verificar se as datas são do tipo Date
			// TODO Problema com encoding

			if (!started) {
				// Pega os dados de autenticação
				log.debug("Abrindo conexão com o autenticador");
				AutenticatorClient autenticator = new AutenticatorClient(9990, "localhost");
				autenticator.open();
				username = autenticator.getUser();
				password = autenticator.getPassword();
				autenticator.close();

				// Encode do Alias do Projeto
				projectAreaAlias = URLEncoder.encode(projectAreaAlias, ENCODING);

				started = true;
			}

			log.debug("------------- INICIOU O PROCESSO -------------");

			// --------------------------- TestCase

			// Conexão HTTPS
			HttpClient client = HttpsClient.getNewHttpClient(ENCODING);

			// Login
			login(client);

			// TestCase
			String testCaseIdentification = convertToIdentificationString(result.get("name").toString());
			String testCaseName = "testcase" + testCaseIdentification;
			HttpResponse responseTestCase = sendRequest(client, "testcase", testCaseName, GenerateXMLString.getTestcaseString(urlServer, projectAreaAlias, ENCODING, result.get("name").toString(), result.get("steps").toString()));
			if (responseTestCase.getStatusLine().getStatusCode() != 201 && responseTestCase.getStatusLine().getStatusCode() != 200) {
				throw new BehaveException("Erro ao criar caso de teste: " + responseTestCase.getStatusLine().toString());
			}

			// --------------------------- Work Item
			// Conexão HTTPS
			client = HttpsClient.getNewHttpClient(ENCODING);

			// Login
			login(client);

			// WorkItem
			String workItemName = "workitemExecucaoAutomatizada-" + testCaseName;
			HttpResponse responseWorkItem = sendRequest(client, "executionworkitem", workItemName, GenerateXMLString.getExecutionworkitemString(urlServer, projectAreaAlias, ENCODING, testCaseName, result.get("testPlanId").toString()));
			if (responseWorkItem.getStatusLine().getStatusCode() != 201 && responseWorkItem.getStatusLine().getStatusCode() != 200) {
				throw new BehaveException("Erro ao criar work item: " + responseWorkItem.getStatusLine().toString());
			}

			// --------------------------- Test Plan
			// Conexão HTTPS
			client = HttpsClient.getNewHttpClient(ENCODING);

			// Login
			login(client);

			// TestPlan
			String testPlanNameId = "urn:com.ibm.rqm:testplan:" + result.get("testPlanId").toString();
			HttpResponse responseTestPlan = sendRequest(client, "testplan", testPlanNameId, GenerateXMLString.getTestPlanString(urlServer, projectAreaAlias, ENCODING, testCaseName));
			if (responseTestPlan.getStatusLine().getStatusCode() != 200) {
				throw new BehaveException("Erro ao result: " + responseTestPlan.getStatusLine().toString());
			}

			// --------------------------- Result
			// Conexão HTTPS
			client = HttpsClient.getNewHttpClient(ENCODING);

			// Login
			login(client);

			// WorkItem
			String resultName = "result" + System.nanoTime();
			HttpResponse responseResult = sendRequest(client, "executionresult", resultName, GenerateXMLString.getExecutionresultString(urlServer, projectAreaAlias, ENCODING, workItemName, Boolean.parseBoolean(result.get("failed").toString()), (Date) result.get("startDate"), (Date) result.get("endDate")));
			if (responseResult.getStatusLine().getStatusCode() != 201) {
				throw new BehaveException("Erro ao result: " + responseResult.getStatusLine().toString());
			}

			log.debug("------------- FINALIZOU O PROCESSO -------------");

		} catch (RuntimeException e) {
			if (e.getCause() instanceof ConnectException) {
				throw new BehaveException("Autenticador inacessível. Verifique se o processo foi iniciado", e);
			} else {
				throw new BehaveException(e);
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}

	}

	public void login(HttpClient client) throws Exception {
		// Login
		HttpResponse responseLogin = login(client, username, password);
		if (responseLogin.getStatusLine().getStatusCode() != 302 || !responseLogin.toString().contains("LtpaToken2")) {
			throw new BehaveException("Erro na autenticação do usuário");
		}
	}

	public String convertToIdentificationString(String str) {
		String ret = Normalizer.normalize(str, Normalizer.Form.NFD).replace(" ", "").replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return ret;
	}

	public HttpResponse login(HttpClient client, String username, String password) throws ClientProtocolException, IOException {
		// Inicia o login
		HttpPost requestAuth = new HttpPost(urlServerAuth);

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("j_username", username));
		formparams.add(new BasicNameValuePair("j_password", password));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, ENCODING);
		requestAuth.setEntity(entity);

		// Faz o post e pega os cookies
		HttpResponse response = client.execute(requestAuth);

		return response;
	}

	public HttpResponse sendRequest(HttpClient client, String resource, String id, String xmlRequest) throws ClientProtocolException, IOException {
		String url = urlServer + "resources/" + projectAreaAlias + "/" + resource + "/" + id;

		log.debug(url);

		HttpPut request = new HttpPut(url);
		request.addHeader("Content-Type", "application/xml; charset=" + ENCODING);
		request.addHeader("Encoding", ENCODING);

		StringEntity se = new StringEntity(xmlRequest);
		se.setContentType("text/xml");
		se.setContentEncoding(ENCODING);
		request.setEntity(se);

		log.debug(xmlRequest);

		return client.execute(request);
	}

}
