///*
// * Demoiselle Framework
// * Copyright (C) 2013 SERPRO
// * ----------------------------------------------------------------------------
// * This file is part of Demoiselle Framework.
// * 
// * Demoiselle Framework is free software; you can redistribute it and/or
// * modify it under the terms of the GNU Lesser General Public License version 3
// * as published by the Free Software Foundation.
// * 
// * This program is distributed in the hope that it will be useful,
// * but WITHOUT ANY WARRANTY; without even the implied warranty of
// * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// * GNU General Public License for more details.
// * 
// * You should have received a copy of the GNU Lesser General Public License version 3
// * along with this program; if not,  see <http://www.gnu.org/licenses/>
// * or write to the Free Software Foundation, Inc., 51 Franklin Street,
// * Fifth Floor, Boston, MA  02110-1301, USA.
// * ----------------------------------------------------------------------------
// * Este arquivo é parte do Framework Demoiselle.
// * 
// * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
// * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
// * do Software Livre (FSF).
// * 
// * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
// * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
// * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
// * para maiores detalhes.
// * 
// * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
// * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
// * ou escreva para a Fundação do Software Livre (FSF) Inc.,
// * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
// */
//package br.gov.frameworkdemoiselle.behave.parser.internal.parse;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import junit.framework.Assert;
//
//import org.junit.Test;
//
//import br.gov.frameworkdemoiselle.behave.config.BehaveConfig;
//import br.gov.frameworkdemoiselle.behave.internal.parse.StoryConverter;
//import br.gov.frameworkdemoiselle.behave.util.FileUtil;
///**
// * 
// * @author SERPRO
// *
// */
//public class StoryConverterTest {
//  //TODO Apos refatoramento do BehaveConfig o testa parou de funcionar
//	// TODO Testar no windows para ver se o link break funciona com sucesso
//
//	private static final String LANGUAGE = BehaveConfig.getLanguage();
//
//	private static final String DEFAULT_RESOURCE_PATH = "target/test-classes/parser/test/" + LANGUAGE + File.separatorChar;
//
//	private static final String ACCESS_FILE_NAME = "acesso-sistema";
//	private static final String ORDER_FILE_NAME = "pedido";
//	private static final String ORDER_FILE_NAME2 = "pedido2";
//
//	private static final String ACCESS_BDD_FILE_PATH = DEFAULT_RESOURCE_PATH + ACCESS_FILE_NAME + ".bdd";
//	private static final String ORDER_BDD_FILE_PATH = DEFAULT_RESOURCE_PATH + ORDER_FILE_NAME + ".bdd";
//	private static final String ORDER_BDD_FILE_PATH2 = DEFAULT_RESOURCE_PATH + ORDER_FILE_NAME2 + ".bdd";
//
//	private static final String EXPEDTED_FILE_PREFIX = "expected-";
//
//	private static final String ACCESS_STORY_FILE_PATH = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ACCESS_FILE_NAME + ".story";
//	private static final String ORDER_STORY_FILE_PATH = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ORDER_FILE_NAME + ".story";
//	private static final String ORDER_STORY_FILE_PATH2 = DEFAULT_RESOURCE_PATH + EXPEDTED_FILE_PREFIX + ORDER_FILE_NAME2 + ".story";
//
//	@Test
//	public void convertUsedScenarios01() throws IOException {
//
//		Map<String, String> originalStories = new HashMap<String, String>();
//		originalStories.put(ACCESS_FILE_NAME, FileUtil.loadFile(ACCESS_BDD_FILE_PATH));
//		originalStories.put(ORDER_FILE_NAME, FileUtil.loadFile(ORDER_BDD_FILE_PATH));
//		originalStories.put(ORDER_FILE_NAME2, FileUtil.loadFile(ORDER_BDD_FILE_PATH2));
//
//		Map<String, String> convertedStories = StoryConverter.convertReusedScenarios(originalStories);
//
//		Map<String, String> expectedConvertedStories = new HashMap<String, String>();
//		expectedConvertedStories.put(ACCESS_FILE_NAME, FileUtil.loadFile(ACCESS_STORY_FILE_PATH));
//		expectedConvertedStories.put(ORDER_FILE_NAME, FileUtil.loadFile(ORDER_STORY_FILE_PATH));
//		expectedConvertedStories.put(ORDER_FILE_NAME2, FileUtil.loadFile(ORDER_STORY_FILE_PATH2));
//
//		System.out.println(expectedConvertedStories);
//		System.out.println(convertedStories);
//
//		// Para comparar os maps, lembrar que o nome de arquivo no map (key)
//		// deve ser igual, por isso não são utilizadas as extensão (.bdd e
//		// .story) no arquivo
//		Assert.assertEquals(expectedConvertedStories, convertedStories);
//
//	}
//
//}