package br.gov.frameworkdemoiselle.behave.internal.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.frameworkdemoiselle.behave.util.FileUtil;

public class StoryFileConverter {

	public static List<String> convertReusedScenarios(List<String> originalFolderes, String originalExtension, String convertedExtension, Boolean includeSubFolder) throws IOException {
		List<String> originalBaseFilesName = new ArrayList<String>();
		for (String originalFolder : originalFolderes) {
			originalBaseFilesName.addAll(FileUtil.getFilesInFolderByExtension(originalFolder, originalExtension, includeSubFolder));
		}
		return convertReusedScenarios(originalBaseFilesName, originalExtension, convertedExtension);
	}

	public static List<String> convertReusedScenarios(String originalFolder, String originalExtension, String convertedExtension, Boolean includeSubFolder) throws IOException {
		List<String> originalBaseFilesName = FileUtil.getFilesInFolderByExtension(originalFolder, convertedExtension, includeSubFolder);
		return convertReusedScenarios(originalBaseFilesName, originalExtension, convertedExtension);
	}

	// originBaseFilesName = lista de nomes de arquivo sem a extensão
	public static List<String> convertReusedScenarios(List<String> originalBaseFilesName, String originalExtension, String convertedExtension) throws IOException {
		Map<String, String> originStories = new HashMap<String, String>();

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
