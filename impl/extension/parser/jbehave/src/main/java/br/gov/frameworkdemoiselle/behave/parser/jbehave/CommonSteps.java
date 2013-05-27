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
package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import freemarker.log.Logger;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;
import br.gov.frameworkdemoiselle.behave.runner.ui.base.Element;
import br.gov.frameworkdemoiselle.behave.util.ReflectionUtil;

/**
 * 
 * @author SERPRO
 * 
 */
public class CommonSteps implements Step {

	protected Runner runner = (Runner) InjectionManager.getInstance().getInstanceDependecy(Runner.class);
	protected Logger logger = Logger.getLogger(this.toString());
	protected String currentPageName;

	@Given("vou para a página \"$local\"")
	@Then("vou para a página \"$local\"")
	@When("vou para a página \"$local\"")
	public void goToWithName(String local) {
		logger.info("Go to screen " + local);
		currentPageName = local;
		String url = ReflectionUtil.getLocation(local);
		runner.navigateTo(url);
	}

	@Given("estou na página \"$local\"")
	@Then("estou na página \"$local\"")
	@When("estou na página \"$local\"")
	public void pageWithName(String local) {
		logger.info("Go to screen " + local);
		currentPageName = local;		
	}
	
	@When("clico em \"$elementName\"")
	public void clickButton(String elementName) {
		Button element = (Button) runner.getElement(currentPageName, elementName);
		element.click();
	}

	@When("informo \"$value\" no campo \"$fieldName\"")
	public void informe(String value, String fieldName) {
		Element element = (Element) runner.getElement(currentPageName, fieldName);

		// TODO Fazer o if para os outros elementos
		if (element instanceof TextField) {
			((TextField) element).sendKeys(value);
		} else if (element instanceof Select) {
			((Select) element).selectValue(value);
		} else if (element instanceof Radio){
			
		} else if (element instanceof CheckBox){
			
		} else {
			throw new BehaveException("");
		}

	}

	@Then("será exibido \"$text\"")
	public void textVisible(String text) {
		Screen element = (Screen) runner.getScreen();
		element.waitText(text);
	}

}
