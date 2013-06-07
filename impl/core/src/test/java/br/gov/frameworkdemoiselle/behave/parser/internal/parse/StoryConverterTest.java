package br.gov.frameworkdemoiselle.behave.parser.internal.parse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.parse.StoryConverter;
import br.gov.frameworkdemoiselle.behave.util.FileUtil;

public class StoryConverterTest {

	// TODO Testar no windows para ver se o link break funciona com sucesso

	private static final String LANGUAGE = BehaveConfig.getLanguage();

	private static final String DEFAULT_RESOURCE_PATH = "target/test-classes/parser/test/" + LANGUAGE + File.separatorChar;

	private static final String ACCESS_FILE_NAME = "acesso-sistema";
	private static final String ORDER_FILE_NAME = "pedido";
	private static final String ORDER_FILE_NAME2 = "pedido2";

	private static final String ACCESS_BDD_FILE_PATH = DEFAULT_RESOURCE_PATH + ACCESS_FILE_NAME + ".bdd";
	private static final String ORDER_BDD_FILE_PATH = DEFAULT_RESOURCE_PATH + ORDER_FILE_NAME + ".bdd";
	private static final String ORDER_BDD_FILE_PATH2 = DEFAULT_RESOURCE_PATH + ORDER_FILE_NAME2 + ".bdd";

	private static final String EXPEDTED_FILE_PREFIX = "expected-";

	private static final String ACCESS_STORY_FILE_PATH = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ACCESS_FILE_NAME + ".story";
	private static final String ORDER_STORY_FILE_PATH = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ORDER_FILE_NAME + ".story";
	private static final String ORDER_STORY_FILE_PATH2 = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ORDER_FILE_NAME2 + ".story";

	@Test
	public void convertUsedScenarios01() throws IOException {

		Map<String, String> originalStories = new HashMap<String, String>();
		originalStories.put(ACCESS_FILE_NAME, FileUtil.loadFile(ACCESS_BDD_FILE_PATH));
		originalStories.put(ORDER_FILE_NAME, FileUtil.loadFile(ORDER_BDD_FILE_PATH));
		originalStories.put(ORDER_FILE_NAME2, FileUtil.loadFile(ORDER_BDD_FILE_PATH2));

		Map<String, String> convertedStories = StoryConverter.convertReusedScenarios(originalStories);

		Map<String, String> expectedConvertedStories = new HashMap<String, String>();
		expectedConvertedStories.put(ACCESS_FILE_NAME, FileUtil.loadFile(ACCESS_STORY_FILE_PATH));
		expectedConvertedStories.put(ORDER_FILE_NAME, FileUtil.loadFile(ORDER_STORY_FILE_PATH));
		expectedConvertedStories.put(ORDER_FILE_NAME2, FileUtil.loadFile(ORDER_STORY_FILE_PATH2));

		System.out.println(expectedConvertedStories);
		System.out.println(convertedStories);

		// Para comparar os maps, lembrar que o nome de arquivo no map (key)
		// deve ser igual, por isso não são utilizadas as extensão (.bdd e
		// .story) no arquivo
		Assert.assertEquals(expectedConvertedStories, convertedStories);

	}

}