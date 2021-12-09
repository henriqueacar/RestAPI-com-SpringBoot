package br.com.henriqueacar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.henriqueacar.exception.ResourceNotFoundException;
import br.com.henriqueacar.model.Person;
import br.com.henriqueacar.repository.PersonRepository;

//@Service serve para que o spring cuide para que voce possa usar a classe sem precisar instanciar
@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		repository.delete(entity);
	}
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
	}
	
	
	public List<Person> findAll(){
		return repository.findAll() ;
	}
	
}
