package br.gov.frameworkdemoiselle.behave.parser.internal.parse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.parse.StoryConverter;
import br.gov.frameworkdemoiselle.behave.util.FileUtil;

public class StoryConverterTest {

	// TODO Testar no windows para ver se o link break funciona com sucesso

	private static final String LANGUAGE = BehaveConfig.LANGUAGE;

	private static final String DEFAULT_RESOURCE_PATH = "target/test-classes/parser/test/" + LANGUAGE + "/";

	private static final String ACCESS_FILE_PATH = DEFAULT_RESOURCE_PATH + "acesso-sistema";
	private static final String ORDER_FILE_PATH = DEFAULT_RESOURCE_PATH + "pedido";

	private static final String ACCESS_BDD_FILE_PATH = ACCESS_FILE_PATH + ".bdd";
	private static final String ORDER_BDD_FILE_PATH = ORDER_FILE_PATH + ".bdd";

	private static final String ACCESS_FEATURE_FILE_PATH = ACCESS_FILE_PATH + ".feature";
	private static final String ORDER_FEATURE_FILE_PATH = ORDER_FILE_PATH + ".feature";

	@Test
	public void convertUsedScenariosWithoutParameters() throws IOException {

		Map<String, String> originalFeatures = new HashMap<String, String>();
		originalFeatures.put(ACCESS_FILE_PATH, FileUtil.loadFile(ACCESS_BDD_FILE_PATH));
		originalFeatures.put(ORDER_FILE_PATH, FileUtil.loadFile(ORDER_BDD_FILE_PATH));

		Map<String, String> convertedFeatures = StoryConverter.convertReusedScenarios(originalFeatures);

		Map<String, String> expectedConvertedFeatures = new HashMap<String, String>();
		expectedConvertedFeatures.put(ACCESS_FILE_PATH, FileUtil.loadFile(ACCESS_FEATURE_FILE_PATH));
		expectedConvertedFeatures.put(ORDER_FILE_PATH, FileUtil.loadFile(ORDER_FEATURE_FILE_PATH));

		System.out.println(convertedFeatures);
		
		System.out.println("");
		
		System.out.println(expectedConvertedFeatures);

		Assert.assertEquals(expectedConvertedFeatures, convertedFeatures);
	}

}
