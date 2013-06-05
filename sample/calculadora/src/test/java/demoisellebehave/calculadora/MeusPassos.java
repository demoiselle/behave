package demoisellebehave.calculadora;

import static org.junit.Assert.assertEquals;

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

}
