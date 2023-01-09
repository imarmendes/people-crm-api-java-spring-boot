package com.example.demo.controller;

import java.util.List;

import javax.management.InstanceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.DatabaseService;

@RestController
@RequestMapping("/fillDatabase")
public class DatabaseController {
	@Autowired
	private DatabaseService databaseService;
	@GetMapping
	public ResponseEntity<String> fillDatabase() throws InstanceNotFoundException 
	{
		databaseService.fillDatabase();
		return new ResponseEntity<String>(
				"Campos de pessoas e endereços adicionados ao banco de dados",
				HttpStatus.CREATED);
	}
}
