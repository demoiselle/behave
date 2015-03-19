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

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 *
 */
public class FileUtils {
	
	public static void createFolder(String folder) {
		File _folder = new File(folder);
		if (!_folder.exists()) {
			_folder.mkdirs();
		}
	}
	
	public static String getExtension(String name) {		
		return getExtension(new File(name));
	}
	
	public static String getExtension(File file) {
		int i = file.getName().lastIndexOf('.');
		if (i > 0) {
			return file.getName().substring(i + 1);
		}
		return "";
	}
	
	
	public static void clean(File file,  BehaveMessage message) {
		if (file.isDirectory()) {
			for (File _file : file.listFiles())
				clean(_file, message);
		}
		if (!file.delete()) {
			throw new BehaveException(message.getString("exception-error-delete-file", file.getAbsoluteFile()));
		}
	}
	
	public static String readFile(File detail) {
		BufferedReader br = null;
		try {
			StringBuffer result = new StringBuffer();
			String line;
			br = new BufferedReader(new FileReader(detail));
			while ((line = br.readLine()) != null) {
				result.append(line).append("\n");
			}
			return result.substring(0, result.length() - 1);
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
	
	public static boolean hasSubFolder(File _file){
		File[] l = _file.listFiles();
		if (l == null){
			return false;
		}
		for (File file : l) {
			if (file.isDirectory())
				return true;			
		}
		return false;
	}

	
}
