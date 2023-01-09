package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String Name;
	private LocalDate Birthday;	
	
	@OneToOne
	private Address MainAddress;
	
	@OneToMany
//	@JoinColumn(name = "person_id")
	private List<Address> Addresses;
	
	public Person() {
		super();
	}
	
	public Person(String name, LocalDate birthday) {
		super();
		Name = name;
		Birthday = birthday;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public LocalDate getBirthday() {
		return Birthday;
	}

	public void setBirthday(LocalDate birthday) {
		Birthday = birthday;
	}

	public Address getMainAddress() {
		return MainAddress;
	}

	public void setMainAddress(Address mainAddress) {
		MainAddress = mainAddress;
	}

	public List<Address> getAddresses() {
		return Addresses;
	}

	public void setAddresses(List<Address> addresses) {
		Addresses = addresses;
	}

	public void addAddresses(Address address) {
		Addresses.add(address);
	}
}
