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
		Double soma = numCheck.convertToDouble(numberOne) + numCheck.convertToDouble(numberTwo);
		return soma;
	}

	/*
	 * SUBTRACAO
	 * */
	public Double subtracao(String numberOne, String numberTwo) throws Exception {
		Double subtracao = numCheck.convertToDouble(numberOne) - numCheck.convertToDouble(numberTwo);
		return subtracao;
	}
	
	/*
	 * MULTIPLICACAO
	 * */
	public Double multiplicacao(String numberOne, String numberTwo) throws Exception {
		Double multiplicacao = numCheck.convertToDouble(numberOne) * numCheck.convertToDouble(numberTwo);
		return multiplicacao;
	}
	
	/*
	 * DIVISAO
	 * */
	public Double divisao(String numberOne, String numberTwo) throws Exception {
		Double divisao = numCheck.convertToDouble(numberOne) / numCheck.convertToDouble(numberTwo);
		return divisao;
	}
	
	/*
	 * MEDIA
	 * */
	public Double media(String numberOne, String numberTwo) throws Exception {
		Double media = (numCheck.convertToDouble(numberOne) + numCheck.convertToDouble(numberTwo))/2;
		return media;
	}
	
	/*
	 * RAIZ QUADRADA
	 * */
	public Double raiz(String numberOne) throws Exception {
		Double raiz = Math.sqrt(numCheck.convertToDouble(numberOne));
		return raiz;
	}
}
