package br.gov.frameworkdemoiselle.behave.parser.internal.parse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
import br.gov.frameworkdemoiselle.behave.internal.parse.StoryFileConverter;
import br.gov.frameworkdemoiselle.behave.util.FileUtil;


public class StoryFileConverterTest {
	
		//TODO Testar no windows para ver se o link break funciona com sucesso

		private static final String LANGUAGE = BehaveConfig.LANGUAGE;

		private static final String DEFAULT_RESOURCE_PATH = "target/test-classes/parser/test/"+LANGUAGE+"/";

		private static final String ACCESS_FILE_NAME = "acesso-sistema";
		private static final String ORDER_FILE_NAME = "pedido";
		
		private static final String ORIGIN_EXTENSION = ".bdd";
		private static final String DESTINATION_EXTENSION = ".story";
		
		private static final String EXPEDTED_FILE_PREFIX = "expected-";

		private static final String ACCESS_BASE_FILE_NAME = DEFAULT_RESOURCE_PATH + ACCESS_FILE_NAME;
		private static final String ORDER_BASE_FILE_NAME = DEFAULT_RESOURCE_PATH + ORDER_FILE_NAME;
		
		private static final String ACCESS_STORY_FILE_PATH = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ACCESS_FILE_NAME + ".story";
		private static final String ORDER_STORY_FILE_PATH = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ORDER_FILE_NAME + ".story";

		private static final Boolean INCLUDE_SUBDIRECTORY = true;
		
		@Test
		public void convertUsedScenariosOriginFiles() throws IOException{
			List<String> originBaseFilesName = new ArrayList<String>();
			originBaseFilesName.add(ACCESS_BASE_FILE_NAME);
			originBaseFilesName.add(ORDER_BASE_FILE_NAME);
			StoryFileConverter.convertReusedScenarios(originBaseFilesName,ORIGIN_EXTENSION,DESTINATION_EXTENSION);
			verifyConvertedFiles();
		}

		@Test
		public void convertUsedScenariosOriginFolder() throws IOException{
			StoryFileConverter.convertReusedScenarios(DEFAULT_RESOURCE_PATH,ORIGIN_EXTENSION,DESTINATION_EXTENSION,INCLUDE_SUBDIRECTORY);
			verifyConvertedFiles();
		}

		private void verifyConvertedFiles() throws IOException {
			Map<String,String> convertedStories = new HashMap<String,String>();
			convertedStories.put(ACCESS_BASE_FILE_NAME, FileUtil.loadFile(ACCESS_BASE_FILE_NAME+DESTINATION_EXTENSION));
			convertedStories.put(ORDER_BASE_FILE_NAME, FileUtil.loadFile(ORDER_BASE_FILE_NAME+DESTINATION_EXTENSION));
			Map<String,String> expectedConvertedStories = new HashMap<String,String>();
			expectedConvertedStories.put(ACCESS_BASE_FILE_NAME, FileUtil.loadFile(ACCESS_STORY_FILE_PATH));
			expectedConvertedStories.put(ORDER_BASE_FILE_NAME, FileUtil.loadFile(ORDER_STORY_FILE_PATH));
			//Para comparar os maps, lembrar que o nome de arquivo no map (key) deve ser igual, por isso não são utilizadas as extensão (.bdd e .story) no arquivo 
			Assert.assertEquals(expectedConvertedStories, convertedStories);
		}
		
	}