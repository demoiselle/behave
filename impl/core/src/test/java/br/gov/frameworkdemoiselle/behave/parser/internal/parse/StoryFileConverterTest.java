//package br.gov.frameworkdemoiselle.behave.parser.internal.parse;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.TreeMap;
//
//import junit.framework.Assert;
//
//import org.junit.Test;
//
//import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
//import br.gov.frameworkdemoiselle.behave.internal.parse.StoryFileConverter;
//import br.gov.frameworkdemoiselle.behave.util.FileUtil;
//
//public class StoryFileConverterTest {
//
//	// TODO Testar no windows para ver se o link break funciona com sucesso
//
//	private static final String LANGUAGE = BehaveConfig.LANGUAGE;
//
//	private static final String DEFAULT_RESOURCE_PATH = "target/test-classes/parser/test/" + LANGUAGE + "/";
//
//	// private static final Boolean INCLUDE_SUBDIRECTORY = true;
//
//	private static final String ACCESS = "acesso-sistema.";
//	private static final String ORDER = "pedido.";
//
//	private static final String ORIGIN_EXTENSION = "bdd";
//	private static final String DESTINATION_EXTENSION = "story";
//
//	private static final String ACCESS_FILE_NAME_ORIG = DEFAULT_RESOURCE_PATH + ACCESS + ORIGIN_EXTENSION;
//	private static final String ORDER_FILE_NAME_ORIG = DEFAULT_RESOURCE_PATH + ORDER + ORIGIN_EXTENSION;
//
//	private static final String ACCESS_FILE_NAME_CONV = DEFAULT_RESOURCE_PATH + ACCESS + DESTINATION_EXTENSION;
//	private static final String ORDER_FILE_NAME_CONV = DEFAULT_RESOURCE_PATH + ORDER + DESTINATION_EXTENSION;
//
//	private static final String EXPEDTED_FILE_PREFIX = "expected-";
//	private static final String ACCESS_FILE_NAME_EXP = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ACCESS + DESTINATION_EXTENSION;
//	private static final String ORDER_FILE_NAME_EXPV = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ORDER + DESTINATION_EXTENSION;
//
//	@Test
//	public void convertUsedScenariosOriginFiles() throws IOException {
//		List<String> originBaseFilesName = new ArrayList<String>();
//		originBaseFilesName.add(ACCESS_FILE_NAME_ORIG);
//		originBaseFilesName.add(ORDER_FILE_NAME_ORIG);
//		StoryFileConverter.convertReusedScenarios(originBaseFilesName, ORIGIN_EXTENSION, DESTINATION_EXTENSION);
//		verifyConvertedFiles();
//	}
//
//	// @Test
//	// public void convertUsedScenariosOriginFolder() throws IOException {
//	// StoryFileConverter.convertReusedScenarios(DEFAULT_RESOURCE_PATH,
//	// ORIGIN_EXTENSION, DESTINATION_EXTENSION, INCLUDE_SUBDIRECTORY);
//	// verifyConvertedFiles();
//	// }
//
//	private void verifyConvertedFiles() throws IOException {
//
//		TreeMap<String, String> convertedStories = new TreeMap<String, String>();
//		convertedStories.put(ACCESS_FILE_NAME_CONV, FileUtil.loadFile(ACCESS_FILE_NAME_CONV));
//		convertedStories.put(ORDER_FILE_NAME_CONV, FileUtil.loadFile(ORDER_FILE_NAME_CONV));
//
//		TreeMap<String, String> expectedConvertedStories = new TreeMap<String, String>();
//		expectedConvertedStories.put(ACCESS_FILE_NAME_CONV, FileUtil.loadFile(ACCESS_FILE_NAME_EXP));
//		expectedConvertedStories.put(ORDER_FILE_NAME_CONV, FileUtil.loadFile(ORDER_FILE_NAME_EXPV));
//
//		// Para comparar os maps, lembrar que o nome de arquivo no map (key)
//		// deve ser igual, por isso não são utilizadas as extensão (.bdd e
//		// .story) no arquivo
//
//		System.out.println("---");
//		System.out.println(convertedStories);
//		System.out.println("---");
//		System.out.println(expectedConvertedStories);
//		System.out.println("---");
//
//		Assert.assertEquals(expectedConvertedStories, convertedStories);
//	}
//
//}