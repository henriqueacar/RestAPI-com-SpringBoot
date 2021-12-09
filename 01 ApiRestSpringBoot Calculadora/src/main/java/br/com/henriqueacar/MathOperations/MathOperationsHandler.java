package br.com.henriqueacar.MathOperations;

import br.com.henriqueacar.NumberChecker.NumberCheckerHandler;

public class MathOperationsHandler {
	/*
	 * SOMA
	 * */
	public static Double soma(String numberOne, String numberTwo) throws Exception {
		return NumberCheckerHandler.convertToDouble(numberOne) + NumberCheckerHandler.convertToDouble(numberTwo);
	}

	/*
	 * SUBTRACAO
	 * */
	public static Double subtracao(String numberOne, String numberTwo) throws Exception {
		return NumberCheckerHandler.convertToDouble(numberOne) - NumberCheckerHandler.convertToDouble(numberTwo);
	}
	
	/*
	 * MULTIPLICACAO
	 * */
	public static Double multiplicacao(String numberOne, String numberTwo) throws Exception {
		return NumberCheckerHandler.convertToDouble(numberOne) * NumberCheckerHandler.convertToDouble(numberTwo);
	}
	
	/*
	 * DIVISAO
	 * */
	public static Double divisao(String numberOne, String numberTwo) throws Exception {
		return NumberCheckerHandler.convertToDouble(numberOne) / NumberCheckerHandler.convertToDouble(numberTwo);
	}
	
	/*
	 * MEDIA
	 * */
	public static Double media(String numberOne, String numberTwo) throws Exception {
		return (NumberCheckerHandler.convertToDouble(numberOne) + NumberCheckerHandler.convertToDouble(numberTwo))/2;
	}
	
	/*
	 * RAIZ QUADRADA
	 * */
	public static Double raiz(String numberOne) throws Exception {
		return Math.sqrt(NumberCheckerHandler.convertToDouble(numberOne));
	}
	
	/**
	 * FATORIAL
	 * */
	public static Double fatorial(String numberOne) throws Exception{
		Double fat = NumberCheckerHandler.convertToDouble(numberOne);
		if(fat == 0 || fat == 1) {
			return 1D;
		}
		return fat * fatorial(String.valueOf(fat-1));
	}
}	