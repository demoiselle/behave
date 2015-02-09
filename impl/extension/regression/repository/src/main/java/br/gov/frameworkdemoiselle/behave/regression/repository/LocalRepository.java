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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.regression.Repository;
import br.gov.frameworkdemoiselle.behave.regression.Result;

import com.google.common.io.Files;

/**
 * 
 * @author SERPRO
 *
 */
public class LocalRepository implements Repository {

	public static String MESSAGEBUNDLE = "demoiselle-regression-repository-bundle";
	private static BehaveMessage message = new BehaveMessage(FactoryRepository.MESSAGEBUNDLE);

	private File root;

	public LocalRepository() {
		String url = getProperty("behave.regression.url");
		String folder = getProperty("behave.regression.folder");
		String urlProperties = System.getProperty(url);
		if (urlProperties == null || urlProperties.length() == 0) {
			root = new File(url + File.separatorChar + folder);
		} else {
			root = new File(urlProperties + File.separatorChar + folder);
		}
		createFolder(root.getAbsolutePath());
	}

	public void clean() {
		clean(root);
	}

	public void clean(File file) {
		if (file.isDirectory()) {
			for (File c : file.listFiles())
				clean(c);
		}
		if (!file.delete()) {
			throw new BehaveException(message.getString("exception-error-delete-file", file.getAbsoluteFile()));
		}
	}

	private String getProperty(String key) {
		String value = BehaveConfig.getProperty(key);
		if (value == null || value.length() == 0) {
			throw new BehaveException(message.getString("exception-properties-not-found", key));
		}
		return value;
	}

	public void save(Result result) {
		try {
			String folder = getFolder(result);
			createFolder(folder);
			PrintWriter writer = new PrintWriter(folder + File.separatorChar + result.getId() + ".txt", "UTF-8");
			writer.println(result.getDetail());
			writer.close();
			if (result.getFile() != null){
				Files.copy(result.getFile(), new File(folder + File.separatorChar + result.getId() + "." + getExtension(result.getFile())));
			}
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-erro-save-result", e.getMessage()), e);
		}
	}

	@Override
	public Result get(String location, String id) {
		Result result = new Result();
		result.setLocation(location);
		result.setId(id);
		File detail = new File(root.getAbsolutePath() + File.separatorChar + location + File.separatorChar + id + ".txt");
		result.setDetail(readFile(detail));
		result.setFile(getFile(location, id));
		return result;
	}

	private File getFile(String location, String id) {
		File folder = new File(root.getAbsolutePath() + File.separatorChar + location);
		for (File file : folder.listFiles()){
			if (file.getName().startsWith(id + ".") && !getExtension(file).equals("txt")){
				return file;
			}
		}
		return null;		
	}

	private String readFile(File detail) {
		BufferedReader br = null;
		try {
			StringBuffer result = new StringBuffer();
			String line;
			br = new BufferedReader(new FileReader(detail));
			while ((line = br.readLine()) != null) {
				result.append(line).append("\n");
			}			
			return result.substring(0, result.length()-1);
		} catch (IOException e) {
			throw new BehaveException(e);
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				throw new BehaveException(ex);
			}
		}

	}

	private void createFolder(String folder) {
		File _folder = new File(folder);
		if (!_folder.exists()) {
			_folder.mkdirs();
		}
	}

	private String getFolder(Result result) {
		return root.getAbsolutePath() + result.getLocation();
	}

	public int countResults() {
		return countResults(root);
	}

	public int countResults(File file) {
		int count = 0;
		if (file.isDirectory()) {
			for (File c : file.listFiles())
				count += countResults(c);
		} else {
			if (getExtension(file).equals("txt")) {
				count++;
			}
		}
		return count;
	}

	public String getExtension(File file) {
		int i = file.getName().lastIndexOf('.');
		if (i > 0) {
			return file.getName().substring(i + 1);
		}
		return "";
	}

}
