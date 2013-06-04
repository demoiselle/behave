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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import static br.gov.frameworkdemoiselle.behave.integration.alm.autenticator.AutenticatorServer.*;


public class AutenticatorHandler implements Runnable {

	private static Hashtable<String, String> connections = new Hashtable<String, String>();

	private Socket socket;

	private String user;

	private String password;

	public AutenticatorHandler(Socket socket, String user, String password) {
		this.user = user;
		this.password = password;
		this.socket = socket;
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			String response = "";
			if (message.equals(OPEN)) {
				log("=============================================");
				log("cliente: " + socket.getLocalAddress().getHostName());
				String token = GregorianCalendar.getInstance().getTimeInMillis() + "";
				connections.put(token, socket.getLocalAddress().toString());
				sendMessage(token, socket);
				response = "obteve conexao";
			} else {
				String[] split = message.split("@");
				if (split.length != 2) {
					sendMessage("Opcao invalida: " + split[0], socket);
				}
				String token = split[1];
				if (connections.containsKey(token)) {
					if (split[0].equals(GETUSER)) {
						response = "obteve usuario: " + user;
						sendMessage(user, socket);						
					} else if (split[0].equals(GETPASS)) {
						response = "obteve senha";
						sendMessage(password, socket);
					} else if (split[0].equals(CLOSE)) {
						connections.remove(token);
						response = "fechou conexao";
						sendMessage(response, socket);
					} else {
						response = "opcao invalida: " + split[0];
						sendMessage(response, socket);
					}
				} else {
					sendMessage("conexao [" + token + "] nao encontrada", socket);
				}
			}
			ois.close();
			socket.close();
			log(response);	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String message, Socket socket2) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message);
		oos.close();
	}

}
