package gov.senasa.agenda.ws.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.senasa.agenda.ws.rest.entities.Person;
import gov.senasa.agenda.ws.rest.entities.dao.PersonDAO;

@RestController
@RequestMapping("/personas")
public class PersonController {
	
	@Autowired
	PersonDAO personDAO;
	
	@GetMapping
	public ResponseEntity<List<Person>> listAllPersons(){
		List<Person> personas = personDAO.getAll();
		if(personas.isEmpty()) {
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(personas, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> createPerson(@RequestBody Person person){
		System.out.println("Creando una persona" + person);
		if (personDAO.isPersonExist(person)) {
			System.out.println("Ya existe la persona " + person);
			return new ResponseEntity<Void>(HttpStatus.CONFLICT); //Código de respuesta 409
		}
		personDAO.create(person);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
}
