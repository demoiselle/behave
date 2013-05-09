package br.gov.frameworkdemoiselle.behave.parser.cucumber.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.parser.cucumber.CucumberConfig;
import br.gov.frameworkdemoiselle.behave.parser.cucumber.FeatureConverter;
import br.gov.frameworkdemoiselle.behave.parser.cucumber.FileUtil;

public class FeatureConverterTest {
	
	//TODO Testar no windows para ver se o link break funciona com sucesso

	private static final String LANGUAGE = CucumberConfig.LANGUAGE;

	private static final String DEFAULT_RESOURCE_PATH = "target/test-classes/br/gov/frameworkdemoiselle/behave/parser/cucumber/test/"+LANGUAGE+"/";

	private static final String ACCESS_FILE_PATH = DEFAULT_RESOURCE_PATH + "acesso-sistema";
	private static final String ORDER_FILE_PATH = DEFAULT_RESOURCE_PATH + "pedido";
	
	private static final String ACCESS_BDD_FILE_PATH = ACCESS_FILE_PATH + ".bdd";
	private static final String ORDER_BDD_FILE_PATH = ORDER_FILE_PATH + ".bdd";
	
	private static final String ACCESS_FEATURE_FILE_PATH = ACCESS_FILE_PATH + ".feature";
	private static final String ORDER_FEATURE_FILE_PATH = ORDER_FILE_PATH + ".feature";

	@Test
	public void convertUsedScenariosWithoutParameters() throws IOException{
		
		Map<String,String> originalFeatures = new HashMap<String,String>();
		originalFeatures.put(ACCESS_FILE_PATH, FileUtil.loadFile(ACCESS_BDD_FILE_PATH));
		originalFeatures.put(ORDER_FILE_PATH, FileUtil.loadFile(ORDER_BDD_FILE_PATH));
		
		Map<String,String> convertedFeatures = FeatureConverter.convertReusedScenarios(originalFeatures);

		Map<String,String> expectedConvertedFeatures = new HashMap<String,String>();
		expectedConvertedFeatures.put(ACCESS_FILE_PATH, FileUtil.loadFile(ACCESS_FEATURE_FILE_PATH));
		expectedConvertedFeatures.put(ORDER_FILE_PATH, FileUtil.loadFile(ORDER_FEATURE_FILE_PATH));
		
		//Saída da string convertida
//		System.out.println(expectedConvertedFeatures);

		//Para comparar os maps, lembrar que o nome de arquivo no map (key) deve ser igual, por isso não são utilizadas as extensão (.bdd e .feature) no arquivo 
		Assert.assertEquals(expectedConvertedFeatures, convertedFeatures);
		
		
	}
	
}
