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
package br.gov.frameworkdemoiselle.behave.integration.alm.autenticator;

import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.CLOSE;
import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.DEFAULTHOSTALL;
import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.GETPASS;
import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.GETUSER;
import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.OPEN;
import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutenticatorHandler implements Runnable {

	private static Hashtable<String, String> connections = new Hashtable<String, String>();

	private Socket socket;

	private String user;

	private String password;

	private String host;

	public AutenticatorHandler(Socket socket, String user, String password, String host) {
		this.user = user;
		this.password = password;
		this.socket = socket;
		this.host = host;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			String responseMessage = "";
			if (!this.host.equalsIgnoreCase(DEFAULTHOSTALL) && !valid(socket)) {
				log("acesso indevido:" + socket.getRemoteSocketAddress().toString());
				socket.close();
				return;
			}
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();

			if (message.equals(OPEN)) {
				log("=============================================");
				log("cliente: " + getIP(socket.getRemoteSocketAddress()));
				String token = GregorianCalendar.getInstance().getTimeInMillis() + "";
				connections.put(getIP(socket.getRemoteSocketAddress()), token);
				sendMessage(token, null, socket);
				responseMessage = "obteve conexao";
			} else {

				String token = connections.get(getIP(socket.getRemoteSocketAddress()));
				message = Cipher.decript(message, token);
				if (token != null) {
					if (message.equals(GETUSER)) {
						responseMessage = "obteve usuario: " + user;
						sendMessage(user, token, socket);
					} else if (message.equals(GETPASS)) {
						responseMessage = "obteve senha";
						sendMessage(password, token, socket);
					} else if (message.equals(CLOSE)) {
						connections.remove(socket.getRemoteSocketAddress().toString());
						responseMessage = "fechou conexao";
						sendMessage(responseMessage, token, socket);
					} else {
						responseMessage = "opcao invalida: " + message;
						sendMessage(responseMessage, token, socket);
					}
				} else {
					sendMessage("conexao perdida", null, socket);
				}
			}
			ois.close();
			socket.close();
			log(responseMessage);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String getIP(SocketAddress adress) {
		Pattern MY_PATTERN = Pattern.compile("\\/(.*?)\\:");
		Matcher m = MY_PATTERN.matcher(adress.toString());
		while (m.find()) {
			return m.group(1);
		}
		throw new RuntimeException("Endereco fora do padrao [" + adress.toString() + "]");
	}

	private boolean valid(Socket socket) {
		return socket.getRemoteSocketAddress().toString().contains(host);
	}

	private void sendMessage(String message, String token, Socket socket2) throws IOException {
		if (token != null) {
			message = Cipher.cript(message, token);
		}
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message);
		oos.close();
	}

}
