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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import br.gov.frameworkdemoiselle.behave.dataprovider.DataProvider;
import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.DataProviderUtil;
import br.gov.frameworkdemoiselle.behave.internal.util.ReflectionUtil;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Calendar;
import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Dialog;
import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Grid;
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
	private Logger logger = Logger.getLogger(CommonSteps.class);
	protected static String currentPageName;
	private static BehaveMessage message = new BehaveMessage(JBehaveParser.MESSAGEBUNDLE);

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
		logger.debug("Go to screen " + local);
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
		Element element = runner.getElement(currentPageName, fieldName);
		if (element instanceof Select) {
			((Select) element).selectByValue(value);
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When("informo \"$value\" no campo \"$fieldName\"")
	@Then("informo \"$value\" no campo \"$fieldName\"")
	public void inform(String value, String fieldName) {
		value = DataProviderUtil.replaceValue(value);
		Element element = (Element) runner.getElement(currentPageName, fieldName);
		if (element instanceof TextField) {
			TextField textField = (TextField) element;
			textField.clear();
			textField.sendKeys(value);
		} else if (element instanceof Select) {
			((Select) element).selectByVisibleText(value);
		} else {
			throw new BehaveException(message.getString("exception-element-not-found"));
		}
	}

	@When("informo: $table")
	@Given("informo: $table")
	public void setDataProvideTable(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			Iterator<String> it = row.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();

				setDataProvider(key, row.get(key));
			}
		}
	}

	@When("informo o campo: $table")
	@Alias("informo os campos: $table")
	public void informFields(ExamplesTable table) {
		for (Map<String, String> row : table.getRows()) {
			Iterator<String> it = row.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				inform(row.get(key), key);
			}
		}
	}

	@Then("ser\u00E1 exibido \"$text\"")
	public void textVisible(String text) {
		Element element = (Element) runner.getScreen();
		element.waitText(text);
	}

	@Then("ser\u00E1 exibido na \"$elementName\" o valor \"$text\"")
	@Alias("ser\u00E1 exibido no \"$elementName\" o valor \"$text\"")
	public void textVisibleInElement(String elementName, String text) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		element.waitTextInElement(text);
	}

	@Then("ser\u00E1 exibido o valor \"$text\" em \"$elementName\" referente a \"$locatorParameters\"")
	public void textVisibleInElementWithParameters(String text, String elementName, List<String> locatorParameters) {
		Element element = (Element) runner.getElement(currentPageName, elementName);
		element.setLocatorParameters(locatorParameters);

		if (!element.getText().contains(text)) {
			throw new BehaveException(message.getString("exception-text-not-found", elementName));
		}
	}

	@Given("\"$elementName\" n\u00E3o est\u00E1 vis\u00EDvel")
	@When("\"$elementName\" n\u00E3o est\u00E1 vis\u00EDvel")
	@Then("\"$elementName\" n\u00E3o est\u00E1 vis\u00EDvel")
	public void elementNotVisible(String elementName) {
		Element element = runner.getElement(currentPageName, elementName);
		element.waitInvisible();
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
			throw new BehaveException(message.getString("exception-invalid-operation", fieldName));
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
		} else if (element instanceof Button) {
			((Button) element).mouseOver();
		}
	}

	@When("clico na linha da tabela \"$table\" referente a \"$reference\"")
	public void clickRowTable(String table, String reference) {
		Element element = runner.getElement(currentPageName, table);
		if (element instanceof Grid) {
			((Grid) element).clickRow(reference);
		} else {
			throw new BehaveException(message.getString("exception-invalid-type", element.getClass().getName()));
		}
	}

	@When("confirmo a caixa de di\u00E1logo")
	@Given("confirmo a caixa de di\u00E1logo")
	@Then("confirmo a caixa de di\u00E1logo")
	public void acceptDialog() {
		Dialog dialog = (Dialog) InjectionManager.getInstance().getInstanceDependecy(Dialog.class);
		dialog.accept();
	}

	@When("cancelo a caixa de di\u00E1logo")
	@Given("cancelo a caixa de di\u00E1logo")
	@Then("cancelo a caixa de di\u00E1logo")
	public void cancelDialog() {
		Dialog dialog = (Dialog) InjectionManager.getInstance().getInstanceDependecy(Dialog.class);
		dialog.cancel();
	}

	@When("informo na caixa de di\u00E1logo \"$value\"")
	@Given("informo na caixa de di\u00E1logo \"$value\"")
	@Then("informo na caixa de di\u00E1logo \"$value\"")
	public void sendKeysDialog(String value) {
		Dialog dialog = (Dialog) InjectionManager.getInstance().getInstanceDependecy(Dialog.class);
		dialog.sendKeys(value);
	}

	@Then("ser\u00E1 exibido na caixa de di\u00E1logo \"$value\"")
	public void getTextDialog(String value) {
		Dialog dialog = (Dialog) InjectionManager.getInstance().getInstanceDependecy(Dialog.class);
		Assert.assertEquals(value.replace("\r\n", "").replace("\n", ""), dialog.getText().replace("\r\n", "").replace("\n", ""));
	}

	@Given("informo um n\u00FAmero randomico com prefixo \"$prefix\" no campo \"$fieldName\"")
	@When("informo um n\u00FAmero randomico com prefixo \"$prefix\" no campo \"$fieldName\"")
	@Then("informo um n\u00FAmero randomico com prefixo \"$prefix\" no campo \"$fieldName\"")
	public void informoUmNumeroRandomicoComDigitoInicial(String prefix, String fieldName) {
		Integer numeroRandomico = (new Random()).nextInt();
		if (numeroRandomico < 0) {
			numeroRandomico = numeroRandomico * (-1);
		}
		String stringNumeroRandomico = Integer.toString(numeroRandomico);
		if (StringUtils.isBlank(prefix)) {
			prefix = "";
		}
		inform(prefix + stringNumeroRandomico, fieldName);
	}

	@When("informo um n\u00FAmero randomico no campo \"$fieldName\"")
	public void informoUmNumeroRandomicoNoCampo(String fieldName) {
		Integer numeroRandomico = (new Random()).nextInt();
		if (numeroRandomico < 0) {
			numeroRandomico = numeroRandomico * (-1);
		}
		String stringNumeroRandomico = Integer.toString(numeroRandomico);
		inform(stringNumeroRandomico, fieldName);
	}

	@Given("defino a variável \"$newVar\" com valor \"$value\"")
	@Then("defino a variável \"$newVar\" com valor \"$value\"")
	@When("defino a variável \"$newVar\" com valor \"$value\"")
	public void defineNewVariable(String newVar, String value) {
		dataProvider.put(newVar, value);
	}

	@When("imprimo no console o valor da variável \"$var\"")
	@Then("imprimo no console o valor da variável \"$var\"")
	public void printVarValueInLog(String var) {
		String value = (String) dataProvider.get(var);
		if (value == null)
			value = "";
		String msg = "\t" + var + " = " + "|" + value + "|";
		logger.info(msg);
	}

}
