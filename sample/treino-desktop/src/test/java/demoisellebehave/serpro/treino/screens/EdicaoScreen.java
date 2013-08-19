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
package demoisellebehave.serpro.treino.screens;

import br.gov.frameworkdemoiselle.behave.annotation.ElementLocatorType;
import br.gov.frameworkdemoiselle.behave.annotation.ElementMap;
import br.gov.frameworkdemoiselle.behave.annotation.ScreenMap;
import br.gov.frameworkdemoiselle.behave.runner.fest.annotation.ElementIndex;
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Label;
import br.gov.frameworkdemoiselle.behave.runner.ui.TextField;

@ScreenMap(name = "Edição de Obra", location = "Edição de Obra")
public class EdicaoScreen {

	@ElementMap(name = "Rótulo Nome da Obra", locatorType = ElementLocatorType.Label, locator = "Nome da Obra:")
	private Label lblNomeObra;

	@ElementMap(name = "Nome da Obra", locatorType = ElementLocatorType.ClassName, locator = "JTextField")
	@ElementIndex(index = 1)
	private TextField txtNomeObra;

	@ElementMap(name = "Rótulo Valor", locatorType = ElementLocatorType.Label, locator = "Valor:")
	private Label lblValor;

	@ElementMap(name = "Valor", locatorType = ElementLocatorType.ClassName, locator = "JTextField")
	@ElementIndex(index = 0)
	private TextField txtValor;

	@ElementMap(name = "Rótulo Prazo", locatorType = ElementLocatorType.Label, locator = "Prazo:")
	private Label lblPrazo;

	@ElementMap(name = "Prazo", locatorType = ElementLocatorType.ClassName, locator = "JTextField")
	@ElementIndex(index = 2)
	private TextField txtPrazo;

	@ElementMap(name = "Inserir", locatorType = ElementLocatorType.Label, locator = "Inserir Obra")
	private Button btnInserir;

	@ElementMap(name = "Cancelar", locatorType = ElementLocatorType.Label, locator = "Cancelar")
	private Button btnCancelar;

}
