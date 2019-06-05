package biz.korwin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.korwin.web.persistence.PersonRepository;
import biz.korwin.web.persistence.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	
	@Override
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}
	
	
	@Override
	public List<Person> findByLastName(String lastName) {
		
		return this.personRepository.findByLastName(lastName);
	}
	
	
	@Override
	public List<Person> findByFirstName(String firstName) {
		
		return this.personRepository.findByFirstName(firstName);
		
	}
	

	@Override
	public List<Person> findByName(String someName) {
		
		return this.personRepository.findByFirstNameOrLastName(someName, someName);
		
	}


	@Override
	public Person save(Person person) {
		
		return this.personRepository.save(person);
	}


}
