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
package br.gov.frameworkdemoiselle.behave.internal.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 *
 */
public class FileUtil {

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	public static String loadFile(String pFilePath) throws IOException {		
		pFilePath = pFilePath.replaceAll("%20", " "); // Correção de problemas com espaços		
		StringBuilder stringBuilder = new StringBuilder();
		FileInputStream fileInputStream = new FileInputStream(new File(pFilePath));
		try {
			String line = "";
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
			bufferedReader.close();
		} finally {
			fileInputStream.close();
		}
		return stringBuilder.toString();
	}

	public static String getAbsolutePath() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			File file = new File(loader.getResource("").getFile());
			return URLDecoder.decode(file.getAbsolutePath(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new BehaveException(bm.getString("exception-enconding-error"), e);
		}
	}

	public static void createFile(String filePath, String content) throws IOException {
		File file = new File(filePath);

		if (!file.exists()) {

			String aux = file.getParent();

			File dirs = new File(aux);
			if (!dirs.exists()) {
				dirs.mkdirs();
			}

			file.createNewFile();
		}

		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(fileWriter);

		try {
			writer.write(content);
		} finally {
			writer.close();
		}
	}

	public static List<String> getFilesInFolder(String folderRoot, Boolean includeSubfolder) {
		folderRoot = folderRoot.replaceAll("%20", " ");
		List<String> fileNames = new ArrayList<String>();
		File folder = new File(folderRoot);
		if (!folder.exists()) {
			folder = new File(FileUtil.getAbsolutePath() + folderRoot);
			folderRoot = folder.getAbsolutePath();
			if (!folder.exists()) {
				throw new BehaveException(bm.getString("exception-path-not-found",folderRoot));
			}
		}

		if (folder.isFile()) {
			fileNames.add(folder.getAbsolutePath());
			return fileNames;
		}

		File[] files = folder.listFiles();
		String entryName;
		for (File file : files) {
			entryName = file.getName();
			if (includeSubfolder && file.isDirectory()) {
				fileNames.addAll(getFilesInFolder(folderRoot + FILE_SEPARATOR + entryName, includeSubfolder));
			} else {
				fileNames.add(folderRoot + FILE_SEPARATOR + entryName);
			}
		}
		return fileNames;
	}

	public static List<String> getFilesInFolderByExtension(String folderRoot, String extension, Boolean includeSubfolder) {
		List<String> fileNames = new ArrayList<String>();
		fileNames = getFilesInFolder(folderRoot, includeSubfolder);
		List<String> filteredFileNames = new ArrayList<String>();
		for (String fileName : fileNames) {
			if (fileName.endsWith(extension)) {
				filteredFileNames.add(fileName);
			}
		}
		return filteredFileNames;
	}

}
