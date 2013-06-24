package br.gov.frameworkdemoiselle.behave.util;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class FileUtilTest {

	@Test
	public void testLoadFile() {

		String curDir = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");

		try {
			String content = FileUtil.loadFile(curDir + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "files" + fileSeparator + "filesample.txt");
			Assert.assertEquals("content\n", content);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testCreateTempDir() {
		String property = "java.io.tmpdir";

		String tempDir = System.getProperty(property);

		String temp = FileUtil.createTempDir(tempDir);

		Assert.assertTrue(temp.contains(tempDir));

	}

	@Test
	public void testGetAbsolutePath() {

		String absolutePath = FileUtil.getAbsolutePath();

		Assert.assertTrue(absolutePath.contains("behave"));
	}

	@Test
	public void testCreateFile() {
		String property = "java.io.tmpdir";

		String tempDir = System.getProperty(property);

		String temp = FileUtil.createTempDir(tempDir);

		try {
			FileUtil.createFile(temp + "file.tmp", "content");
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testGetFilesInFolder() {
		String curDir = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");

		List<String> files = FileUtil.getFilesInFolder(curDir + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "files", true);
		Assert.assertTrue(files.get(0).contains("filesample.txt"));
	}

	@Test
	public void testGetFilesInFolderByExtension() {
		String curDir = System.getProperty("user.dir");
		String fileSeparator = System.getProperty("file.separator");

		List<String> files = FileUtil.getFilesInFolderByExtension(curDir + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "files", ".txt", true);
		Assert.assertTrue(files.get(0).contains("filesample.txt"));
	}

}
