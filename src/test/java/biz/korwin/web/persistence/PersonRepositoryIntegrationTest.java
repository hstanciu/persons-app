package biz.korwin.web.persistence;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import biz.korwin.web.TestConstants;
import biz.korwin.web.persistence.domain.Person;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private PersonRepository personRepository;
    
    @Test
    public void findByFirstName() {
    	
        // GIVEN
        Person person = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0);
        entityManager.persist(person);
        entityManager.flush();
     
        // WHEN
        List<Person> foundPersonsList = personRepository.findByFirstName(person.getFirstName());
     
        // THEN
        assertThat(foundPersonsList)
        	.isNotNull()
        	.hasSize(1);
        
        assertThat(foundPersonsList.get(0))
        	.isNotNull()
            .hasFieldOrPropertyWithValue("firstName", person.getFirstName())
        	.hasFieldOrPropertyWithValue("lastName", person.getLastName());
    }
    
    
    @Test
    public void findByLastName() {
    	
        // GIVEN
        Person person = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0);
        entityManager.persist(person);
        entityManager.flush();
     
        // WHEN
        List<Person> foundPersonsList = personRepository.findByLastName(person.getLastName());
     
        // THEN
        assertThat(foundPersonsList)
        	.isNotNull()
        	.hasSize(1);
        
        assertThat(foundPersonsList.get(0))
        	.isNotNull()
            .hasFieldOrPropertyWithValue("firstName", person.getFirstName())
        	.hasFieldOrPropertyWithValue("lastName", person.getLastName());
    }
    
    
    @Test
    public void findPersonByNameMorePreciselyByLastName() {
    	
        // GIVEN
        Person person = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0);
        entityManager.persist(person);
        entityManager.flush();
     
        // WHEN
        List<Person> foundPersonsList = personRepository.findByFirstNameOrLastName(person.getLastName(), person.getLastName());
     
        // THEN
        assertThat(foundPersonsList)
        	.isNotNull()
        	.hasSize(1);
        
        assertThat(foundPersonsList.get(0))
        	.isNotNull()
            .hasFieldOrPropertyWithValue("firstName", person.getFirstName())
        	.hasFieldOrPropertyWithValue("lastName", person.getLastName());
    }
    
    
    @Test
    public void findPersonByNameMorePreciselyByFirstName() {
    	
        // GIVEN
        Person person = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0);
        entityManager.persist(person);
        entityManager.flush();
     
        // WHEN
        List<Person> foundPersonsList = personRepository.findByFirstNameOrLastName(person.getFirstName(), person.getFirstName());
     
        // THEN
        assertThat(foundPersonsList)
        	.isNotNull()
        	.hasSize(1);
        
        assertThat(foundPersonsList.get(0))
        	.isNotNull()
            .hasFieldOrPropertyWithValue("firstName", person.getFirstName())
        	.hasFieldOrPropertyWithValue("lastName", person.getLastName());
    }

}
