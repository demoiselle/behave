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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.regression.Result;

import com.google.common.io.Files;

/**
 * 
 * @author SERPRO
 *
 */
public class LocalRepository extends AbstractRepository {

	private File root;
	protected String urlProperties;

	public LocalRepository() {
		super();
		if (System.getProperty(url) == null || System.getProperty(url).length() == 0) {
			root = new File(url + BAR + folder);
		} else {
			root = new File(System.getProperty(url) + BAR + folder);
		}
		FileUtils.createFolder(root.getAbsolutePath());
	}

	public void clean() {
		FileUtils.clean(root, message);
	}
	
	public List<Result> getResulstByLocation(String location) {
		List<String> ids = new ArrayList<String>();
		File folder = new File(root.getAbsolutePath() + BAR + location);
		if (folder.exists() && folder.isDirectory()){
			for (File file : folder.listFiles()) {
				if (FileUtils.getExtension(file).equalsIgnoreCase("txt")){	
					ids.add(file.getName().substring(0, file.getName().length()-4));
				}
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
	}

	public void save(Result result) {
		try {
			String folder = getFolder(result);
			FileUtils.createFolder(folder);
			PrintWriter writer = new PrintWriter(folder + BAR + result.getId() + ".txt", "UTF-8");
			writer.println(result.getDetail());
			writer.close();
			if (result.getFile() != null) {
				Files.copy(result.getFile(), new File(folder + BAR + result.getId() + "." + FileUtils.getExtension(result.getFile())));
			}
		} catch (Exception e) {
			throw new BehaveException(message.getString("exception-erro-save-result", e.getMessage()), e);
		}
	}

	public Result getResult(String location, String id) {
		Result result = new Result();
		result.setLocation(location);
		result.setId(id);
		File folder = new File(root.getAbsolutePath() + BAR + location);
		if (folder.exists() && folder.isDirectory()) {
			File detail = new File(folder.getAbsolutePath() + BAR + id + ".txt");
			if (detail.exists() && detail.isFile()) {
				result.setDetail(FileUtils.readFile(detail));
				result.setFile(getFile(location, id));
				return result;
			}
		}
		return null;
	}
	
	public List<String> getLocations() {
		List<String> r = findFolders(root);
		Collections.sort(r);
 		return r;
	}

	private List<String> findFolders(File _file) {
		List<String> r = new ArrayList<String>();
		if (! FileUtils.hasSubFolder(_file)){
			if (_file.equals(root)){
				return r;
			}else{
				r.add(BAR + _file.getName());
				return r;
			}
		}else{			
			for (File file : _file.listFiles()) {
				if (file.isDirectory()){
					for(String path : findFolders(file)){
						if (_file.equals(root)){
							r.add(path);
						}else{
							r.add(_file.getName() + path);
						}
					}							
				}
			}
		}
		return r;		
	}
		
	private File getFile(String location, String id) {
		File folder = new File(root.getAbsolutePath() + BAR + location);
		for (File file : folder.listFiles()) {
			if (file.getName().startsWith(id + ".") && ! FileUtils.getExtension(file).equals("txt")) {
				return file;
			}
		}
		return null;
	}


	private String getFolder(Result result) {
		return root.getAbsolutePath() + BAR + result.getLocation();
	}

	public int countResults() {
		return countResults(root);
	}

	private int countResults(File file) {
		int count = 0;
		if (file.isDirectory()) {
			for (File c : file.listFiles())
				count += countResults(c);
		} else {
			if (FileUtils.getExtension(file).equals("txt")) {
				count++;
			}
		}
		return count;
	}
}
