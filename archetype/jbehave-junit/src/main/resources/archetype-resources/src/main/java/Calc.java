package ${packageName};

public class Calc {
	
	private double memory = 0.0;
	
	/**
	 * Limpa o valor da calculadora
	 */
	public void clean(){
		memory = 0.0;
	}
	
	/**
	 * Retorna o valor atual da calculadora
	 * @return
	 */
	public double result(){
		return memory;
	}
	
	/**
	 * Adiciona a calculadora o número informado
	 * @param value
	 */
	public void sum(double value){
		memory += value;
	}

	/**
	 * Subtrai da calculadora o número informado
	 * @param value
	 */
	public void subtraction(double value){
		memory -= value;
	}

	/**
	 * Multiplica o valor da calculadora ao número informado
	 * @param value
	 */
	public void multiplication(double value){
		memory *= value;
	}
	
	/**
	 * Divide o valor da calculadora ao número informado
	 * @param value
	 */
	public void division(double value){
		memory /= value;
	}
	
}
