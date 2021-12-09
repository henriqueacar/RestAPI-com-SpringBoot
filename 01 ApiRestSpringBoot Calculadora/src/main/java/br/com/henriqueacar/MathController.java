package br.com.henriqueacar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.henriqueacar.MathOperations.MathOperationsHandler;
import br.com.henriqueacar.NumberChecker.NumberCheckerHandler;
import br.com.henriqueacar.exception.MathOperationException;

@RestController
public class MathController {
	
	@Autowired
	private NumberCheckerHandler numCheck;
	
	@Autowired
	private MathOperationsHandler math;
	
	@RequestMapping(value={"/{metodo}/{numberOne}/{numberTwo}", "/{metodo}/{numberOne}" }, method=RequestMethod.GET)
	public Double calcula(@PathVariable("metodo") String metodo, @PathVariable("numberOne") String numberOne,
			@PathVariable(name="numberTwo", required=false) String numberTwo) throws Exception {
		
		numCheck.isNumeric(numberOne);
		
		if(numberTwo != null) {
			numCheck.isNumeric(numberTwo);
		}
		
		switch(metodo){
			case "soma": 
					return math.soma(numberOne, numberTwo);

			case "subtracao":
					return math.subtracao(numberOne, numberTwo);

			case "multiplicacao":
					return math.multiplicacao(numberOne, numberTwo);

			case "divisao":
					return math.divisao(numberOne, numberTwo);

			case "media":
					return math.media(numberOne, numberTwo);

			case "raiz":
				if(numberTwo == null)
					return math.raiz(numberOne);
				else
					throw new MathOperationException("Erro. Por favor, use apenas um valor numérico para o cálculo da raiz quadrada");
			case "fatorial":
				if(numberTwo == null)
					return math.fatorial(numberOne);
				else
					throw new MathOperationException("Erro. Por favor, use apenas um valor numérico para o cálculo de fatorial");

			default:
				break;
		}
		throw new MathOperationException("Metodo invalido. Usar 'soma', 'subtracao', 'multiplicacao', 'divisao', 'media', 'raiz'.");
	}
}
