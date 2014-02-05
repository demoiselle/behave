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
package br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4;

import br.gov.frameworkdemoiselle.behave.exception.BehaveException;
import br.gov.frameworkdemoiselle.behave.message.BehaveMessage;
import br.gov.frameworkdemoiselle.behave.runner.ui.Calendar;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.WebDriverRunner;
import br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.WebBase;

/**
 * Componente para mapear elementos de tela referentes ao componente
 * rich:calendar
 * 
 * Utiliza a API Javascript do Richfaces para a correta manipulação do
 * componente. O locator do mapeamento de tela deve retornar o primeiro div
 * gerado pelo componente rich:calendar, aquele div que possui 'class="rf-cal"'
 * ou ainda que possui o mesmo ID informado no arquivo XHTML, porém, o ID não é
 * obrigatório, basta selecionar o primeiro div gerado pelo componente.
 * 
 * @author lmveloso
 * 
 */
public class RichCalendar extends WebBase implements Calendar {

	private static BehaveMessage message = new BehaveMessage(WebDriverRunner.MESSAGEBUNDLE);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #click()
	 */
	@Override
	public void click() {
		waitElement(0);

		checkRichfacesComponent();

		// Abre ou fecha o menu de acordo com o estado do componente
		if ((Boolean) getJavascriptExecutor().executeScript("return RichFaces.$('" + getId() + "').isVisible;"))
			hideCalendar();
		else {
			showCalendar();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #setValue(java.lang.String)
	 */
	@Override
	public void setValue(String value) {
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('" + getId() + "').setValue('" + value + "');");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #clear()
	 */
	public void clear() {
		checkRichfacesComponent();
		setValue("");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #sendKeys(java.lang.CharSequence)
	 */
	public void sendKeys(CharSequence... keysToSend) {
		checkRichfacesComponent();
		setValue((String) keysToSend[0]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #showCalendar()
	 */
	public void showCalendar() {
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('" + getId() + "').showPopup();");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #hideCalendar()
	 */
	public void hideCalendar() {
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('" + getId() + "').hidePopup();");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.gov.frameworkdemoiselle.behave.runner.webdriver.ui.richfaces4.Calendar
	 * #today()
	 */
	public void today() {
		checkRichfacesComponent();
		getJavascriptExecutor().executeScript("RichFaces.$('" + getId() + "').today();");
	}

	/**
	 * Verifica se o componente selecionado é realmente um coponente
	 * rich:calendar
	 * 
	 * @return
	 */
	public boolean isRichCalendar() {
		String jsCodeCheckComponent = "return (function(tipo, id) { var rf = RichFaces.$(id); return (typeof(rf) == \"object\" && typeof(rf.name) == \"string\" && rf.name == tipo);})('Calendar','" + getId() + "');";
		return (Boolean) getJavascriptExecutor().executeScript(jsCodeCheckComponent);
	}

	/**
	 * Método para garantir que o componente correto foi selecionado
	 */
	private void checkRichfacesComponent() {
		if (!isRichCalendar()) {
			throw new BehaveException(message.getString("exception-not-rich-type", this.getElementMap().name(), getId(), "rich:calendar"));
		}

	}
}
