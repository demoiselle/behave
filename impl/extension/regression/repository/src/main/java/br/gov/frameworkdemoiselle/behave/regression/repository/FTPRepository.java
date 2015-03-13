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
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
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
	private String tmpFolder;

	public FTPRepository() {
		super();
		tmpFolder = System.getProperty("java.io.tmpdir") + BAR + folder;
		ftp = new FTPClient();
	}

	@Override
	public void connect() {
		super.connect();
		try {
			log.debug("ftp conect");
			ftp.connect(url);
			if (!ftp.login(user, password)) {
				throw new BehaveException(message.getString("exception-failed-connect-ftp"));
			}
			createFolder(super.folder);
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-failed-connect-ftp"), e);
		}
	}

	@Override
	public void disconnect() {
		super.disconnect();
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

	public void save(Result result) {
		try {
			String resultFolder = super.folder + BAR + result.getLocation();
			String tmpFile = tmpFolder + BAR + result.getId() + ".txt";
			createFolder(resultFolder);
			FileUtils.createFolder(tmpFolder);
			PrintWriter writer = new PrintWriter(tmpFile, "UTF-8");
			writer.println(result.getDetail());
			writer.close();
			FileInputStream fis = new FileInputStream(tmpFile);
			ftp.storeFile(result.getId() + ".txt", fis);
			fis.close();
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	@Override
	public void clean() {
		try {
			goHome();
			if (changeWorkingDirectory(super.folder)) {
				FTPFile[] files = ftp.listFiles();
				for (FTPFile ftpFile : files) {
					countAndRemove(ftpFile, true);
				}
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	@Override
	public int countResults() {
		int result = 0;
		try {
			goHome();
			if (changeWorkingDirectory(super.folder)) {
				FTPFile[] files = ftp.listFiles();
				for (FTPFile ftpFile : files) {
					result += countAndRemove(ftpFile, false);
				}
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
		return result;
	}

	private int countAndRemove(FTPFile ftpFile, boolean remove) {
		int result = 0;
		try {
			if (ftpFile.isFile() && FileUtils.getExtension(ftpFile.getName()).equals("txt")) {
				if (remove && !ftp.deleteFile(ftpFile.getName())) {
					throw new BehaveException(message.getString("exception-erro-remove-file", ftpFile.getName()));
				}
				return 1;
			} else {
				if (ftp.changeWorkingDirectory(ftpFile.getName())) {
					FTPFile[] files = ftp.listFiles();
					for (FTPFile _ftpFile : files) {
						result += countAndRemove(_ftpFile, remove);
					}
					if (!ftp.changeToParentDirectory()) {
						throw new BehaveException(message.getString("exception-erro-change-folder", ".."));
					}
					if (remove && !ftp.removeDirectory(ftpFile.getName())) {
						throw new BehaveException(message.getString("exception-erro-remove-folder", ftpFile.getName()));
					}
				} else {
					throw new BehaveException(message.getString("exception-erro-change-folder", ftpFile.getName()));
				}
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
		return result;
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

	private void createFolder(String path) {
		try {
			goHome();
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
		}
	}

	private void goHome() {
		try {
			ftp.changeWorkingDirectory(super.home);
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	private boolean changeWorkingDirectory(String path) {
		try {
			String[] folders = path.split(File.separator);
			for (String dir : folders) {
				if (!ftp.changeWorkingDirectory(dir)) {
					return false;
				}
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
		return true;
	}
}
