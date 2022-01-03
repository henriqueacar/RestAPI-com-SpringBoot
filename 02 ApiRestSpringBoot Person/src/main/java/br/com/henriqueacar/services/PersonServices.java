package br.com.henriqueacar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.henriqueacar.converter.DozerConverter;
import br.com.henriqueacar.converter.custom.PersonConverter;
import br.com.henriqueacar.data.model.Person;
import br.com.henriqueacar.data.vo.PersonVO;
import br.com.henriqueacar.data.vo.v2.PersonVOV2;
import br.com.henriqueacar.exception.ResourceNotFoundException;
import br.com.henriqueacar.repository.PersonRepository;

//@Service serve para que o spring cuide para que voce possa usar a classe sem precisar instanciar
@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOtoEntity(person);
		var vo = converter.convertEntitytoVO(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		
		return vo;
	}

	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		repository.delete(entity);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Nenhum registro encontrado para esse ID."));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	
	public List<PersonVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
}
