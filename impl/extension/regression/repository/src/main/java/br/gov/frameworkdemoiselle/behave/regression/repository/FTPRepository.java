/*
 * Demoiselle Framework
 * Copyright (C) 2015 SERPRO
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
package br.gov.frameworkdemoiselle.behave.regression.repository;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.regression.Result;

/**
 * 
 * @author SERPRO
 *
 */
public class FTPRepository extends AbstractRepository {

	private static Logger log = Logger.getLogger(FTPRepository.class);

	private FTPClient ftp;

	public FTPRepository() {
		super();
		ftp = new FTPClient();
		createFolder(super.folder);
	}

	public void save(Result result) {
		try {
			conect();
		} catch (Exception e) {
			throw new BehaveException(e);
		} finally {
			logout();
		}
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub

	}

	@Override
	public int countResults() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result getResul(String id, String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Result> getResulstByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	// / FTP Util

	private void conect() {
		try {
			log.debug("ftp conect");
			ftp.connect(url);
			if (!ftp.login(user, password)) {
				throw new BehaveException(message.getString("exception-failed-connect-ftp"));
			}
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-failed-connect-ftp"), e);
		}

	}

	private void logout() {
		try {
			if (ftp.isConnected()) {
				log.debug("ftp logout");
				ftp.logout();
				ftp.disconnect();
			} else {
				throw new BehaveException(message.getString("exception-failed-disconnect-ftp-is-open"));
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	private  void createFolder(String path) {
		try {
			conect();
			boolean exist = true;
			String[] folders = path.split(File.separator);
			for (String dir : folders) {
				if (!dir.isEmpty()) {
					if (exist) {
						exist = ftp.changeWorkingDirectory(dir);
					}
					if (!exist) {
						if (!ftp.makeDirectory(dir)) {
							throw new BehaveException(message.getString("exception-failed-ftp", "makeDirectory"));
						}
						if (!ftp.changeWorkingDirectory(dir)) {
							throw new BehaveException(message.getString("exception-failed-ftp", "changeWorkingDirectory"));
						}
					}
				}
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		} finally {
			logout();
		}
	}

	public static void main(String[] args) {
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("10.200.232.59");
			ftp.login("stct3", "stct3");
			ftp.changeWorkingDirectory("dbehave-autenticadord");
			String[] arq = ftp.listNames();
			System.out.println("Listando arquivos: \n");
			for (String f : arq) {
				System.out.println(f);
			}
			FileInputStream arqEnviar = new FileInputStream("/home/03397040477/workspace-stct3/prototipo.zip");
			if (ftp.storeFile("prototipo.zip", arqEnviar)) {
				System.out.println("Arquivo armazenado com sucesso!");
			} else {
				System.out.println("Erro ao armazenar o arquivo.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
