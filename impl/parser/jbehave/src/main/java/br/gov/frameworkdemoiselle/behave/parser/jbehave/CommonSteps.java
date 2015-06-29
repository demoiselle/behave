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

import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.dataprovider.DatasetProvider;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.DataProviderUtil;
import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.AutoComplete;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Calendar;
import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Link;
import br.gov.frameworkdemoiselle.behave.runner.ui.Menu;
import br.gov.frameworkdemoiselle.behave.runner.ui.MenuItem;
import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;
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
	protected DatasetProvider datasetProvider = (DatasetProvider) InjectionManager.getInstance().getInstanceDependecy(DatasetProvider.class);
	private Logger logger = Logger.getLogger(CommonSteps.class);
	protected static String currentPageName;
	protected static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);

	@Given("vou para a tela \"$local\"")
	@Then("vou para a tela \"$local\"")
	@When("vou para a tela \"$local\"")
	public void goToWithName(String local) {
		logger.debug("Go to screen " + local);
		currentPageName = local;
		String url = ReflectionUtil.getLocation(local);
		runner.navigateTo(url);
	}

	@Given("estou na tela \"$local\"")
	@Then("estou na tela \"$local\"")
	@When("estou na tela \"$local\"")
	public void pageWithName(String local) {
		logger.debug("Setting screen " + local);
		currentPageName = local;
		runner.setScreen(local);
	}

	@When(value = "clico em \"$elementName\" referente a \"$locatorParameters\"", priority = 10)
	@Then(value = "clico em \"$elementName\" referente a \"$locatorParameters\"", priority = 10)
	public void clickButtonWithParameters(String elementName, List<String> locatorParameters) {
		locatorParameters = DataProviderUtil.replaceDataProvider(locatorParameters);
		Element element = runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);
		if (element instanceof Button) {
			((Button) element).click();
		} else if (element instanceof Link) {
			((Link) element).click();
		} else if (element instanceof Menu) {
			((Menu) element).click();
		} else if (element instanceof MenuItem) {
			((MenuItem) element).click();
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
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
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When(value = "seleciono a op\u00E7\u00E3o \"$elementName\" referente a \"$locatorParameters\"", priority = 10)
	@Then(value = "seleciono a op\u00E7\u00E3o \"$elementName\" referente a \"$locatorParameters\"", priority = 10)
	public void informWithParameters(String elementName, List<String> locatorParameters) {
		locatorParameters = DataProviderUtil.replaceDataProvider(locatorParameters);
		Element element = runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);
		if (element instanceof Radio) {
			((Radio) element).click();
		} else if (element instanceof CheckBox) {
			((CheckBox) element).click();
		} else if (element instanceof Link) {
			((Link) element).click();
		} else if (element instanceof Calendar) {
			((Calendar) element).click();
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When(value = "seleciono a op\u00E7\u00E3o \"$fieldName\"", priority = 1)
	@Then(value = "seleciono a op\u00E7\u00E3o \"$fieldName\"", priority = 1)
	public void inform(String fieldName) {
		Element element = runner.getElement(currentPageName, fieldName);
		if (element instanceof Radio) {
			((Radio) element).click();
		} else if (element instanceof CheckBox) {
			((CheckBox) element).click();
		} else if (element instanceof Link) {
			((Link) element).click();
		} else if (element instanceof Calendar) {
			((Calendar) element).click();
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When(value = "seleciono a op\u00E7\u00E3o de \u00EDndice \"$indice\" no campo \"$fieldName\"", priority = 10)
	@Then(value = "seleciono a op\u00E7\u00E3o de \u00EDndice \"$indice\" no campo \"$fieldName\"", priority = 10)
	public void selectByIndex(String indice, String fieldName) {
		indice = DataProviderUtil.replaceValue(indice);
		Element element = runner.getElement(currentPageName, fieldName);
		if (element instanceof Select) {
			((Select) element).selectByIndex(Integer.valueOf(indice));
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When(value = "seleciono a op\u00E7\u00E3o de valor \"$value\" no campo \"$fieldName\"", priority = 20)
	@Then(value = "seleciono a op\u00E7\u00E3o de valor \"$value\" no campo \"$fieldName\"", priority = 20)
	public void selectByValue(String value, String fieldName) {
		value = DataProviderUtil.replaceValue(value);
		Element element = runner.getElement(currentPageName, fieldName);
		if (element instanceof Select) {
			((Select) element).selectByValue(value);
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When(value = "informo \"$value\" no campo \"$fieldName\"", priority = 1)
	@Then(value = "informo \"$value\" no campo \"$fieldName\"", priority = 1)
	public void inform(String value, String fieldName) {
		value = DataProviderUtil.replaceValue(value);
		Element element = (Element) runner.getElement(currentPageName, fieldName);
		if (element instanceof TextField) {
			TextField textField = (TextField) element;
			textField.sendKeysWithTries(value);
		} else if (element instanceof Select) {
			((Select) element).selectByVisibleText(value);
		} else if (element instanceof AutoComplete) {
			((AutoComplete) element).selectByValue(value);
		} else {
			throw new BehaveException(message.getString("exception-element-not-found"));
		}
	}

	/**
	 * Sobrecarga do método inform sobrescrito do CommonSteps, para levar em
	 * consideração elementos do tipo AutoComplete, que necessitem buscar por um
	 * valor no campo de texto, e selecionar um outro valor na lista de opções
	 * 
	 * @author Michel Felipe<michel.ferreira@serpro.gov.br>
	 * @param String
	 *            value Valor a ser informado
	 * @param String
	 *            selectValue Valor a ser procurado na lista de resultados
	 * @param String
	 *            fieldName Nome do campo
	 */
	@When(value = "informo \"$value\" e seleciono \"$selectValue\" no campo \"$fieldName\"", priority = 10)
	@Then(value = "informo \"$value\" e seleciono \"$selectValue\" no campo \"$fieldName\"", priority = 10)
	public void inform(String value, String selectValue, String fieldName) {
		value = DataProviderUtil.replaceValue(value);
		Element element = (Element) runner.getElement(currentPageName, fieldName);
		if (element instanceof AutoComplete) {
			((AutoComplete) element).searchAndSelectValue(value, selectValue);
		} else {
			this.inform(value, fieldName);
		}
	}

	@When("limpo o valor do campo \"$fieldName\"")
	@Alias("n\u00E3o informo valor para o campo \"$fieldName\"")
	public void notInform(String fieldName) {
		Element element = (Element) runner.getElement(currentPageName, fieldName);
		if (element instanceof TextField) {
			TextField textField = (TextField) element;
			textField.clear();
		} else {
			throw new BehaveException(message.getString("exception-element-not-found"));
		}
	}

	@Then("ser\u00E1 exibido \"$text\"")
	public void textVisible(String text) {
		Element element = (Element) runner.getScreen();
		text = DataProviderUtil.replaceValue(text);
		element.waitText(text);
	}
	
	@Then("n\u00E3o ser\u00E1 exibido \"$text\"")
	public void textNotVisible(String text) {
		Element element = (Element) runner.getScreen();
		text = DataProviderUtil.replaceValue(text);
		element.waitNotText(text);
	}

	@Then("ser\u00E1 exibido na \"$elementName\" o valor \"$text\"")
	@Alias("ser\u00E1 exibido no \"$elementName\" o valor \"$text\"")
	public void textVisibleInElement(String elementName, String text) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		text = DataProviderUtil.replaceValue(text);
		element.waitTextInElement(text);
	}
	
	@Then("n\u00E3o ser\u00E1 exibido na \"$elementName\" o valor \"$text\"")
	@Alias("n\u00E3o ser\u00E1 exibido no \"$elementName\" o valor \"$text\"")
	public void textNotVisibleInElement(String elementName, String text) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		text = DataProviderUtil.replaceValue(text);
		element.waitTextNotInElement(text);
	}

	@Then("ser\u00E1 exibido o valor \"$text\" em \"$elementName\" referente a \"$locatorParameters\"")
	public void textVisibleInElementWithParameters(String text, String elementName, List<String> locatorParameters) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);

		text = DataProviderUtil.replaceValue(text);
		element.waitTextInElement(text);
	}
	
	@Then("n\u00E3o ser\u00E1 exibido o valor \"$text\" em \"$elementName\" referente a \"$locatorParameters\"")
	public void textNotVisibleInElementWithParameters(String text, String elementName, List<String> locatorParameters) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);

		text = DataProviderUtil.replaceValue(text);
		element.waitTextNotInElement(text);
	}

	@Given(value="\"$elementName\" n\u00E3o est\u00E1 vis\u00EDvel", priority=10)
	@When(value="\"$elementName\" n\u00E3o est\u00E1 vis\u00EDvel", priority=10)
	@Then(value="\"$elementName\" n\u00E3o est\u00E1 vis\u00EDvel", priority=10)
	public void elementNotVisible(String elementName) {
		Element element = runner.getElement(currentPageName, elementName);
		element.waitInvisible();
	}
	
	@Given(value="\"$elementName\" referente a \"$locatorParameters\" n\u00E3o est\u00E1 vis\u00EDvel", priority=11)
	@When(value="\"$elementName\" referente a \"$locatorParameters\" n\u00E3o est\u00E1 vis\u00EDvel", priority=11)
	@Then(value="\"$elementName\" referente a \"$locatorParameters\" n\u00E3o est\u00E1 vis\u00EDvel", priority=11)
	public void elementWithParametersNotVisible(String elementName, List<String> locatorParameters) {
		Element element = runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);		
		element.waitInvisible();
	}
	
	@Given(value="aguardo o elemento \"$fieldName\" estar vis\u00EDvel, clic\u00E1vel e habilitado", priority=10)
	@When(value="aguardo o elemento \"$fieldName\" estar vis\u00EDvel, clic\u00E1vel e habilitado", priority=10)
	@Then(value="aguardo o elemento \"$fieldName\" estar vis\u00EDvel, clic\u00E1vel e habilitado", priority=10)
	public void elementVisibleClicableEnable(String fieldName) {
		Element element = runner.getElement(currentPageName, fieldName);
		element.waitVisibleClickableEnabled();
	}
	
	@Given(value="aguardo o elemento \"$fieldName\" referente a \"$locatorParameters\" estar vis\u00EDvel, clic\u00E1vel e habilitado", priority=11)
	@When(value="aguardo o elemento \"$fieldName\" referente a \"$locatorParameters\" estar vis\u00EDvel, clic\u00E1vel e habilitado", priority=11)
	@Then(value="aguardo o elemento \"$fieldName\" referente a \"$locatorParameters\" estar vis\u00EDvel, clic\u00E1vel e habilitado", priority=11)
	public void elementWithParametersVisibleClicableEnable(String fieldName, List<String> locatorParameters) {
		Element element = runner.getElement(currentPageName, fieldName);
		element.setLocatorParameters(locatorParameters);
		element.waitVisibleClickableEnabled();
	}

	@Given(value="o elemento \"$fieldName\" est\u00E1 vis\u00EDvel e desabilitado", priority=10)
	@When(value="o elemento \"$fieldName\" est\u00E1 vis\u00EDvel e desabilitado", priority=10)
	@Then(value="o elemento \"$fieldName\" est\u00E1 vis\u00EDvel e desabilitado", priority=10)
	public void elementVisibleDisable(String fieldName) {
		Element element = runner.getElement(currentPageName, fieldName);
		element.isVisibleDisabled();
	}

	@Given(value="o elemento \"$fieldName\" referente a \"$locatorParameters\" est\u00E1 vis\u00EDvel e desabilitado", priority=11)
	@When(value="o elemento \"$fieldName\" referente a \"$locatorParameters\" est\u00E1 vis\u00EDvel e desabilitado", priority=11)
	@Then(value="o elemento \"$fieldName\" referente a \"$locatorParameters\" est\u00E1 vis\u00EDvel e desabilitado", priority=11)
	public void elementWithParametersVisibleDisable(String fieldName, List<String> locatorParameters) {
		Element element = runner.getElement(currentPageName, fieldName);
		element.setLocatorParameters(locatorParameters);
		element.isVisibleDisabled();
	}
	
}
