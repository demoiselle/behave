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
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import br.gov.frameworkdemoiselle.behave.integration.Integration;
import br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorClient;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.ApprovalState;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.Executionresult;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.ExecutionresultExecutionworkitem;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.Executionworkitem;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.ExecutionworkitemTestcase;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.Priority;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.State;
import br.gov.frameworkdemoiselle.behave.integration.alm.objects.Testcase;

@SuppressWarnings("deprecation")
public class ALMIntegration implements Integration {

	/**
	 * ERRO 400 - Posssivelmente o nome da área não esta correto
	 */

	public String urlServer = "https://homalm.serpro/qm/service/com.ibm.rqm.integration.service.IIntegrationService/";
	public String urlServerAuth = "https://homalm.serpro/qm/j_security_check";
	public String projectAreaAlias = "Demoiselle Behave";

	public void sendScenario(Hashtable<String, Object> result) {

		try {

			// Pega os dados de autenticação
			AutenticatorClient autenticator = new AutenticatorClient(9990, "localhost");
			autenticator.open();
			String username = autenticator.getUser();
			String password = autenticator.getPassword();
			autenticator.close();

			// Encode do Alias do Projeto
			projectAreaAlias = URLEncoder.encode(projectAreaAlias, "UTF-8");

			System.out.println("------------- INICIOU O PROCESSO -------------");

			// --------------------------- TestCase

			// Conexão HTTPS
			HttpClient client = getNewHttpClient();

			// Login
			HttpResponse responseLogin = login(client, username, password);
			if (responseLogin.getStatusLine().getStatusCode() != 302 || !responseLogin.toString().contains("LtpaToken2")) {
				throw new Exception("Erro ao logar na aplicação");
			}

			// TestCase
			String testCaseName = "testcase" + System.nanoTime();
			HttpResponse responseTestCase = sendRequest(client, "testcase", testCaseName, getTestcaseString());
			if (responseTestCase.getStatusLine().getStatusCode() != 201 && responseTestCase.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Erro ao criar caso de teste: " + responseTestCase.getStatusLine().toString());
			}

			// --------------------------- Work Item
			// Conexão HTTPS
			client = getNewHttpClient();

			// Login
			responseLogin = login(client, username, password);
			if (responseLogin.getStatusLine().getStatusCode() != 302 || !responseLogin.toString().contains("LtpaToken2")) {
				throw new Exception("Erro ao logar na aplicação");
			}

			// WorkItem
			// String workItemName = "workitem" + System.nanoTime();
			String workItemName = "workitemExecucaoAutomatizada";
			HttpResponse responseWorkItem = sendRequest(client, "executionworkitem", workItemName, getExecutionworkitemString(testCaseName));
			if (responseWorkItem.getStatusLine().getStatusCode() != 201 && responseWorkItem.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Erro ao criar work item: " + responseWorkItem.getStatusLine().toString());
			}

			// --------------------------- Result
			// Conexão HTTPS
			client = getNewHttpClient();

			// Login
			responseLogin = login(client, username, password);
			if (responseLogin.getStatusLine().getStatusCode() != 302 || !responseLogin.toString().contains("LtpaToken2")) {
				throw new Exception("Erro ao logar na aplicação");
			}

			// WorkItem
			String resultName = "result" + System.nanoTime();
			HttpResponse responseResult = sendRequest(client, "executionresult", resultName, getExecutionresultString(workItemName));
			if (responseResult.getStatusLine().getStatusCode() != 201) {
				throw new Exception("Erro ao result: " + responseResult.getStatusLine().toString());
			}

			System.out.println("------------- FINALIZOU O PROCESSO -------------");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getTestcaseString() throws JAXBException {
		Priority priority = new Priority();
		priority.setResource(urlServer + "process-info/_EX3W1K3iEeKZTtTZfLxNXw/priority/literal.priority.101");
		priority.setValue("literal.priority.101");

		State state = new State();
		state.setResource(urlServer + "process-info/_EX3W1K3iEeKZTtTZfLxNXw/workflowstate/com.ibm.rqm.process.testcase.workflow/com.ibm.rqm.planning.common.underreview");
		state.setValue("com.ibm.rqm.planning.common.underreview");

		Testcase testcase = new Testcase();
		testcase.setTitle("CRIADO VIA JAXB");
		testcase.setPriority(priority);
		testcase.setState(state);
		testcase.setSuspect(false);
		testcase.setWeight(100);

		JAXBContext jaxb = JAXBContext.newInstance(Testcase.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter testCaseString = new StringWriter();
		marshaller.marshal(testcase, testCaseString);

		System.out.println(testCaseString.toString());

		return testCaseString.toString();
	}

	public String getExecutionworkitemString(String testCaseId) throws JAXBException {

		Priority priority = new Priority();
		priority.setResource(urlServer + "/process-info/_EX3W1K3iEeKZTtTZfLxNXw/priority/literal.priority.101");
		priority.setValue("literal.priority.101");

		ExecutionworkitemTestcase workTest = new ExecutionworkitemTestcase();
		workTest.setHref(urlServer + "resources/" + projectAreaAlias + "/testcase/" + testCaseId);

		Executionworkitem work = new Executionworkitem();
		work.setFrequency("Once");
		work.setPriority(priority);
		work.setRegression(false);
		work.setTitle("TESTE WORK");
		work.setWeight(100);
		work.setTestcase(workTest);

		JAXBContext jaxb = JAXBContext.newInstance(Executionworkitem.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter resourceString = new StringWriter();
		marshaller.marshal(work, resourceString);

		System.out.println(resourceString.toString());

		return resourceString.toString();

	}

	public String getExecutionresultString(String executionWorkItemId) throws JAXBException {
		ApprovalState state = new ApprovalState();
		state.setResource(urlServer + "/process-info/_EX3W1K3iEeKZTtTZfLxNXw/workflowstate/com.ibm.rqm.process.testcaseresult.workflow/com.ibm.rqm.planning.common.new");
		state.setValue("com.ibm.rqm.planning.common.new");

		ExecutionresultExecutionworkitem workTest = new ExecutionresultExecutionworkitem();
		workTest.setHref(urlServer + "resources/" + projectAreaAlias + "/executionworkitem/" + executionWorkItemId);

		Executionresult result = new Executionresult();
		result.setState("com.ibm.rqm.execution.common.state.passed");
		result.setApprovalstate(state);
		result.setExecutionworkitem(workTest);
		result.setPointspassed(1);
		result.setPointsattempted(1);

		JAXBContext jaxb = JAXBContext.newInstance(Executionresult.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter resourceString = new StringWriter();
		marshaller.marshal(result, resourceString);

		System.out.println(resourceString.toString());

		return resourceString.toString();
	}

	public HttpResponse login(HttpClient client, String username, String password) throws ClientProtocolException, IOException {
		// Inicia o login
		HttpPost requestAuth = new HttpPost(urlServerAuth);

		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("j_username", username));
		formparams.add(new BasicNameValuePair("j_password", password));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		requestAuth.setEntity(entity);

		// Faz o post e pega os cookies
		HttpResponse response = client.execute(requestAuth);

		return response;
	}

	public HttpResponse sendRequest(HttpClient client, String resource, String id, String xmlRequest) throws ClientProtocolException, IOException {
		String url = urlServer + "resources/" + projectAreaAlias + "/" + resource + "/" + id;

		System.out.println(url);

		HttpPut request = new HttpPut(url);
		request.addHeader("Content-Type", "application/xml");

		StringEntity se = new StringEntity(xmlRequest);
		se.setContentType("text/xml");
		request.setEntity(se);

		return client.execute(request);
	}

	private HttpClient getNewHttpClient() {
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);
			MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
			sf.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));

			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			return new DefaultHttpClient(ccm, params);
		} catch (Exception e) {
			return new DefaultHttpClient();
		}
	}

	public class MySSLSocketFactory extends SSLSocketFactory {
		SSLContext sslContext = SSLContext.getInstance("TLS");

		public MySSLSocketFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
			super(truststore);

			TrustManager tm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			sslContext.init(null, new TrustManager[] { tm }, null);
		}

		@Override
		public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
			return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
		}

		@Override
		public Socket createSocket() throws IOException {
			return sslContext.getSocketFactory().createSocket();
		}
	}

}
