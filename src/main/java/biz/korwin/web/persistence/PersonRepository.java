package biz.korwin.web.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import biz.korwin.web.persistence.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository< Person, Long>{

	public List<Person> findAll();
	public List<Person> findByLastName(String lastName);
	public List<Person> findByFirstName(String firstName);
	public List<Person> findByFirstNameOrLastName(String fistName, String lastName);
	 
}