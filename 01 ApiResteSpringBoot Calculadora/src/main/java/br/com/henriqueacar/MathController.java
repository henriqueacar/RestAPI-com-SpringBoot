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
	
	@RequestMapping(value={"/{metodo}/{numberOne}/{numberTwo}", "/{metodo}/{numberOne}" }, method=RequestMethod.GET)
	public Double calcula(@PathVariable("metodo") String metodo, @PathVariable("numberOne") String numberOne,
			@PathVariable(name="numberTwo", required=false) String numberTwo) throws Exception {
		
		NumberCheckerHandler.isNumeric(numberOne);
		
		if(numberTwo != null) {
			NumberCheckerHandler.isNumeric(numberTwo);
		}
		
		switch(metodo){
			case "soma": 
					return MathOperationsHandler.soma(numberOne, numberTwo);

			case "subtracao":
					return MathOperationsHandler.subtracao(numberOne, numberTwo);

			case "multiplicacao":
					return MathOperationsHandler.multiplicacao(numberOne, numberTwo);

			case "divisao":
					return MathOperationsHandler.divisao(numberOne, numberTwo);

			case "media":
					return MathOperationsHandler.media(numberOne, numberTwo);

			case "raiz":
				if(numberTwo == null)
					return MathOperationsHandler.raiz(numberOne);
				else
					throw new MathOperationException("Erro. Por favor, use apenas um valor numérico para o cálculo da raiz quadrada");
			case "fatorial":
				if(numberTwo == null)
					return MathOperationsHandler.fatorial(numberOne);
				else
					throw new MathOperationException("Erro. Por favor, use apenas um valor numérico para o cálculo de fatorial");

			default:
				break;
		}
		throw new MathOperationException("Metodo invalido. Usar 'soma', 'subtracao', 'multiplicacao', 'divisao', 'media', 'raiz'.");
	}
}
