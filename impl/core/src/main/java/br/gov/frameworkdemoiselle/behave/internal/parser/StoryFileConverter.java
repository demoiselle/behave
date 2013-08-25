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
package br.gov.frameworkdemoiselle.behave.internal.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.util.FileUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;

/**
 * 
 * @author SERPRO
 * 
 */
public class StoryFileConverter {
	
	private static BehaveMessage bm = new BehaveMessage(BehaveConfig.MESSAGEBUNDLE);

	public static List<String> convertReusedScenarios(List<String> originalFolderes, String originalExtension, String convertedExtension, Boolean includeSubFolder) {
		try {
			List<String> originalBaseFilesName = new ArrayList<String>();
			for (String originalFolder : originalFolderes) {
				originalBaseFilesName.addAll(FileUtil.getFilesInFolderByExtension(originalFolder, originalExtension, includeSubFolder));
			}
			return convertReusedScenarios(originalBaseFilesName, originalExtension, convertedExtension);
		} catch (IOException ex) {
			throw new BehaveException(bm.getString("exception-scenarios-convert"), ex);
		}
	}

	public static List<String> convertReusedScenarios(String originalFolder, String originalExtension, String convertedExtension, Boolean includeSubFolder) throws IOException {
		List<String> originalBaseFilesName = FileUtil.getFilesInFolderByExtension(originalFolder, convertedExtension, includeSubFolder);
		return convertReusedScenarios(originalBaseFilesName, originalExtension, convertedExtension);
	}

	// originBaseFilesName = lista de nomes de arquivo sem a extensão
	public static List<String> convertReusedScenarios(List<String> originalBaseFilesName, String originalExtension, String convertedExtension) throws IOException {
		Map<String, String> originStories = new LinkedHashMap<String, String>();

		// Coloca o conteúdo dos arquivos de origem no map, já utilizando como
		// chave o nome de destino do arquivo
		for (String originalFile : originalBaseFilesName) {
			String fileNameWithoutExt = originalFile.substring(0, (originalFile.lastIndexOf('.') + 1));
			originStories.put(fileNameWithoutExt + convertedExtension, FileUtil.loadFile(originalFile));
		}

		// Converte os arquivos
		Map<String, String> convertedStories = StoryConverter.convertReusedScenarios(originStories);
		// Grava os arquivos convertidos
		for (String convertedFile : convertedStories.keySet()) {
			FileUtil.createFile(convertedFile, convertedStories.get(convertedFile));
		}
		return new ArrayList<String>(convertedStories.keySet());
	}

}
