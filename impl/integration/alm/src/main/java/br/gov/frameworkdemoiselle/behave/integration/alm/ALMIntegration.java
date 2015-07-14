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
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.integration.Integration;
import br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorClient;
import br.gov.frameworkdemoiselle.behave.integration.alm.httpsclient.HttpsClient;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.util.GenerateXMLString;
import br.gov.frameworkdemoiselle.behave.internal.integration.ScenarioState;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

import com.ibm.rqm.xml.bind.Testcase;
import com.ibm.rqm.xml.bind.Testplan;

@SuppressWarnings("deprecation")
public class ALMIntegration implements Integration {

	private static Logger log = Logger.getLogger(ALMIntegration.class);

	public static String MESSAGEBUNDLE = "demoiselle-integration-alm-bundle";

	private BehaveMessage message = new BehaveMessage(MESSAGEBUNDLE);

	public String urlServer;
	public String urlServerAuth;
	public String projectAreaAlias;
	private Integer testCaseId;

	private String username;
	private String password;

	public final String ENCODING = "UTF-8";

	/**
	 * A integração presupõe que cada Cenário de cada história é um Caso de
	 * Teste na ALM
	 */
	public void sendScenario(Hashtable<String, Object> result) {

		try {
			// Tenta obter dados de autenticacao vindo do Hashtable
			if (result.containsKey("user") && result.containsKey("password")) {
				username = (String) result.get("user");
				password = (String) result.get("password");
			} else {
				// Pega os dados de autenticação
				log.debug(message.getString("message-get-authenticator"));
				AutenticatorClient autenticator = new AutenticatorClient(BehaveConfig.getIntegration_AuthenticatorPort(), BehaveConfig.getIntegration_AuthenticatorHost());
				autenticator.open();
				username = autenticator.getUser();
				password = autenticator.getPassword();
				autenticator.close();
			}

			// Tenta obter dados de conexao com o ALM via hash
			urlServer = getHash(result, "urlServer", BehaveConfig.getIntegration_UrlServices()).trim();
			urlServerAuth = getHash(result, "urlServerAuth", BehaveConfig.getIntegration_UrlSecurity()).trim();
			projectAreaAlias = getHash(result, "projectAreaAlias", BehaveConfig.getIntegration_ProjectArea()).trim();

			// Para evitar problemas com encodings em projetos nós sempre
			// fazemos o decoding e depois encoding
			projectAreaAlias = URLDecoder.decode(projectAreaAlias, ENCODING);

			// Encode do Alias do Projeto
			projectAreaAlias = URLEncoder.encode(projectAreaAlias, ENCODING);

			// ID fixo de caso de teste
			boolean testCaseIdMeta = false;
			if (result.containsKey("testCaseId")) {
				testCaseId = Integer.parseInt((String) result.get("testCaseId"));
				testCaseIdMeta = true;
			} else {
				testCaseId = null;
			}

			log.debug(message.getString("message-integration-alm-started"));
			long t0 = GregorianCalendar.getInstance().getTimeInMillis();

			HttpClient client;
			String testCaseName;

			// Somente cria e associa o caso de teste quando ele não é informado
			if (testCaseId == null) {
				String testCaseIdentification = convertToIdentificationString(result.get("name").toString());
				testCaseName = "testcase" + testCaseIdentification;

				// --------------------------- TestCase (GET)
				// Conexão HTTPS
				client = HttpsClient.getNewHttpClient(ENCODING);
				// Login
				login(client);

				// Cria um novo caso de teste
				Testcase testCase = new Testcase();

				HttpResponse responseTestCaseGet = getRequest(client, "testcase", testCaseName);
				if (responseTestCaseGet.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					testCase = GenerateXMLString.getTestcaseObject(responseTestCaseGet);
				}

				// --------------------------- TestCase (PUT)
				// Conexão HTTPS
				client = HttpsClient.getNewHttpClient(ENCODING);
				// Login
				login(client);

				// TestCase
				log.debug(message.getString("message-send-test-case"));
				HttpResponse responseTestCase = sendRequest(client, "testcase", testCaseName, GenerateXMLString.getTestcaseString(urlServer, projectAreaAlias, ENCODING, result.get("name").toString(), result.get("steps").toString(), testCase));
				if (responseTestCase.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED && responseTestCase.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					throw new BehaveException(message.getString("exception-create-test-case", responseTestCase.getStatusLine().toString()));
				}
			} else {
				testCaseName = "urn:com.ibm.rqm:testcase:" + testCaseId;
			}

			// Verifica se a auto associação esta habilitada
			if (BehaveConfig.getIntegration_AutoAssociateTestCaseInPlan()) {
				// --------------------------- Test Plan (GET)
				// Conexão HTTPS
				client = HttpsClient.getNewHttpClient(ENCODING);
				// Login
				login(client);

				Testplan plan;

				String testPlanNameId = "urn:com.ibm.rqm:testplan:" + result.get("testPlanId").toString();
				HttpResponse responseTestPlanGet = getRequest(client, "testplan", testPlanNameId);
				if (responseTestPlanGet.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED && responseTestPlanGet.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					throw new BehaveException(message.getString("exception-test-plan-not-found", result.get("testPlanId").toString(), projectAreaAlias));
				} else {
					plan = GenerateXMLString.getTestPlanObject(responseTestPlanGet);
				}

				// --------------------------- Test Plan (PUT)
				// Conexão HTTPS
				client = HttpsClient.getNewHttpClient(ENCODING);
				// Login
				login(client);

				// TestPlan
				log.debug(message.getString("message-send-test-plan"));
				HttpResponse responseTestPlan = sendRequest(client, "testplan", testPlanNameId, GenerateXMLString.getTestplanString(urlServer, projectAreaAlias, ENCODING, testCaseName, plan));
				if (responseTestPlan.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					throw new BehaveException(message.getString("exception-send-test-plan", responseTestPlan.getStatusLine().toString()));
				}
			}

			// --------------------------- Work Item (PUT)
			// Conexão HTTPS
			client = HttpsClient.getNewHttpClient(ENCODING);
			// Login
			login(client);

			// WorkItem
			log.debug(message.getString("message-send-execution"));
			String workItemName = "workitemExecucaoAutomatizada-" + convertToIdentificationString(testCaseName) + "-" + result.get("testPlanId").toString();
			boolean redirect = false;
			HttpResponse responseWorkItem = sendRequest(client, "executionworkitem", workItemName, GenerateXMLString.getExecutionworkitemString(urlServer, projectAreaAlias, ENCODING, testCaseName, result.get("testPlanId").toString()));
			if (responseWorkItem.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED && responseWorkItem.getStatusLine().getStatusCode() != HttpStatus.SC_OK && responseWorkItem.getStatusLine().getStatusCode() != HttpStatus.SC_SEE_OTHER) {
				String ms = message.getString("exception-create-execution", responseWorkItem.getStatusLine().toString());
				if (testCaseIdMeta) {
					ms = message.getString("exception-verity-execution", testCaseId.toString(), message);
				}
				throw new BehaveException(ms);
			} else {
				Header locationHeader = responseWorkItem.getFirstHeader("Content-Location");
				if (locationHeader != null) {
					redirect = true;
					workItemName = locationHeader.getValue();
				}
			}

			// --------------------------- Result (PUT)
			// Conexão HTTPS
			client = HttpsClient.getNewHttpClient(ENCODING);
			// Login
			login(client);

			// WorkItem
			log.debug(message.getString("message-send-result"));
			String resultName = "result" + System.nanoTime();

			// Tratamento da identificação do workitem
			String executionWorkItemUrl = urlServer + "resources/" + projectAreaAlias + "/executionworkitem/" + workItemName;
			if (redirect) {
				executionWorkItemUrl = workItemName;
			}

			HttpResponse responseResult = sendRequest(client, "executionresult", resultName, GenerateXMLString.getExecutionresultString(urlServer, projectAreaAlias, ENCODING, executionWorkItemUrl, ((ScenarioState) result.get("state")), (Date) result.get("startDate"), (Date) result.get("endDate"), (String) result.get("details")));
			if (responseResult.getStatusLine().getStatusCode() != HttpStatus.SC_CREATED) {
				throw new BehaveException(message.getString("exception-send-result", responseResult.getStatusLine().toString()));
			}

			long t1 = GregorianCalendar.getInstance().getTimeInMillis();

			DecimalFormat df = new DecimalFormat("0.0");
			log.debug(message.getString("message-integration-alm-end", df.format((t1 - t0) / 1000.00)));

		} catch (RuntimeException e) {
			if (e.getCause() instanceof ConnectException) {
				throw new BehaveException(message.getString("exception-authenticator-inaccessible"), e);
			} else {
				throw new BehaveException(e);
			}
		} catch (Exception e) {

			throw new BehaveException(e);
		}

	}

	/**
	 * Obteem o valor do hash ou retorna um valor padrão
	 * 
	 * @param result
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	private String getHash(Hashtable<String, Object> result, String key, String defaultValue) {
		if (result.containsKey(key)) {
			return (String) result.get(key);
		} else {
			return defaultValue;
		}
	}

	public void login(HttpClient client) throws Exception {
		log.debug(message.getString("message-user-authentication", username));
		HttpResponse responseLogin = login(client, username, password);
		if (responseLogin.getStatusLine().getStatusCode() != 302 || !responseLogin.toString().contains("LtpaToken2")) {
			throw new BehaveException(message.getString("exception-user-authentication"));
		}
	}

	public String convertToIdentificationString(String str) {
		String ret = Normalizer.normalize(str, Normalizer.Form.NFD).replace(" ", "").replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		ret = ret.replaceAll("[-]", "").replaceAll("[:]", "").replaceAll("[.]", "").replaceAll("[#]", "");
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

		HttpParams params = request.getParams();
		params.setParameter(ClientPNames.HANDLE_REDIRECTS, Boolean.FALSE);

		// Seta o encoding da mensagem XML
		ContentType ct = ContentType.create("text/xml", ENCODING);

		StringEntity se = new StringEntity(xmlRequest, ct);
		se.setContentType("text/xml");
		se.setContentEncoding(ENCODING);
		request.setEntity(se);

		log.debug(xmlRequest);

		return client.execute(request);
	}

	public HttpResponse getRequest(HttpClient client, String resource, String id) throws ClientProtocolException, IOException {
		String url = urlServer + "resources/" + projectAreaAlias + "/" + resource + "/" + id;

		log.debug(url);

		HttpGet request = new HttpGet(url);
		request.addHeader("Content-Type", "application/xml; charset=" + ENCODING);
		request.addHeader("Encoding", ENCODING);

		return client.execute(request);
	}

}
