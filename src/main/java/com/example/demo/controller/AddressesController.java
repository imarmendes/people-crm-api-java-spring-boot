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
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressesController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping
	public ResponseEntity<List<Address>> getAllAdresses() {
		List<Address> listAddress = addressService.getAllAdresses();
		return new ResponseEntity<List<Address>>(listAddress,  HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Address>> getAddressById(@PathVariable Long id) {
		try {
			Optional<Address> address = addressService.getAddressById(id);
			return new ResponseEntity<Optional<Address>>(address,  HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Optional<Address>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		try {
			Address addressCreated = addressService.createAddress(address);
			return new ResponseEntity<Address>(addressCreated,  HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddressById(@PathVariable Long id, @RequestBody Address address) throws InstanceNotFoundException {
		Address addressCreated = addressService.updateAddressById(id, address);
		return new ResponseEntity<Address>(addressCreated,  HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddressById(@PathVariable Long id) {
		String deleteText = addressService.deleteAddressById(id);
		return new ResponseEntity<String>(deleteText, HttpStatus.NO_CONTENT);
	}

}
