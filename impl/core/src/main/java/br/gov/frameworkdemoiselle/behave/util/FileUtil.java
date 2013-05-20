package br.gov.frameworkdemoiselle.behave.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	public static String loadFile(String pFilePath) throws IOException {
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

	public static String loadResource(String resourcePath) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();

		File file = new File(getAbsolutePath(resourcePath));
		FileInputStream fileInputStream = new FileInputStream(file);

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

	public static String createTempDir(String dir) {
		String tempDirName = dir;
		File file = new File(getAbsolutePath("."), tempDirName);
		if (!file.exists()) {
			file.mkdir();
		}
		return file.getAbsolutePath();
	}

	public static String getAbsolutePath(String fileRelativePath) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		File file = new File(loader.getResource(fileRelativePath).getFile());
		return file.getAbsolutePath();
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
		List<String> fileNames = new ArrayList<String>();
		File folder = new File(folderRoot);
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
			if (RegularExpressionUtil.matches("([^\\s]+(\\.(?i)(" + extension + "))$)", fileName)) {
				filteredFileNames.add(fileName);
			}
		}
		return filteredFileNames;
	}

}
