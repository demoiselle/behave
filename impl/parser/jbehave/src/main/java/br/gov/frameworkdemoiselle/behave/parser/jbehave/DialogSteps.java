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

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.internal.spi.InjectionManager;
import br.gov.frameworkdemoiselle.behave.internal.util.DataProviderUtil;
import br.gov.frameworkdemoiselle.behave.runner.ui.Dialog;

public class DialogSteps extends CommonSteps {

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
		value = DataProviderUtil.replaceValue(value);
		Dialog dialog = (Dialog) InjectionManager.getInstance().getInstanceDependecy(Dialog.class);
		dialog.sendKeys(value);
	}

	@Then("ser\u00E1 exibido na caixa de di\u00E1logo \"$value\"")
	public void getTextDialog(String value) {
		value = DataProviderUtil.replaceValue(value);
		Dialog dialog = (Dialog) InjectionManager.getInstance().getInstanceDependecy(Dialog.class);
		Assert.assertEquals(value.replace("\r\n", "").replace("\n", ""), dialog.getText().replace("\r\n", "").replace("\n", ""));
	}
	
}
