package biz.korwin.web.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import biz.korwin.web.TestConstants;
import biz.korwin.web.persistence.PersonRepository;
import biz.korwin.web.persistence.domain.Person;

@RunWith(SpringRunner.class)
public class PersonServiceImplIntegrationTest {
	
	@TestConfiguration
    static class PersonServiceImplTestContextConfiguration {
  
        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }
 
    @Autowired
    private PersonService personService;
 
    @MockBean
    private PersonRepository personRepository;
    
    
    @Test
    public void testFindByFirstName() {
    	
    	// GIVEN
    	
    	// Setting the stub for findByFirstName()
    	Person person0 = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0 );
    	List<Person> oneInList = new ArrayList<>(1);
    	oneInList.add(person0);
     
    	// Setting the stub for findByFirstName()
        Mockito.when(
        			personRepository
        				.findByFirstName(person0.getFirstName())
        			)
        		.thenReturn(
        				oneInList
        			);
        
    	
    	// WHEN
        String firstName = TestConstants.PERSON_FIRST_NAME_0;
        List<Person> personsList = personService.findByFirstName(firstName);
        
        // THEN
        assertThat(personsList)
        	.isNotNull().hasSize(1);
      
        assertThat(personsList.get(0))
          	.hasFieldOrPropertyWithValue("firstName", TestConstants.PERSON_FIRST_NAME_0);
         
        assertThat(personsList.get(0))
         	.hasFieldOrPropertyWithValue("firstName", TestConstants.PERSON_LAST_NAME_0);
     
    }
    
    
    @Test
    public void testFindByLastName() {
    	
    	// GIVEN
    	
    	// Setting the stub for findByLastName()
    	Person person0 = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0 );
    	List<Person> oneInList = new ArrayList<>(1);
    	oneInList.add(person0);
     
    	// Setting the stub for findByLastName()
        Mockito.when(
        			personRepository
        				.findByLastName(person0.getLastName())
        			)
        		.thenReturn(
        				oneInList
        			);
        
    	
    	// WHEN
        String lastName = TestConstants.PERSON_LAST_NAME_0;
        List<Person> personsList = personService.findByLastName(lastName);
        
        // THEN
        assertThat(personsList)
        	.isNotNull().hasSize(2);
      
        assertThat(personsList.get(0))
          	.hasFieldOrPropertyWithValue("lastName", TestConstants.PERSON_LAST_NAME_0);
         
        assertThat(personsList.get(1))
         	.hasFieldOrPropertyWithValue("lastName", TestConstants.PERSON_LAST_NAME_1);
     
    }
    
    
    @Test
    public void testFindByNameByFirstName() {
    	
    	// GIVEN
    	
    	// Setting the stub for findByFirstNameOrLastName()
    	Person person0 = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0 );
        Person person1 = new Person(TestConstants.PERSON_FIRST_NAME_1, TestConstants.PERSON_LAST_NAME_1 );
        Person person2 = new Person(TestConstants.PERSON_FIRST_NAME_2, TestConstants.PERSON_LAST_NAME_2 );
        
    	List<Person> manyInList = new ArrayList<>(3);
    	manyInList.add(person0);
    	manyInList.add(person1);
    	manyInList.add(person2);
    	
    	// Setting the stub for findByFirstNameOrLastName()
        Mockito.when(
        			personRepository
        				.findByFirstNameOrLastName(person0.getFirstName(), person0.getFirstName())
        			)
        		.thenReturn(
        				manyInList.subList(0, 1)
        			);
        
    	// WHEN
        String firstName = TestConstants.PERSON_FIRST_NAME_0;
        List<Person> personsList = personService.findByName(firstName);
        
        // THEN
        assertThat(personsList)
        	.isNotNull().hasSize(1);
      
        assertThat(personsList.get(0))
          	.hasFieldOrPropertyWithValue("firstName", TestConstants.PERSON_FIRST_NAME_0);
         
        assertThat(personsList.get(0))
         	.hasFieldOrPropertyWithValue("lastName", TestConstants.PERSON_LAST_NAME_0);
     
    }
    
    
    @Test
    public void testFindByNameByLastName() {
    	
    	// GIVEN
    	
    	// Setting the stub for findByFirstNameOrLastName()
    	Person person0 = new Person(TestConstants.PERSON_FIRST_NAME_0, TestConstants.PERSON_LAST_NAME_0 );
        Person person1 = new Person(TestConstants.PERSON_FIRST_NAME_1, TestConstants.PERSON_LAST_NAME_1 );
        Person person2 = new Person(TestConstants.PERSON_FIRST_NAME_2, TestConstants.PERSON_LAST_NAME_2 );
        
    	List<Person> manyInList = new ArrayList<>(3);
    	manyInList.add(person0);
    	manyInList.add(person1);
    	manyInList.add(person2);
    	
    	// Setting the stub for findByFirstNameOrLastName()
        Mockito.when(
        			personRepository
        				.findByFirstNameOrLastName(person0.getLastName(), person0.getLastName())
        			)
        		.thenReturn(
        				manyInList.subList(0, 2)
        			);
        
    	// WHEN
        String lastName = TestConstants.PERSON_LAST_NAME_0;
        List<Person> personsList = personService.findByName(lastName);
        
        // THEN
        assertThat(personsList)
        	.isNotNull().hasSize(2);
      
        assertThat(personsList.get(0))
          	.hasFieldOrPropertyWithValue("lastName", TestConstants.PERSON_LAST_NAME_0);
         
        assertThat(personsList.get(1))
         	.hasFieldOrPropertyWithValue("lastName", TestConstants.PERSON_LAST_NAME_0);
     
    }

}
