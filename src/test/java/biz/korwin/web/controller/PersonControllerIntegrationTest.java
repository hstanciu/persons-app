package biz.korwin.web.controller;

import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import biz.korwin.web.PersonsController;
import biz.korwin.web.TestConstants;
import biz.korwin.web.persistence.PersonRepository;
import biz.korwin.web.persistence.domain.Person;
import biz.korwin.web.service.PersonService;
import biz.korwin.web.util.Transformers;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonsController.class)
public class PersonControllerIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private PersonService personService;
    
    @Autowired
    private PersonRepository repository;
    
    @Test
    public void test() throws Exception {
         
        Person person = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0);
    
        mvc.perform(post("/persons/").contentType(MediaType.APPLICATION_JSON).content(Transformers.objectToByte(person)));
        
        List<Person> listOfPersons = repository.findAll();
        
        assertThat(listOfPersons).extracting(Person::getFirstName).containsOnly(TestConstants.PERSON_FIRST_NAME_0);
        
    }

}
