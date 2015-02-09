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
package demoisellebehave.sample.google.regression.test;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.controller.BehaveContext;
import br.gov.frameworkdemoiselle.behave.regression.RegressionConfig;
import br.gov.frameworkdemoiselle.behave.regression.step.RegressionSteps;
import demoisellebehave.sample.google.regression.test.steps.MySteps;

public class RegressionTest {

	private BehaveContext eng;
	private static Logger logger = Logger.getLogger(RegressionTest.class);

	public RegressionTest() {
		eng = BehaveContext.getInstance();
	}

	@BeforeClass
	public static void setup() {
		logger.info("========================================================");
		logger.info("      Iniciando Teste de Regressão de Layout");
		logger.info("========================================================");
	}

	@Test
	public void testBDD() throws Throwable {
		// Navegadores
		for (String browser : RegressionConfig.getTypes()) {

			RegressionConfig.setCurrentType(browser);

			eng.addStoriesReuse("/stories/acesso.story");

			eng.addStories("/stories/pesquisa-simples.story");

			eng.addSteps(new MySteps());
			eng.addSteps(new RegressionSteps());

			eng.run();
		}
	}

}
