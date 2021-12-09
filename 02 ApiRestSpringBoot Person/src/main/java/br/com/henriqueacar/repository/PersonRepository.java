package br.com.henriqueacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.henriqueacar.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	

}