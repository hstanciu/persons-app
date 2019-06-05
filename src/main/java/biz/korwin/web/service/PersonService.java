package biz.korwin.web.service;

import java.util.List;

import biz.korwin.web.persistence.domain.Person;

public interface PersonService {

	public List<Person> findAll();

	public List<Person> findByLastName(String lastName);

	public List<Person> findByFirstName(String firstName);

	public List<Person> findByName(String name);
	
	public Person save(Person person);

}
