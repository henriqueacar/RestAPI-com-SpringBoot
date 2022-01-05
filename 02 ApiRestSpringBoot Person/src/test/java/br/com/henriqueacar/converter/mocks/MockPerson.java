package br.com.henriqueacar.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.henriqueacar.data.model.Person;
import br.com.henriqueacar.data.vo.PersonVO;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList(){
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
			
		}
		return persons;
	}
	
	public List<PersonVO> mockVOList(){
		List<PersonVO> persons = new ArrayList<PersonVO>();
		for(int i = 0; i < 14; i++) {
			persons.add(mockVO(i));	
		}
		return persons; 
	}
	
	
	private Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Endereço teste" + number);
		person.setFirstName("PrimeiroNome");
		person.setGender(((number % 2) == 0) ? "Masculino" : "Feminino");
		person.setId(number.longValue());
		person.setLastName("Sobrenome");
		return person;
	}

	private PersonVO mockVO(Integer number) {
		PersonVO person = new PersonVO();
		person.setAddress("Endereço teste" + number);
		person.setFirstName("PrimeiroNome");
		person.setGender(((number % 2) == 0) ? "Masculino" : "Feminino");
		person.setKey(number.longValue());
		person.setLastName("Sobrenome");
		return person;
	}
	
}
