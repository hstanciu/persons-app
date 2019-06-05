import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Person } from '../domain/person';
import { PersonService } from '../service/person.service';


@Component({
  selector: 'app-search-person',
  templateUrl: './search-person.component.html',
  styleUrls: ['./search-person.component.css']
})
export class SearchPersonComponent {

  person: Person;
  
  personsFound : Person[];
 
  constructor(private route: ActivatedRoute, private router: Router, private personService: PersonService) {
    this.person = new Person();
  }
 
  onSearch() {
  
  	 if(this.person.name){
	    this.personService.findPersonByName(this.person.name)
	    				  .subscribe(result => {
	    				  						this.personsFound = result;
	    				  						console.log(this.personsFound);
	    				  					   }
	    				  			);
	   return;
    }
    
    if(this.person.firstName){
	    this.personService.findPersonByFirstName(this.person.firstName)
	    				  .subscribe(result => {
	    				  						this.personsFound = result;
	    				  						console.log(this.personsFound);
	    				  					   }
	    				  			);
	    return;
    }
    
    if(this.person.lastName){
	    this.personService.findPersonByLastName(this.person.lastName)
	    				  .subscribe(result => {
	    				  						this.personsFound = result;
	    				  						console.log(this.personsFound);
	    				  					   }
	    				  			);
	   return;
    }
  }
  
  clear(event) {
   this.personsFound = null;
  }

}
