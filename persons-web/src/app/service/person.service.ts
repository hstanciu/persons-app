import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Person } from '../domain/person';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  
  private personsUrl: string;
 
  constructor(private http: HttpClient) {
    this.personsUrl = 'http://localhost:8080/persons/';
  }
 
  public findAll(): Observable<Person[]> {
    return this.http.get<Person[]>(this.personsUrl);
  }
 
  public findPersonByFirstName(firstName: string) {
    return this.http.get<Person[]>(this.personsUrl+'firstName/'+firstName);
  }
  
  public findPersonByLastName(lastName: string) {
    return this.http.get<Person[]>(this.personsUrl+'lastName/'+lastName);
  }
  
  public findPersonByName(name: string) {
    return this.http.get<Person[]>(this.personsUrl+'name/'+name);
  }
}
