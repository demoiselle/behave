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

import java.io.Console;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class AutenticatorServer {

	public static final String OPEN = "OPEN";
	public static final String GETUSER = "GET_USER";
	public static final String GETPASS = "GET_PASSWORD";
	public static final String CLOSE = "CLOSE";
	public static final String DEFAULTHOST = "127.0.0.1";
	public static final String DEFAULTPORT = "9990";
	public static final String DEFAULTHOSTALL = "all";
	

	private static AutenticatorServer server = new AutenticatorServer();
	private ServerSocket serverSocket;

	public AutenticatorServer() {
	}

	/**
	 * Inicar o servico.
	 * parametros:
	 * -p <porta> -o <host>
	 * Quando não informado a o padrão p será utilizado a porta padrão 9990
	 * Quando não informado o host será utilizado o localhost
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		Hashtable<String, String> params = new Hashtable<String, String>();
		if (args == null || args.length == 0) {
			params.put("-p", DEFAULTPORT);
			params.put("-o", DEFAULTHOST);
		}
		if (args.length % 2 != 0){
			showHelp();
		}
		for(int i = 0 ; i < args.length; i = i + 2){
			params.put(args[i], args[i+1]);
		}		
		int port = params.containsKey("-p") ? Integer.parseInt(params.get("-p").trim()) : Integer.parseInt(DEFAULTPORT);
		String host = params.containsKey("-o") ? params.get("-o").trim() : DEFAULTHOST;		
		server.start(host, port);
	}

	private static void showHelp() {
		log("===================================================");
		log("Chamada inválida! Use:");
		log("java -jar behave-autenticador-<version>.jar -p <porta> -o <ip-de-origem>");
		log("Valor padrão: -p: 9990 -o: localhost");
		log("Obs.: Use -o 'all' para qualquer ip de origem)");
		log("===================================================");
		System.exit(-1);		
	}

	/**
	 * Inicar o servico
	 * @param client
	 * @param port
	 */
	public void start(String host, int port) {
		try {
			log("=============================================");
			log(" Demoiselle Behave - Serviço de Autenticação");
			log(" Porta: [" + port + "]");
			log(" Acesso: [" + host + "]");
			log("=============================================");
			serverSocket = new ServerSocket(port);
			
			Console console = System.console();
			console.printf("Informe seu usuario...: ");
			String user = console.readLine();
			
			console.printf("Informe sua senha.....: ");
	        char[] passwordChars = console.readPassword();
	        String password = new String(passwordChars);
			
	        log("=============================================");
	        log("               Servico Iniciado              ");
	        log("=============================================");
			while (true) {				
				Socket socket = serverSocket.accept();
				new AutenticatorHandler(socket, user, password, host);
			}
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void log(String message) {		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
		String date = dt.format(GregorianCalendar.getInstance().getTime());
		System.out.println("[" + date + "] " + message);
	}
}
