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
package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.Image;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;

public class WebImage extends WebBase implements Image {
	
	protected static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText() {
		
		waitElement(0);
		String src = getElements().get(0).getAttribute("src");
		
		return (src != null?src:"");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkSource(String src) {
		
		waitElement(0);

		List<WebElement> elements = getElements();
		WebElement element = elements.get(0);
		
		if(element.getTagName().equals("img")){
			if(!element.getAttribute("src").contains(src)){
				throw new BehaveException(message.getString("exception-attribute-not-contains-value","src",src,getElementMap().name()));
			}
		}else{
			throw new BehaveException(message.getString("element-is-not-type",getElementMap().name(),"image"));
		}

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkAttributes(HashMap<String, String> attrs) {
		waitElement(0);

		List<WebElement> elements = getElements();
		WebElement element = elements.get(0);
		
		for(String attrName : attrs.keySet()){
			if(!element.getAttribute(attrName).contains(attrs.get(attrName))){
				throw new BehaveException(message.getString("exception-attribute-not-contains-value",attrName,attrs.get(attrName),getElementMap().name()));
			}
		}

	}
}