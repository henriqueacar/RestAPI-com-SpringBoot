package br.com.henriqueacar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.henriqueacar.model.Person;

//@Service serve para que o spring cuide para que voce possa usar a classe sem precisar instanciar
@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	
	
	public Person create(Person person) {
		
		return person;
	}
	
	public Person update(Person person) {
		
		return person;
	}

	public void delete(String id) {
		
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Henrique");
		person.setLastName("Cardoso");
		person.setAddress("Angra dos Reis");
		person.setGender("Masculino");
		return person;
	}
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons ;
	}
	
	private Person mockPerson(int id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Nome" + id);
		person.setLastName("Sobrenome" + id);
		person.setAddress("Endereço" + id);
		if(id%2==0)
			person.setGender("Masculino");
		else
			person.setGender("Feminino");
		return person;
	}
}
