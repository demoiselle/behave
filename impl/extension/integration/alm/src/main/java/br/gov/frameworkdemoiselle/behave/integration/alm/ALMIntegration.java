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
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
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
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.bind.DatatypeConverter;

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

public class ALMIntegration implements Integration {

	private Logger logger = Logger.getLogger(this.toString());

	public void sendScenario(Hashtable<String, Object> result) {
		String username = "03397040477";
		String password = "serpro123";

		try {

			URL url = new URL("https://homalm.serpro/qm/j_security_check");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			String userpass = username + ":" + password;
			String basicAuth = "Basic " + javax.xml.bind.DatatypeConverter.printBase64Binary(userpass.getBytes());

			conn.setRequestProperty("Authorization", basicAuth);

			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");

			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// ALMIntegration i = new ALMIntegration();
		// i.sendScenario(new Hashtable<String, Object>());
		try {
			String username = "03397040477";
			String password = "serpro123";

			// Conexão HTTP
			HttpClient client = getNewHttpClient();

			// Inicia o login
			HttpPost requestAuth = new HttpPost("https://homalm.serpro/qm/j_security_check");

			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("j_username", username));
			formparams.add(new BasicNameValuePair("j_password", password));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
			requestAuth.setEntity(entity);

			// Faz o post e pega os cookies
			HttpResponse response = client.execute(requestAuth);

			if (response.getStatusLine().getStatusCode() != 302) {
				throw new Exception("Erro ao logar na aplicação");
			}

			String userpass = username + ":" + password;
			String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userpass.getBytes());

			// ------------ CREATE TEST CASE ------------

			HttpPut request = new HttpPut("https://homalm.serpro/qm/service/com.ibm.rqm.integration.service.IIntegrationService/resources/RE-RQM-Básico-042013%20(Gerenciamento%20de%20Qualidade)/testcase/CasoDeTesteNovo1");
			request.addHeader("Content-Type", "application/xml");
			request.addHeader("Authorization", basicAuth);

			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<testcase xmlns=\"http://jazz.net/xmlns/alm/qm/v0.1/\" " + "xmlns:ns1=\"http://purl.org/dc/elements/1.1/\"" + " xmlns:ns2=\"http://jazz.net/xmlns/alm/v0.1/\"" + " externalid=\"CasoDeTesteNovo1\">" + "<ns1:title>NOME DO CASO</ns1:title>" + "<ns1:description>DESCRICAO DO CASO</ns1:description>" + "<ns2:state>com.ibm.rqm.planning.common.new</ns2:state>" + "</testcase>";

			StringEntity se = new StringEntity(xml);
			se.setContentType("text/xml");
			request.setEntity(se);

			response = client.execute(request);

			if (response.getStatusLine().getStatusCode() != 201) {
				throw new Exception("Erro ao criar caso de teste");
			}

			// ------------ CREATE RESULT ------------

//			HttpPost requestResult = new HttpPost("https://homalm.serpro/qm/service/com.ibm.rqm.integration.service.IIntegrationService/resources/RE-RQM-Básico-042013%20(Gerenciamento%20de%20Qualidade)/executionresult");
//
//			requestResult.addHeader("Content-Type", "application/xml");
//			requestResult.addHeader("Authorization", basicAuth);
//
//			String xmlResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<testcase xmlns=\"http://jazz.net/xmlns/alm/qm/v0.1/\" " + "xmlns:ns1=\"http://purl.org/dc/elements/1.1/\"" + " xmlns:ns2=\"http://jazz.net/xmlns/alm/v0.1/\"" + ">" + "<ns1:title>NOME DO CASO1111</ns1:title>" + "<ns1:description>DESCRICAO DO CASO1111</ns1:description>" + "<ns2:state>com.ibm.rqm.planning.common.new</ns2:state>" + "</testcase>";
//
//			StringEntity seResult = new StringEntity(xmlResult);
//			seResult.setContentType("text/xml");
//			requestResult.setEntity(se);
//
//			response = client.execute(requestResult);
//
//			if (response.getStatusLine().getStatusCode() != 201) {
//				throw new Exception("Erro ao criar resultado");
//			}


		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	private static HttpClient getNewHttpClient() {
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

	public static class MySSLSocketFactory extends SSLSocketFactory {
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
