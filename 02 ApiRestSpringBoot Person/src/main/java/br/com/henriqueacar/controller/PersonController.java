package br.com.henriqueacar.controller;

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

import br.com.henriqueacar.data.vo.PersonVO;
import br.com.henriqueacar.data.vo.v2.PersonVOV2;
import br.com.henriqueacar.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	//API apenas para entender o funcionamento dos verbos HTTP
	
	//Verbo POST é muito usado para persistência de dados, para gravação
	//Verbo PUT é geralmente utilizado para atualizações, logo é necessário que o objeto já exista
	
	@Autowired
	private PersonServices services;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public List<PersonVO> findAll() throws Exception {
		return services.findAll();
	}
	
	@GetMapping(value ="/{id}", produces = {"application/json", "application/xml"})
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {
		return services.findById(id);
	}
	
	@PostMapping(produces = {"application/json", "application/xml"},
				 consumes = {"application/json", "application/xml"})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return services.create(person);
	}
	
	@PostMapping(value = "/v2", produces = {"application/json", "application/xml"},
			 					consumes = {"application/json", "application/xml"})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception {
		return services.createV2(person);
	}
	
	@PutMapping(produces = {"application/json", "application/xml"},
			    consumes = {"application/json", "application/xml"})
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return services.update(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

	

}
