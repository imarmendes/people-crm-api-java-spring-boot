package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.model.Person;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository; 
	
	public List<Person> getAllPeople() {
		List<Person> lista = personRepository.findAll();
		return lista;
	}	
	
	public Optional<Person> getPersonById(Long id) throws InstanceNotFoundException {
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isEmpty()) {
			throw new InstanceNotFoundException("Pessoa não encontrada");
		}
		
		return person;
	}
	
	public Person createPerson(Person person) {
		Person personCreated = personRepository.save(person);
		return personCreated;
	}
	
	public Person updatePerson(Long id, Person person) throws InstanceNotFoundException {
		Optional<Person> personToUpdate = personRepository.findById(id);
		
		if(personToUpdate.isEmpty()) {
			throw new InstanceNotFoundException("Pessoa não encontrada");
		}
		
		person.setId(id);
		Person personUpdated = personRepository.save(person);
		
		return personUpdated;
	}
	
	public String deletePersonById(Long id) {
		personRepository.deleteById(id);
		return "Pessoas deletada";
	}

	public List<Address> getAllAddressesByPersonId(Long id) {
		List<Address> addresses = personRepository.findById(id).get().getAddresses(); 
		return addresses;
	}
		
	public Person setMainAddressToPerson(Long personId, Long addressId) throws InstanceNotFoundException {
		if(personRepository.findById(personId).isEmpty()) {
			throw new InstanceNotFoundException("Pessoa não encontrada");
		}
		
		if(addressRepository.findById(addressId).isEmpty()) {
			throw new InstanceNotFoundException("Endereço não encontrado");
		}
		
		Person personUpdated = personRepository.findById(personId).get();
		
		Address address = addressRepository.findById(addressId).get();
		
		personUpdated.setMainAddress(address);
				
		return personRepository.save(personUpdated);
	}
	
	public Person addAddressToPerson(Long personId, Long addressId) throws InstanceNotFoundException {
		if(personRepository.findById(personId).isEmpty()) {
			throw new InstanceNotFoundException("Pessoa não encontrada");
		}
		
		if(addressRepository.findById(addressId).isEmpty()) {
			throw new InstanceNotFoundException("Endereço não encontrado");
		}
		
		Person personUpdated = personRepository.findById(personId).get();
		
		Address address = addressRepository.findById(addressId).get();
		
		personUpdated.addAddresses(address);
		
		return personRepository.save(personUpdated);
	}
}
