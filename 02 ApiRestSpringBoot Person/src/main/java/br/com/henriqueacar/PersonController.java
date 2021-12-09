package br.com.henriqueacar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.henriqueacar.model.Person;
import br.com.henriqueacar.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//API apenas para entender o funcionamento dos verbos HTTP
	
	//Verbo POST é muito usado para persistência de dados, para gravação
	//Verbo PUT é geralmente utilizado para atualizações, logo é necessário que o objeto já exista
	
	@Autowired
	private PersonServices services;
	
	@GetMapping
	public List<Person> findAll() throws Exception {
		return services.findAll();
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Long id) throws Exception {
		return services.findById(id);
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) throws Exception {
		return services.create(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) throws Exception {
		return services.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

	

}
