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

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.parser.Step;
import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.util.DependenciesUtil;

/**
 * 
 * @author SERPRO
 *
 */
/**
 * 
 * @author SERPRO
 *
 */
/**
 * 
 * @author SERPRO
 *
 */
/**
 * 
 * @author SERPRO
 *
 */
public class CommonSteps implements Step {

	private Logger logger = Logger.getLogger(this.toString());

	@Given("vou para o endereço [$url]")
	public void goToUrl(String url) {

		Runner runner = (Runner) DependenciesUtil.getInstance().getInstanceDependecy(Runner.class);
		runner.run();

		logger.log(Level.INFO, "Go to URL: " + url);
	}

	@Given("clico em [$objeto]")
	public void click(String objeto) {
		logger.log(Level.INFO, "Click em " + objeto);
	}

	@Given("o browser foi aberto")
	public void open() {

	}

	@When("for preenchido o nome do usuário com \"$teste\"")
	public void whenForPreenchidoONomeDoUsuárioComusuário() {

	}

	@When("for preencido a senha com \"123\"")
	public void whenForPreencidoASenhaCom123() {
		// PENDENTE
	}

	@When("for acionado o botão \"entrada\"")
	public void whenForAcionadoOBotãoentrada() {
		// PENDENTE
	}

	@When("for acionado o botão \"confirmação de entrada\"")
	public void whenForAcionadoOBotãoconfirmaçãoDeEntrada() {
		// PENDENTE
	}

	@Then("será exibida a mensagem \"login efetuado com sucesso\"")
	public void thenSeráExibidaAMensagemloginEfetuadoComSucesso() {
		// PENDENTE
	}

	@Then("que entrei na opcao fazer pedido")
	public void thenQueEntreiNaOpcaoFazerPedido() {
		// PENDENTE
	}

	@When("for preenchido um pedido do tipo \"venda grande\"")
	public void whenForPreenchidoUmPedidoDoTipovendaGrande() {
		// PENDENTE
	}

	@Then("será exibida a mensagem \"sucesso\"")
	public void thenSeráExibidaAMensagemsucesso() {
		// PENDENTE
	}

}
