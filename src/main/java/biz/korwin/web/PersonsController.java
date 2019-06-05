package biz.korwin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import biz.korwin.web.persistence.domain.Person;
import biz.korwin.web.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonsController {

	@Autowired
	private PersonService personService;

	@GetMapping("/")
	public List<Person> getPersons() {
		return (List<Person>) this.personService.findAll();
	}

	@PostMapping("/")
	void addPerson(@RequestBody Person person) {
		this.personService.save(person);
	}
	
	@GetMapping("/lastName/{lastName}")
	public List<Person> getPersonByLastName(@PathVariable("lastName") String lastName) {
		return (List<Person>) this.personService.findByLastName(lastName);
	}
	
	@GetMapping("/firstName/{firstName}")
	public List<Person> getPersonByFirstName(@PathVariable("firstName") String firstName) {
		return (List<Person>) this.personService.findByFirstName(firstName);
	}
	
	@GetMapping("/name/{name}")
	public List<Person> getPersonByAName(@PathVariable("name") String name) {
		return (List<Person>) this.personService.findByName(name);
	}
	

}
