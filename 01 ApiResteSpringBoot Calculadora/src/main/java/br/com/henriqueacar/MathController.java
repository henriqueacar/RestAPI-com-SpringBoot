package br.com.henriqueacar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.henriqueacar.MathOperations.MathOperationsHandler;
import br.com.henriqueacar.NumberChecker.NumberCheckerHandler;
import br.com.henriqueacar.exception.MathOperationException;

@RestController
public class MathController {
	
	private MathOperationsHandler operation = new MathOperationsHandler();
	private NumberCheckerHandler numCheck = new NumberCheckerHandler();
	
	@RequestMapping(value={"/{metodo}/{numberOne}/{numberTwo}", "/{metodo}/{numberOne}" }, method=RequestMethod.GET)
	public Double calcula(@PathVariable("metodo") String metodo, @PathVariable("numberOne") String numberOne,
			@PathVariable(name="numberTwo", required=false) String numberTwo) throws Exception {
		switch(metodo){
			case "soma": 
				if(numberTwo != null && numCheck.isNumeric(numberTwo))
					return operation.soma(numberOne, numberTwo);
				else
					throw new MathOperationException("Erro. Por favor, use dois valores numéricos para o cálculo");

			case "subtracao":
				if(numberTwo != null && numCheck.isNumeric(numberTwo))
					return operation.subtracao(numberOne, numberTwo);
				else
					throw new MathOperationException("Erro. Por favor, use dois valores numéricos para o cálculo");

			case "multiplicacao":
				if(numberTwo != null && numCheck.isNumeric(numberTwo))
					return operation.multiplicacao(numberOne, numberTwo);
				else
					throw new MathOperationException("Erro. Por favor, use dois valores numéricos para o cálculo");

			case "divisao":
				if(numberTwo != null && numCheck.isNumeric(numberTwo))
					return operation.divisao(numberOne, numberTwo);
				else
					throw new MathOperationException("Erro. Por favor, use dois valores numéricos para o cálculo");

			case "media":
				if(numberTwo != null && numCheck.isNumeric(numberTwo))
					return operation.media(numberOne, numberTwo);
				else
					throw new MathOperationException("Erro. Por favor, use dois valores numéricos para o cálculo");

			case "raiz":
				if(numberTwo == null && numCheck.isNumeric(numberOne))
					return operation.raiz(numberOne);
				else
					throw new MathOperationException("Erro. Por favor, use apenas um valor numérico para o cálculo");

			default:
				break;
		}
		throw new MathOperationException("Metodo invalido. Usar 'soma', 'subtracao', 'multiplicacao', 'divisao', 'media', 'raiz'.");
	}
}
