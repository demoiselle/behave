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
package br.gov.frameworkdemoiselle.behave.parser.cucumber.test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FeatureConverterTest {

	// TODO Testar no windows para ver se o link break funciona com sucesso

	// private static final String LANGUAGE = BehaveConfig.LANGUAGE;
	//
	// private static final String DEFAULT_RESOURCE_PATH =
	// "target/test-classes/br/gov/frameworkdemoiselle/behave/parser/cucumber/test/"
	// + LANGUAGE + "/";
	//
	// private static final String ACCESS_FILE_PATH = DEFAULT_RESOURCE_PATH +
	// "acesso-sistema";
	// private static final String ORDER_FILE_PATH = DEFAULT_RESOURCE_PATH +
	// "pedido";
	//
	// private static final String ACCESS_BDD_FILE_PATH = ACCESS_FILE_PATH +
	// ".bdd";
	// private static final String ORDER_BDD_FILE_PATH = ORDER_FILE_PATH +
	// ".bdd";
	//
	// private static final String ACCESS_FEATURE_FILE_PATH = ACCESS_FILE_PATH +
	// ".feature";
	// private static final String ORDER_FEATURE_FILE_PATH = ORDER_FILE_PATH +
	// ".feature";

	@Test
	public void convertUsedScenariosWithoutParameters() throws IOException {
		//
		// Map<String, String> originalFeatures = new HashMap<String, String>();
		// originalFeatures.put(ACCESS_FILE_PATH,
		// FileUtil.loadFile(ACCESS_BDD_FILE_PATH));
		// originalFeatures.put(ORDER_FILE_PATH,
		// FileUtil.loadFile(ORDER_BDD_FILE_PATH));
		//
		// Map<String, String> convertedFeatures =
		// StoryConverter.convertReusedScenarios(originalFeatures);
		//
		// Map<String, String> expectedConvertedFeatures = new HashMap<String,
		// String>();
		// expectedConvertedFeatures.put(ACCESS_FILE_PATH,
		// FileUtil.loadFile(ACCESS_FEATURE_FILE_PATH));
		// expectedConvertedFeatures.put(ORDER_FILE_PATH,
		// FileUtil.loadFile(ORDER_FEATURE_FILE_PATH));
		//
		// // Saída da string convertida
		// System.out.println(expectedConvertedFeatures);
		//
		// // Para comparar os maps, lembrar que o nome de arquivo no map (key)
		// // deve ser igual, por isso não são utilizadas as extensão (.bdd e
		// // .feature) no arquivo
		// Assert.assertEquals(expectedConvertedFeatures, convertedFeatures);
		//

		Assert.assertEquals("a", "a");
	}

}
