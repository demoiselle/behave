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
import br.gov.frameworkdemoiselle.behave.runner.ui.Button;
import br.gov.frameworkdemoiselle.behave.runner.ui.Grid;

@ScreenMap(name = "Lista de Obras", location = "Painel Principal")
public class ListaObrasScreen {

	@ElementMap(name = "Adicionar Obra", locatorType = ElementLocatorType.Label, locator = "Adicionar")
	private Button botaoAdicionarObra;

	@ElementMap(name = "Alterar Obra", locatorType = ElementLocatorType.Label, locator = "Alterar")
	private Button botaoAlterarObra;

	@ElementMap(name = "Excluir Obra", locatorType = ElementLocatorType.Label, locator = "Excluir")
	private Button botaoExcluirObra;

	@ElementMap(name = "Enviar Lance", locatorType = ElementLocatorType.Label, locator = "Enviar Lance")
	private Button botaoEnviarLanceObra;

	@ElementMap(name = "Tabela de Obras", locatorType = ElementLocatorType.ClassName, locator = "JTable")
	private Grid table;

}