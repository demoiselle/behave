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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AutenticatorClient {

	private int port;
	private String client;
	private String token = null;

	public AutenticatorClient(int port, String client) {
		this.port = port;
		this.client = client;
	}

	/**
	 * Cria conexao com o servidor de autenticacao
	 */
	public void open() {
		token = sendMessage(client, port, "OPEN");
	}

	/**
	 * Obtem o usuario
	 * 
	 * @return
	 */
	public String getUser() {
		return sendMessage(client, port, Cipher.cript("GET_USER", token));
	}

	/**
	 * Obtem a senha
	 * 
	 * @return
	 */
	public String getPassword() {
		return sendMessage(client, port, Cipher.cript("GET_PASSWORD", token));
	}

	/**
	 * Conclui conexao com o autenticador
	 */
	public void close() {
		sendMessage(client, port, Cipher.cript("CLOSE", token));
	}

	/**
	 * Envia mensagem ao servidor
	 * 
	 * @param host
	 * @param port
	 * @param _message
	 * @return
	 */
	private String sendMessage(String host, int port, String _message) {
		try {
			Socket socket = new Socket(host, port);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(_message);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			if (token != null){
				message = Cipher.decript(message, token);
			}
			ois.close();
			oos.close();
			return message;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao enviar mensagem.", e);
		}
	}

}
