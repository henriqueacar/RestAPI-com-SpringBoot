package br.com.henriqueacar.MathOperations;

import br.com.henriqueacar.NumberChecker.NumberCheckerHandler;

public class MathOperationsHandler {
	
	private NumberCheckerHandler numCheck = new NumberCheckerHandler();

	public MathOperationsHandler() {
		super();
	}

	/*
	 * SOMA
	 * */
	public Double soma(String numberOne, String numberTwo) throws Exception {
		return numCheck.convertToDouble(numberOne) + numCheck.convertToDouble(numberTwo);
	}

	/*
	 * SUBTRACAO
	 * */
	public Double subtracao(String numberOne, String numberTwo) throws Exception {
		return numCheck.convertToDouble(numberOne) - numCheck.convertToDouble(numberTwo);
	}
	
	/*
	 * MULTIPLICACAO
	 * */
	public Double multiplicacao(String numberOne, String numberTwo) throws Exception {
		return numCheck.convertToDouble(numberOne) * numCheck.convertToDouble(numberTwo);
	}
	
	/*
	 * DIVISAO
	 * */
	public Double divisao(String numberOne, String numberTwo) throws Exception {
		return numCheck.convertToDouble(numberOne) / numCheck.convertToDouble(numberTwo);
	}
	
	/*
	 * MEDIA
	 * */
	public Double media(String numberOne, String numberTwo) throws Exception {
		return (numCheck.convertToDouble(numberOne) + numCheck.convertToDouble(numberTwo))/2;
	}
	
	/*
	 * RAIZ QUADRADA
	 * */
	public Double raiz(String numberOne) throws Exception {
		return Math.sqrt(numCheck.convertToDouble(numberOne));
	}
}
