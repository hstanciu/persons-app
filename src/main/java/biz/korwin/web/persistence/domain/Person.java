package biz.korwin.web.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Size(min = 2, max = 50)
	@Column(name="FIRST_NAME")
    private String firstName;
	
	@Size(min = 2, max = 50)
	@Column(name="LAST_NAME")
    private String lastName;
    
    public Person() {
    	
    }
    
    
    public Person(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public Long getId() {
		return id;
	}
    
	
}
