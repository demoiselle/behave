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
import br.gov.frameworkdemoiselle.behave.runner.ui.Select;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;
import demoisellebehave.serpro.treino.config.Config;

@ScreenMap(name = "Lista de Obras",  base=Config.URLBASE, location="/private/pages/obra.html")
public class ListaObrasPage {

	@ElementMap(name = "Adicionar Obra", locatorType = ElementLocatorType.XPath, locator = "(//*[contains(@id, 'formObra')][contains(@type, 'submit')])[1]")
	private Button botaoAdicionarObra;
	
	@ElementMap(name = "Nome Obra", locatorType = ElementLocatorType.XPath, locator = "(//*[contains(@id, 'formObra:j_idt')][contains(@type, 'text')])[1]")
	private TextField nomeDaObra;

	@ElementMap(name = "Valor", locatorType = ElementLocatorType.XPath, locator = "(//*[contains(@id, 'formObra:j_idt')][contains(@type, 'text')])[2]")
	private TextField valor;
	
	@ElementMap(name = "Prazo", locatorType = ElementLocatorType.XPath, locator = "(//*[contains(@id, 'formObra:j_idt')][contains(@type, 'text')])[3]")
	private TextField prazo;
	
	@ElementMap(name = "Inserir", locatorType = ElementLocatorType.XPath, locator = "(//*[contains(@id, 'formObra')][contains(@type, 'submit')])[1]")
	private Button btInserir;
	
	@ElementMap(name = "Registros por Página", locatorType = ElementLocatorType.XPath, locator = "(//select[contains(@title, 'Rows')])[1]")
	private Select ultimaPagina;
	
	@ElementMap(name = "Excluir", locatorType = ElementLocatorType.XPath, locator = "(//tr[contains(@id, 'formObra')][.//text()='%param1%']//button)[1]")
	private Button primeiroBotaoExcluir;	
	
	@ElementMap(name = "Sim", locatorType = ElementLocatorType.XPath, locator = "(//button[contains(@id, 'formRemoverObra')]/span[./text()='Sim'])")
	private Button sim;
	
	@ElementMap(name = "Enviar Lance na Primeira Obra", locatorType = ElementLocatorType.XPath, locator = "(//button[contains(@id, 'formObra')][contains(@onclick, 'dlLance.show')])[1]")
	private Button btPrimeiraObra;	
	
	@ElementMap(name = "Excluir Obra", locatorType = ElementLocatorType.XPath, locator = "(//tr[td/span/span='%param1%']//button)[1]")
	private Button btExcluir;
	
	@ElementMap(name = "Excluir Nova Obra", locatorType = ElementLocatorType.XPath, locator = "(//tr[td[1]//.='%param1%'][td[2]//.='%param2%']//button)[1]")
	private Button btExcluirNova;
	 
}