package com.example.demo.service;

import java.time.LocalDate;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Person;


@Service
public class DatabaseService {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private AddressService addressService; 
	
	
	public void fillDatabase() throws InstanceNotFoundException
	{
		Person person1 = new Person ("Pedro", LocalDate.parse("1986-11-08"));
		Person person2 = new Person ("João", LocalDate.parse("1950-01-23"));
		Person person3 = new Person ("Antônio", LocalDate.parse("1960-02-20"));
		Person person4 = new Person ("José", LocalDate.parse("2014-12-07"));
		Person person5 = new Person ("Jorge", LocalDate.parse("2012-10-01"));
		
		personService.createPerson(person1);
		personService.createPerson(person2);
		personService.createPerson(person3);
		personService.createPerson(person4);
		personService.createPerson(person5);
		
		
		Address address1 = new Address ("Flores", "62900-000", (long)12345);
		Address address2 = new Address ("Russas", "62900-000", (long)54321);
		Address address3 = new Address ("Ceará", "62900-000", (long)78945);
		Address address4 = new Address ("Umari", "62900-000", (long)85236);
		Address address5 = new Address ("Caixa d'agua", "62900-000", (long)456987);
		Address address6 = new Address ("Casa amarela", "62900-000", (long)74126);
		Address address7 = new Address ("Posto de saúde", "62900-000", (long)96385);
		Address address8 = new Address ("Mercadinho dois irmãos", "62900-000", (long)65489);
		
		addressService.createAddress(address1);
		addressService.createAddress(address2);
		addressService.createAddress(address3);
		addressService.createAddress(address4);
		addressService.createAddress(address5);
		addressService.createAddress(address6);
		addressService.createAddress(address7);
		addressService.createAddress(address8);
	}
}
