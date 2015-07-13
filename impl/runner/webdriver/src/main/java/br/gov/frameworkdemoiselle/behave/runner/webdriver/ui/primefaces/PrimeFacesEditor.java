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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebTextField;

public class PrimeFacesEditor extends WebTextField {

	public void sendKeys(CharSequence... keysToSend) {
		String[] id =  getElementMap().locator();
		
		String str;
		
		str = id[0].toString();
		
		String value = charSequenceToString(keysToSend);
		
		WebDriver wd = super.getDriver();
		
		WebElement frame = wd.findElement(By.xpath(str));
		wd.switchTo().frame(frame);
		
	
		JavascriptExecutor js = null;
		if (wd instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)wd;
		}
		WebElement editorBody = wd.findElement(By.cssSelector("body"));
		js.executeScript("arguments[0].innerHTML = ''", editorBody);
		
		wd.findElement(By.tagName("body")).sendKeys(value);
		
		wd.switchTo().defaultContent();
	}

	/**
	 * Função que tenta preencher mais de uma vez o campo. Ela verifica se o
	 * conteúdo enviado é o mesmo que esta atualmente no campo.
	 */
	public void sendKeysWithTries(CharSequence... keysToSend) {
		
		String[] id =  getElementMap().locator();
		
		String str;
		
		str = id[0].toString();
		
		String value = charSequenceToString(keysToSend);
		
		WebDriver wd = super.getDriver();
		
		WebElement frame = wd.findElement(By.xpath(str));
		wd.switchTo().frame(frame);
		
		JavascriptExecutor js = null;
		if (wd instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)wd;
		}
		WebElement editorBody = wd.findElement(By.cssSelector("body"));
		js.executeScript("arguments[0].innerHTML = ''", editorBody);
		
		wd.findElement(By.tagName("body")).sendKeys(value);

		wd.switchTo().defaultContent();
		
		
	}
	
	private String charSequenceToString(CharSequence... keysToSend) {
		String value = "";
		
		for (int i = 0; i < keysToSend.length; i++)
			value += keysToSend[i];
		
		return value;
	}
	
	
	
	public void clear() {
		String[] id =  getElementMap().locator();
		
		String str;
		
		str = id[0].toString();
		
		WebDriver wd = super.getDriver();
		
		WebElement frame = wd.findElement(By.xpath(str));
		wd.switchTo().frame(frame);
		JavascriptExecutor js = null;
		if (wd instanceof JavascriptExecutor) {
		    js = (JavascriptExecutor)wd;
		}
		WebElement editorBody = wd.findElement(By.cssSelector("body"));
		js.executeScript("arguments[0].innerHTML = ''", editorBody);

		wd.switchTo().defaultContent();
	}

	@Override
	public String getText() {
		String[] id =  getElementMap().locator();
		
		String str;
		
		str = id[0].toString();
		
		WebDriver wd = super.getDriver();
		
		WebElement frame = wd.findElement(By.xpath(str));
		wd.switchTo().frame(frame);
		String text = wd.findElement(By.tagName("body")).getText();
		
		wd.switchTo().defaultContent();
		
		return text;
	}

}
