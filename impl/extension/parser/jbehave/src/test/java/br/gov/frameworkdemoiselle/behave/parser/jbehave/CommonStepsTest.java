package br.gov.frameworkdemoiselle.behave.parser.jbehave;

import static org.junit.Assert.fail;
import mockit.Mock;
import mockit.MockClass;
import mockit.MockUp;

import org.junit.Test;

import br.gov.frameworkdemoiselle.behave.runner.Runner;
import br.gov.frameworkdemoiselle.behave.util.DependenciesUtil;

public class CommonStepsTest {

	@MockClass(realClass = DependenciesUtil.class)
	public static class DependenciesUtilMock extends MockUp<DependenciesUtil> {

		@Mock
		public Object getInstanceDependecy(
				@SuppressWarnings("rawtypes") Class clazz) {
			return new Runner() {

				@Override
				public void run(Object... params) {
					// TODO Auto-generated method stub

				}
			};

		}
	}

	@Test
	public void testGoTo() {
		new DependenciesUtilMock();
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.goTo("http://www.google.com");
	}

	@Test
	public void testClick() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.click("id=/");
	}

	@Test
	public void testOpen() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.open();
	}

	@Test
	public void testWhenForPreenchidoONomeDoUsuárioComusuário() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.whenForPreenchidoONomeDoUsuárioComusuário();
	}

	@Test
	public void testWhenForPreencidoASenhaCom123() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.whenForPreencidoASenhaCom123();
	}

	@Test
	public void testWhenForAcionadoOBotãoentrada() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.whenForAcionadoOBotãoentrada();
	}

	@Test
	public void testWhenForAcionadoOBotãoconfirmaçãoDeEntrada() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.whenForAcionadoOBotãoconfirmaçãoDeEntrada();
	}

	@Test
	public void testThenSeráExibidaAMensagemloginEfetuadoComSucesso() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.thenSeráExibidaAMensagemloginEfetuadoComSucesso();
	}

	@Test
	public void testThenQueEntreiNaOpcaoFazerPedido() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.thenQueEntreiNaOpcaoFazerPedido();
	}

	@Test
	public void testWhenForPreenchidoUmPedidoDoTipovendaGrande() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.whenForPreenchidoUmPedidoDoTipovendaGrande();
	}

	@Test
	public void testThenSeráExibidaAMensagemsucesso() {
		CommonSteps commonSteps = new CommonSteps();
		commonSteps.thenSeráExibidaAMensagemsucesso();
	}

}
