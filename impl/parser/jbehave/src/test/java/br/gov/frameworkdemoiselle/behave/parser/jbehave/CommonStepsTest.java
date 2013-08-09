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
//package br.gov.frameworkdemoiselle.behave.parser.jbehave;
//
//import static org.junit.Assert.fail;
//import mockit.Mock;
//import mockit.MockClass;
//import mockit.MockUp;
//
//import org.junit.Test;
//
//import br.gov.frameworkdemoiselle.behave.runner.Runner;
//import br.gov.frameworkdemoiselle.behave.util.DependenciesUtil;
//
//public class CommonStepsTest {
//
//	@MockClass(realClass = DependenciesUtil.class)
//	public static class DependenciesUtilMock extends MockUp<DependenciesUtil> {
//
//		@Mock
//		public Object getInstanceDependecy(@SuppressWarnings("rawtypes") Class clazz) {
//			return new Runner() {
//
//				@Override
//				public void run(Object... params) {
//					// TODO Auto-generated method stub
//
//				}
//			};
//
//		}
//	}
//
//	@Test
//	public void testGoTo() {
//		new DependenciesUtilMock();
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.goTo("http://www.google.com");
//	}
//
//	@Test
//	public void testClick() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.click("id=/");
//	}
//
//	@Test
//	public void testOpen() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.open();
//	}
//
//	@Test
//	public void testWhenForPreenchidoONomeDoUsuárioComusuário() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.whenForPreenchidoONomeDoUsuárioComusuário();
//	}
//
//	@Test
//	public void testWhenForPreencidoASenhaCom123() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.whenForPreencidoASenhaCom123();
//	}
//
//	@Test
//	public void testWhenForAcionadoOBotãoentrada() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.whenForAcionadoOBotãoentrada();
//	}
//
//	@Test
//	public void testWhenForAcionadoOBotãoconfirmaçãoDeEntrada() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.whenForAcionadoOBotãoconfirmaçãoDeEntrada();
//	}
//
//	@Test
//	public void testThenSeráExibidaAMensagemloginEfetuadoComSucesso() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.thenSeráExibidaAMensagemloginEfetuadoComSucesso();
//	}
//
//	@Test
//	public void testThenQueEntreiNaOpcaoFazerPedido() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.thenQueEntreiNaOpcaoFazerPedido();
//	}
//
//	@Test
//	public void testWhenForPreenchidoUmPedidoDoTipovendaGrande() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.whenForPreenchidoUmPedidoDoTipovendaGrande();
//	}
//
//	@Test
//	public void testThenSeráExibidaAMensagemsucesso() {
//		CommonSteps commonSteps = new CommonSteps();
//		commonSteps.thenSeráExibidaAMensagemsucesso();
//	}
//
// }
