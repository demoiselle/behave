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

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;
import br.gov.frameworkdemoiselle.behave.runner.ui.Menu;
import br.gov.frameworkdemoiselle.behave.runner.ui.MenuItem;
import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;
import br.gov.frameworkdemoiselle.behave.runner.ui.Screen;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

/**
 * 
 * @author SERPRO
 * 
 */
public class CommonSteps implements Step {

	protected Runner runner = (Runner) InjectionManager.getInstance().getInstanceDependecy(Runner.class);
	protected DataProvider dataProvider = (DataProvider) InjectionManager.getInstance().getInstanceDependecy(DataProvider.class);
	protected Logger logger = Logger.getLogger(this.toString());
	protected String currentPageName;

	@Given("vou para a tela \"$local\"")
	@Then("vou para a tela \"$local\"")
	@When("vou para a tela \"$local\"")
	public void goToWithName(String local) {
		logger.log(Level.FINE, "Go to screen " + local);
		currentPageName = local;
		String url = ReflectionUtil.getLocation(local);
		runner.navigateTo(url);
	}

	@Given("estou na tela \"$local\"")
	@Then("estou na tela \"$local\"")
	@When("estou na tela \"$local\"")
	public void pageWithName(String local) {
		logger.log(Level.FINE, "Go to screen " + local);
		currentPageName = local;
	}

	@When(value = "clico em \"$elementName\" referente a \"$locatorParameters\"", priority = 10)
	@Then(value = "clico em \"$elementName\" referente a \"$locatorParameters\"", priority = 10)
	public void clickButtonWithParameters(String elementName, List<String> locatorParameters) {
		Button element = (Button) runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);
		element.click();
	}

	@When(value = "clico em \"$elementName\"", priority = 1)
	@Then(value = "clico em \"$elementName\"", priority = 1)
	public void clickButton(String elementName) {
		Element element = runner.getElement(currentPageName, elementName);

		if (element instanceof Button) {
			((Button) element).click();
		} else if (element instanceof Link) {
			((Link) element).click();
		} else if (element instanceof Menu) {
			((Menu) element).click();
		} else if (element instanceof MenuItem) {
			((MenuItem) element).click();
		} else {
			throw new BehaveException("Tipo de elemento [" + element.getClass().getName() + "] inválido");
		}
	}

	@When(value = "seleciono a opção \"$value\"", priority = 1)
	@Then(value = "seleciono a opção \"$value\"", priority = 1)
	public void informe(String fieldName) {
		Element element = runner.getElement(currentPageName, fieldName);

		if (element instanceof Radio) {
			((Radio) element).click();
		} else if (element instanceof CheckBox) {
			((CheckBox) element).click();
		} else if (element instanceof Link) {
			((Link) element).click();
		} else {
			throw new BehaveException("Tipo de elemento [" + element.getClass().getName() + "] inválido");
		}
	}

	@When(value = "seleciono a opcao de indice \"$indice\" no campo \"$fieldName\"", priority = 10)
	@Then(value = "seleciono a opcao de indice \"$indice\" no campo \"$fieldName\"", priority = 10)
	public void selecionaIndice(String indice, String fieldName) {
		Element element = runner.getElement(currentPageName, fieldName);
		if (element instanceof Select) {
			((Select) element).selectByIndex(Integer.valueOf(indice));
		} else {
			throw new BehaveException("Tipo de elemento [" + element.getClass().getName() + "] inválido");
		}
	}

	@When("informo \"$value\" no campo \"$fieldName\"")
	@Then("informo \"$value\" no campo \"$fieldName\"")
	public void informe(String value, String fieldName) {
		// Verifica se o valor esta no DataContainer
		value = dataProvider.containsKey(value) ? (String) dataProvider.get(value) : value;

		Element element = (Element) runner.getElement(currentPageName, fieldName);

		if (element instanceof TextField) {
			TextField textField = (TextField) element;
			textField.clear();
			textField.sendKeys(value);
		} else if (element instanceof Select) {
			((Select) element).selectByVisibleText(value);
		} else {
			throw new BehaveException("Elemento não encontrado na tela");
		}
	}

	@Then("será exibido \"$text\"")
	public void textVisible(String text) {
		Screen element = (Screen) runner.getScreen();
		element.waitText(text);
	}

	@Then("será exibido na \"$elementName\" o valor \"$text\"")
	@Alias("será exibido no \"$elementName\" o valor \"$text\"")
	public void textVisibleInElement(String elementName, String text) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		if (!element.getText().contains(text)) {
			throw new BehaveException("O texto [" + text + "] não foi encontrado no elemento [" + elementName + "]");
		}
	}

	@When("obtenho \"$var\" do campo \"$fieldName\"")
	@Given("obtenho \"$var\" do campo \"$fieldName\"")
	@Then("obtenho \"$var\" do campo \"$fieldName\"")
	public void getValue(String var, String fieldName) {
		Element element = (Element) runner.getElement(currentPageName, fieldName);
		if (element instanceof TextField) {
			TextField textField = (TextField) element;
			String value = textField.getText();
			dataProvider.put(var, value);
		} else {
			throw new BehaveException("Operação não suporta para o elemento [" + fieldName + "]");
		}
	}

	@When("informo \"$key\" com valor \"$fieldName\"")
	@Given("informo \"$key\" com valor \"$fieldName\"")
	@Then("informo \"$key\" com valor \"$fieldName\"")
	public void setDataProvider(String key, String value) {
		dataProvider.put(key, value);
	}

	@When("movo o mouse sobre \"$element\"")
	public void moverMouse(String elementName) {
		Element element = runner.getElement(currentPageName, elementName);

		if (element instanceof Menu) {
			((Menu) element).mouseOver();
		} else if (element instanceof MenuItem) {
			((MenuItem) element).mouseOver();
		}
	}

}
