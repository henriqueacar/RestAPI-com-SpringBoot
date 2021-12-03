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
		
		numCheck.isNumeric(numberOne);
		
		if(numberTwo != null) {
			numCheck.isNumeric(numberTwo);
		}
		
		switch(metodo){
			case "soma": 
					return operation.soma(numberOne, numberTwo);

			case "subtracao":
					return operation.subtracao(numberOne, numberTwo);

			case "multiplicacao":
					return operation.multiplicacao(numberOne, numberTwo);

			case "divisao":
					return operation.divisao(numberOne, numberTwo);

			case "media":
					return operation.media(numberOne, numberTwo);

			case "raiz":
				if(numberTwo == null)
					return operation.raiz(numberOne);
				else
					throw new MathOperationException("Erro. Por favor, use apenas um valor numérico para o cálculo da raiz quadrada");

			default:
				break;
		}
		throw new MathOperationException("Metodo invalido. Usar 'soma', 'subtracao', 'multiplicacao', 'divisao', 'media', 'raiz'.");
	}
}
