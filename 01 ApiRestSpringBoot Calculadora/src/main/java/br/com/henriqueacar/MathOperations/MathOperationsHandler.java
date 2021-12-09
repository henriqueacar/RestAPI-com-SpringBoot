package br.com.henriqueacar.MathOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.henriqueacar.NumberChecker.NumberCheckerHandler;

@Service
public class MathOperationsHandler {
	
	@Autowired
	private NumberCheckerHandler numCheck;
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
	
	/**
	 * FATORIAL
	 * */
	public Double fatorial(String numberOne) throws Exception{
		Double fat = numCheck.convertToDouble(numberOne);
		if(fat == 0 || fat == 1) {
			return 1D;
		}
		return fat * fatorial(String.valueOf(fat-1));
	}
}	