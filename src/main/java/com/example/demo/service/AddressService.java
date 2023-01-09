package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;


@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository; 
	
	public List<Address> getAllAdresses() {
		List<Address> listAddress = addressRepository.findAll();
		return listAddress;
	}	
	
	public Optional<Address> getAddressById(Long id) throws InstanceNotFoundException {
		Optional<Address> address = addressRepository.findById(id);
		
		if(address.isEmpty()) {
			throw new InstanceNotFoundException("Endereço não encontrado");
		}
		
		return address;
	}
	
	public Address createAddress(Address address) {
		var addressCreated = addressRepository.save(address);
		return addressCreated;
	}
	
	public Address updateAddressById(Long id, Address address) throws InstanceNotFoundException {
		Optional<Address> addressToUpdate = addressRepository.findById(id);
		
		if(addressToUpdate.isEmpty()) {
			throw new InstanceNotFoundException("Endereço não encontrado");
		}
		
		address.setId(id);
		Address addressUpdated = addressRepository.save(address);
		return addressUpdated;
	}
	
	public String deleteAddressById(Long id) {
		addressRepository.deleteById(id);
		return "Endereço deletado";
	}

}
