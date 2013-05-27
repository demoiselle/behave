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
package demoisellebehave.serpro.treino.test.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;
import br.gov.frameworkdemoiselle.behave.runner.ui.Loading;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import demoisellebehave.serpro.treino.Constants;

@ScreenMap(name = "Tela de Componentes", location = Constants.URL + "private/pages/teste.html")
public class ComponentsPage {

	@ElementMap(name = "Seleção de Opção 1", locatorType = ElementLocatorType.XPath, locator = { "//div[@id='formObra:j_idt24']/label", "//div[@id='formObra:j_idt24']/div[3]/div/div/div/ul" })
	private Select selectOpcao1;

	@ElementMap(name = "Seleção de Opção 2", locatorType = ElementLocatorType.XPath, locator = { "//div[@id='formObra:j_idt27']/label", "//div[@id='formObra:j_idt27']/div[3]/div/div/div/ul" })
	private Select selectOpcao2;

	@ElementMap(name = "Botão Exibir", locatorType = ElementLocatorType.Id, locator = "formObra:btSubmit")
	private Button botaoExibir;

	@ElementMap(name = "Opção Selecionada", locatorType = ElementLocatorType.XPath, locator = "//FORM[@id='formObra']/DIV/DIV[@id='formObra:j_idt31']/DIV[@id='formObra:display']/DIV[@id='formObra:display_content']/UL[@id='formObra:display_list']/LI")
	private Label opcaoSelecionada;

	@ElementMap(name = "Botão Fechar", locatorType = ElementLocatorType.XPath, locator = "//FORM[@id='formObra']/TABLE[2]/TBODY/TR/TD[3]/BUTTON[@id='formObra:btSubmit']")
	private Button botaoFechar;

	@ElementMap(name = "Carregando", locatorType = ElementLocatorType.XPath, locator = "/HTML/BODY/DIV[2]/DIV[1]/SPAN[@id='ui-dialog-title-j_idt9']")
	private Loading loading;

}