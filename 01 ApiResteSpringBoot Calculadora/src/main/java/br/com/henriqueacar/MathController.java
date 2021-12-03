package br.com.henriqueacar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.henriqueacar.exception.MathOperationException;

@RestController
public class MathController {
	
	/*
	 * SOMA
	 * */
	@RequestMapping(value="/soma/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double soma(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Por favor, coloque valores numericos.");
		}

		Double soma = convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		return soma;
	}
	
	/*
	 * SUBTRACAO
	 * */
	@RequestMapping(value="/subtracao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtracao(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Por favor, coloque valores numericos.");
		}

		Double subtracao = convertToDouble(numberOne) - convertToDouble(numberTwo);
		
		return subtracao;
	}
	
	/*
	 * MULTIPLICACAO
	 * */
	@RequestMapping(value="/multiplicacao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplicacao(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Por favor, coloque valores numericos.");
		}

		Double multiplicacao = convertToDouble(numberOne) * convertToDouble(numberTwo);
		
		return multiplicacao;
	}
	
	/*
	 * DIVISAO
	 * */
	@RequestMapping(value="/divisao/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double divisao(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Por favor, coloque valores numericos.");
		}

		Double divisao = convertToDouble(numberOne) / convertToDouble(numberTwo);
		
		return divisao;
	}
	
	/*
	 * MEDIA
	 * */
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationException("Por favor, coloque valores numericos.");
		}

		Double media = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		
		return media;
	}
	
	/*
	 * RAIZ QUADRADA
	 * */
	@RequestMapping(value="/raiz/{numberOne}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {
		
		if(!isNumeric(numberOne)) {
			throw new MathOperationException("Por favor, coloque valores numericos.");
		}

		Double raiz = Math.sqrt(convertToDouble(numberOne));
		
		return raiz;
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null)return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null)return false;
		String number = strNumber.replaceAll(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
