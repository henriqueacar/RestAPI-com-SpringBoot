package br.com.henriqueacar.NumberChecker;

import br.com.henriqueacar.exception.MathOperationException;

public class NumberCheckerHandler {

	public static Double convertToDouble(String strNumber) {
		if(strNumber == null)
			throw new MathOperationException("Erro. Por favor, use dois valores numéricos para o cálculo.");
		
		String number = strNumber.replaceAll(",", ".");
		
		isNumeric(number);
		
		return Double.parseDouble(number);
	}

	public static void isNumeric(String strNumber) {
		
		String number = strNumber.replaceAll(",", ".");
		
		if(!number.matches("[-+]?[0-9]*\\.?[0-9]+"))
			throw new MathOperationException("Erro. Por favor, use apenas valores numéricos, não caracteres.");
	}
}