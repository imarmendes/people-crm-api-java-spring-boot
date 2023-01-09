package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String PublicPlace;
	private String Cep;
	private Long Number;
	
	public Address() { 
		super();
	}
	
	public Address(String publicPlace, String cep, Long number) {
		super();
		PublicPlace = publicPlace;
		Cep = cep;
		Number = number;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public Long getNumber() {
		return Number;
	}
	public void setNumber(Long number) {
		Number = number;
	}

	public String getPublicPlace() {
		return PublicPlace;
	}
	public void setPublicPlace(String publicPlace) {
		PublicPlace = publicPlace;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}

}
