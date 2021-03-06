package br.com.henriqueacar.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import br.com.henriqueacar.config.SwaggerConfig;
import br.com.henriqueacar.data.vo.PersonVO;
import br.com.henriqueacar.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {SwaggerConfig.PERSON_TAG})
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	
	@ApiOperation(value ="Person/findAll - Find all persons")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() throws Exception {
		List<PersonVO> persons = services.findAll();
		
		/*
		 *Recebe a lista do findAll em persons, percorre a lista um a um
		 *e atribui a cada um deles a variável p adicionando o link para cada um 
		 * */
		persons
		.stream()
		.forEach(p -> {
			try {
				p.add(
						linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
						);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return persons;
	}
	
	@ApiOperation(value ="Person/findById - Find specific person by ID")
	@GetMapping(value ="/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id) throws Exception {
		PersonVO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value ="Person/create - Create new person on DB")
	@PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
				 consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		PersonVO personVO = services.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}
	
	/*@PostMapping(value = "/v2", produces = {"application/json", "application/xml", "application/x-yaml"},
			 					consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) throws Exception {
		PersonVOV2 personVOV2 = services.createV2(person);
		personVOV2.add(linkTo(methodOn(PersonController.class).findById(personVOV2.getKey())).withSelfRel());
		return personVOV2;
	}*/
	
	@ApiOperation(value ="Person/update - Update specific person")
	@PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			    consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		PersonVO personVO = services.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(person.getKey())).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value ="Person/delete - Delete specific person by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws Exception {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

	

}
