package ${packageName};

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import br.gov.frameworkdemoiselle.behave.parser.Step;

public class MySteps implements Step {
	
	private Calc calculadora;
	
	@When("Quando inicio a Calculadora")
	public void goToWithName(String local) {
	}
	
	@When("inicio a Calculadora")
	public void whenInicioACalculadora() {
		calculadora = new Calc();
	}
	
	
	@Then("seu valor ser\u00E1 \"$valor\"")
	public void thenSeuValorSera(double valor) {
	  assertEquals(valor, calculadora.result(), 0.0);
	}
	
	@When("adiciono \"$valor\"")
	public void whenAdiciono(double valor) {
	  calculadora.sum(valor);
	}
	
	@When("subtraio \"$valor\"")
	public void whenSubtraio(double valor) {
		calculadora.subtraction(valor);
	}
	
	@When("multiplico \"$valor\"")
	public void whenMultiplico(double valor) {
		calculadora.multiplication(valor);
	}
	
	@When("divido \"$valor\"")
	public void whenMDivido(double valor) {
		calculadora.division(valor);
	}

	
	@When("limpo")
	public void whenLimpo() {
		calculadora.clean();
	}

}
