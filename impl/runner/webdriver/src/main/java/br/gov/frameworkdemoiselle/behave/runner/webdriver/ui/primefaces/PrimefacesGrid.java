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
package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.primefaces;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

import br.gov.frameworkdemoiselle.behave.runner.ui.Element;
import br.gov.frameworkdemoiselle.behave.runner.ui.Grid;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

public class PrimefacesGrid extends WebBase implements Grid {

	@Override
	public void clickRow(String reference) {

	}

	private String preparaXPath(Element element, String l, String c) {
		String[] xpathElemento = (element.getElementMap().locator());
		String xpathTabela = xpathElemento[0].toString();
		xpathTabela = xpathTabela.concat("[" + l + "]/td[" + c + "]");
		return xpathTabela;
	}

	@Override
	public String findTextInTable(Element element, String l, String c) {
		String xpathTabela = preparaXPath(element, l, c);
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
		String str = "";
		try {
			str = myElement.getText();
		} catch (Exception ex) {
		}
		if (str == null || str.isEmpty()) {
			xpathTabela = xpathTabela.concat("//input[@type='text']");
			myElement = ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
			str = myElement.getAttribute("value");
		}
		return str;
	}

	@Override
	public String findLastLine(Element tabela) {
		return "last()";
	}

	@Override
	public void tableButtonClick(Element element, String l, String c) {
		String xpathTabela = preparaXPath(element, l, c);
		String xpathTabelaBase = xpathTabela;
		xpathTabela = xpathTabela.concat("//button[@type='submit' or @type='button']");
		xpathTabela = xpathTabela.concat("|");
		xpathTabela = xpathTabela.concat(xpathTabelaBase);
		xpathTabela = xpathTabela.concat("//input[@type='checkbox']");
		xpathTabela = xpathTabela.concat("|");
		xpathTabela = xpathTabela.concat(xpathTabelaBase);
		xpathTabela = xpathTabela.concat("//div[@class='ui-row-toggler']");
		xpathTabela = xpathTabela.concat("|");
		xpathTabela = xpathTabela.concat(xpathTabelaBase);
		xpathTabela = xpathTabela.concat("//a");
		xpathTabela = xpathTabela.concat("|(");
		xpathTabela = xpathTabela.concat(xpathTabelaBase);
		xpathTabela = xpathTabela.concat(")");
		xpathTabela = xpathTabela.concat("/div/div[2]");

		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
		myElement.click();
	}

	@Override
	public void tableSelectClick(String value, String l, String c, Element element) {
		String xpathTabela = preparaXPath(element, l, c);
		xpathTabela = xpathTabela.concat("//label");
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
		String selectId = myElement.getAttribute("id");
		selectId = selectId.substring(0, selectId.length() - 6);
		myElement.click();

		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement myElement2 = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath("//div[@id='" + selectId.toString() + "_panel']/div/ul/li[text()='" + value + "']"));
		myElement2.click();
	}

	@Override
	public void tableTextSendKeys(String value, String l, String c, Element element) {
		String xpathTabela = preparaXPath(element, l, c);
		String xpathTabelaBase = xpathTabela;
		xpathTabela = xpathTabela.concat("//textarea");
		xpathTabela = xpathTabela.concat("|");
		xpathTabela = xpathTabela.concat(xpathTabelaBase);
		xpathTabela = xpathTabela.concat("//input[@type='text']");
		WebElement myElement = (WebElement) ((WebDriver) runner.getDriver()).findElement(By.xpath(xpathTabela));
		myElement.clear();
		myElement.sendKeys(value);
	}

}