package biz.korwin.web.controller;

import static com.jayway.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.response.Response;

import biz.korwin.web.exceptions.RestError;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonsControllerTest {
	
	@Test
	public void testWithWrongInexistingPath() {
		
	    Response response = when().get("localhost:8080/mumu");
	    RestError error = response.as(RestError.class);
	 
	    assertEquals(HttpStatus.NOT_FOUND, error.getStatus());
	    
	}

}
