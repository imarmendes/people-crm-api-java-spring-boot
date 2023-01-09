package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPeople() {
		List<Person> lista = personService.getAllPeople();
		return new ResponseEntity<List<Person>>(lista,  HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Person>> getPersonById(@PathVariable Long id) throws InstanceNotFoundException  {
		try {
			Optional<Person> person = personService.getPersonById(id);
			return new ResponseEntity<Optional<Person>>(person,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Optional<Person>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person personCreated = personService.createPerson(person);
		return new ResponseEntity<Person>(personCreated,  HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) throws InstanceNotFoundException {
		try {
			Person personUpdated = personService.updatePerson(id, person);			
			return new ResponseEntity<Person>(personUpdated,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
		personService.deletePersonById(id);
		return new ResponseEntity<String>("Pessoas deletada", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}/address")
	public ResponseEntity<List<Address>> getAllAddressesByPersonId(@PathVariable Long id) {
		try {
			List<Address> addresses = personService.getAllAddressesByPersonId(id);
			return new ResponseEntity<List<Address>>(addresses,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Address>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{personId}/mainaddress/{addressId}")
	public ResponseEntity<Person>  setMainAddressToPerson(@PathVariable Long personId, @PathVariable Long addressId) {
		try {
			Person personUpdated = personService.setMainAddressToPerson(personId, addressId);
			return new ResponseEntity<Person>(personUpdated,  HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{personId}/addaddress/{addressId}")
	public ResponseEntity<Person>  addAddressToPerson(@PathVariable Long personId, @PathVariable Long addressId) {
		try {
			Person personUpdated = personService.addAddressToPerson(personId, addressId);
			return new ResponseEntity<Person>(personUpdated,  HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<Person>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
