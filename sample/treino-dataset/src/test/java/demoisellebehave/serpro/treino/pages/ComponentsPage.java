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
package demoisellebehave.serpro.treino.pages;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.CheckBox;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;
import br.gov.frameworkdemoiselle.behave.runner.ui.Loading;
import br.gov.frameworkdemoiselle.behave.runner.ui.Radio;
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import demoisellebehave.serpro.treino.config.Config;

@ScreenMap(name = "Tela de Componentes", base = Config.URLBASE, location = "/private/pages/teste.html")
public class ComponentsPage {

	@ElementMap(name = "Seleção de Opção 1", locatorType = ElementLocatorType.XPath, locator = { "//div[@id='formObra:j_idt24']/label", "//div[@id='formObra:j_idt24']/div[3]/div/div/div/ul" })
	private Select selectOpcao1;

	@ElementMap(name = "Seleção de Opção 2", locatorType = ElementLocatorType.XPath, locator = { "//div[@id='formObra:j_idt27']/label", "//div[@id='formObra:j_idt27']/div[3]/div/div/div/ul" })
	private Select selectOpcao2;

	@ElementMap(name = "Botão Exibir", locatorType = ElementLocatorType.Id, locator = "formObra:btSubmit2")
	private Button botaoExibir;

	@ElementMap(name = "Opção Selecionada", locatorType = ElementLocatorType.XPath, locator = "//*[@id='formObra:displayFilme_list']/li")
	private Label opcaoSelecionada;

	@ElementMap(name = "Botão Fechar", locatorType = ElementLocatorType.XPath, locator = "//button[@id='formObra:j_idt33']")
	private Button botaoFechar;

	@ElementMap(name = "Carregando", locatorType = ElementLocatorType.XPath, locator = "/HTML/BODY/DIV[2]/DIV[1]/SPAN[@id='ui-dialog-title-j_idt9']")
	private Loading loading;

	@ElementMap(name = "Opção 1", locatorType = ElementLocatorType.XPath, locator = "/html/body/table/tbody/tr[4]/td/form/table[3]/tbody/tr/td/table/tbody/tr/td[1]/div/div[2]")
	private Radio opcao1;

	@ElementMap(name = "Opção 2", locatorType = ElementLocatorType.XPath, locator = "/html/body/table/tbody/tr[4]/td/form/table[3]/tbody/tr/td/table/tbody/tr/td[3]/div/div[2]")
	private Radio opcao2;

	@ElementMap(name = "Opção 3", locatorType = ElementLocatorType.XPath, locator = "/html/body/table/tbody/tr[4]/td/form/table[3]/tbody/tr/td/table/tbody/tr/td[5]/div/div[2]")
	private Radio opcao3;

	@ElementMap(name = "Opção Selecionada no Radio", locatorType = ElementLocatorType.XPath, locator = "//*[@id='formObra:label']")
	private Label opcaoSelecionadaRadio;

	@ElementMap(name = "Valor 1", locatorType = ElementLocatorType.XPath, locator = "//div[@id='formObra:j_idt41']/div[2]")
	private CheckBox check1;

	@ElementMap(name = "Valor 2", locatorType = ElementLocatorType.XPath, locator = "//div[@id='formObra:j_idt43']/div[2]")
	private CheckBox check2;

}