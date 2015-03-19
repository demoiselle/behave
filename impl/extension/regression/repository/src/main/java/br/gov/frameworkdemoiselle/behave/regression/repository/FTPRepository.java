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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
			super.home = ftp.printWorkingDirectory();
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
			// send text
			PrintWriter writer = new PrintWriter(tmpFile, "UTF-8");
			writer.println(result.getDetail());
			writer.close();
			FileInputStream fis = new FileInputStream(tmpFile);
			ftp.storeFile(result.getId() + ".txt", fis);
			fis.close();
			// send image
			if (result.getFile() != null) {
				fis = new FileInputStream(result.getFile());
				ftp.storeFile(result.getId() + "." + FileUtils.getExtension(result.getFile()), fis);
				fis.close();
			}
			(new File(tmpFile)).delete();

		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	@Override
	public void clean() {
		try {
			cdHome();
			cd(super.folder);
			FTPFile[] files = ftp.listFiles();
			for (FTPFile ftpFile : files) {
				countAndRemove(ftpFile, true);
			}
			(new File(tmpFolder)).mkdirs();
			FileUtils.clean(new File(tmpFolder), message);
			(new File(tmpFolder)).mkdirs();
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	@Override
	public int countResults() {
		int result = 0;
		try {
			cdHome();
			cd(super.folder);
			FTPFile[] files = ftp.listFiles();
			for (FTPFile ftpFile : files) {
				result += countAndRemove(ftpFile, false);
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
		return result;
	}

	private int countAndRemove(FTPFile ftpFile, boolean remove) {
		int result = 0;
		try {
			if (ftpFile.isFile()) {
				if (remove && !ftp.deleteFile(ftpFile.getName())) {
					throw new BehaveException(message.getString("exception-erro-remove-file", ftpFile.getName()));
				}
				if (FileUtils.getExtension(ftpFile.getName()).equals("txt")) {
					return 1;
				} else {
					return 0;
				}
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
		try {
			cdHome();
			cd(super.folder);
			List<String> result = new ArrayList<String>();
			for (FTPFile ftpFile : getFolders()) {
				for(String folder : findFolders(ftpFile)){
					result.add(folder);
				}
			}
			Collections.sort(result);
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	private List<FTPFile> getFolders() throws IOException {
		List<FTPFile> list = new ArrayList<FTPFile>();
		for (FTPFile file : ftp.listFiles()){
			if (file.isDirectory()){
				list.add(file);
			}
		}
		return list;
	}

	private List<String> findFolders(FTPFile ftpFile) {
		try {
			cd(ftpFile.getName());
			List<String> result = new ArrayList<String>();
			List<FTPFile> files = getFolders();
			if (files.size() == 0) {
				result.add(subPath(ftp.printWorkingDirectory()));
			} else {
				for (FTPFile file : files) {
					for (String path : findFolders(file)) {
						result.add(path);
					}
				}
			}
			ftp.changeToParentDirectory();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	private String subPath(String path) {
		String root = this.home + BAR + this.folder + BAR;
		path = path.substring(root.length(), path.length());
		return path;
	}

	@Override
	public Result getResult(String location, String id) {
		try {
			cdHome();
			cd(super.folder);
			cd(location);
			FTPFile[] files;
			String localFolder = tmpFolder + BAR + location;
			files = ftp.listFiles();
			String imageType = null;
			for (FTPFile ftpFile : files) {
				if (ftpFile.getName().startsWith(id + ".")) {
					(new File(localFolder)).mkdirs();
					String extension = FileUtils.getExtension(ftpFile.getName());
					if (!extension.equals("txt")) {
						imageType = extension;
					}
					FileOutputStream fos = new FileOutputStream(localFolder + BAR + id + "." + extension);
					ftp.setBufferSize(1024);
					ftp.enterLocalPassiveMode();
					ftp.enterLocalActiveMode();
					ftp.retrieveFile(ftpFile.getName(), fos);
					fos.close();
				}
			}
			Result result = new Result();
			result.setLocation(location);
			result.setId(id);
			File detail = new File(localFolder + BAR + id + ".txt");
			if (detail.exists() && detail.isFile()) {
				result.setDetail(FileUtils.readFile(detail));
			}
			if (imageType != null) {
				result.setFile(new File(localFolder + BAR + id + "." + imageType));
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Result> getResulstByLocation(String location) {
		try {
			cdHome();
			cd(super.folder);
			cd(location);
			List<String> ids = new ArrayList<String>();
			for(FTPFile file : ftp.listFiles()){
				if (FileUtils.getExtension(file.getName()).equalsIgnoreCase("txt")){	
					ids.add(file.getName().substring(0, file.getName().length()-4));
				}
			}
			Collections.sort(ids);
			List<Result> r = new ArrayList<Result>();
			for (String id : ids) {
				Result result = getResult(location, id);
				if (result != null){
					r.add(result);
				}	
			}
			return r;
			
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	private void createFolder(String path) {
		try {
			cdHome();
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

	private void cdHome() {
		try {
			if (!ftp.changeWorkingDirectory(super.home)) {
				throw new BehaveException(message.getString("exception-erro-change-folder", super.home));
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}

	private void cd(String path) {
		try {
			String[] folders = path.split(File.separator);
			for (String dir : folders) {
				dir = ftp.printWorkingDirectory() + BAR + dir;
				if (!ftp.changeWorkingDirectory(dir)) {
					throw new BehaveException(message.getString("exception-erro-change-folder", dir));
				}
			}
		} catch (Exception e) {
			throw new BehaveException(e);
		}
	}
}
