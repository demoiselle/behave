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
package demoisellebehave.calculadora;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import junit.framework.Assert;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.parser.Step;

public class MeusPassos implements Step {
	
	private Calculadora calculadora;
	
	@When("Quando inicio a Calculadora")
	public void goToWithName(String local) {
	}
	
	@When("inicio a Calculadora")
	public void whenInicioACalculadora() {
		calculadora = new Calculadora();
	}
	
	
	@Then("seu valor ser\u00E1 \"$valor\"")
	public void thenSeuValorSera(double valor) {
	  assertEquals(valor, calculadora.resultado(), 0.0);
	}
	
	@When("adiciono \"$valor\"")
	public void whenAdiciono(double valor) {
	  calculadora.soma(valor);
	}
	
	@When("subtraio \"$valor\"")
	public void whenSubtraio(double valor) {
		calculadora.subtracao(valor);
	}
	
	@When("multiploco \"$valor\"")
	public void whenMultiploco(double valor) {
		calculadora.multiplicao(valor);
	}
	
	@When("divido \"$valor\"")
	public void whenMDivido(double valor) {
		calculadora.divisao(valor);
	}

	
	@When("limpo")
	public void whenLimpo() {
		calculadora.limpar();
	}
	
	@Then("realizo v\u00E1rias somas da $lista")
	public void variasSomas(Map<String, String> lista) {
		calculadora.soma(Double.parseDouble(lista.get("valor01")));
		calculadora.soma(Double.parseDouble(lista.get("valor02")));
		Assert.assertEquals(calculadora.resultado(), Double.parseDouble(lista.get("resultado")));
	}


}
