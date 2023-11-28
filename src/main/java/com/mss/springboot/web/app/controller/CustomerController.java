package com.mss.springboot.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.springboot.web.app.entity.CustomerEntity;
import com.mss.springboot.web.app.repository.CustomerRepository;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRespository;

	
	@GetMapping
	public List<CustomerEntity> findAll(){
		return customerRespository.findAll();
	}
	
	@GetMapping("/{id}")
	public CustomerEntity get(@PathVariable Long id){
		return null;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody CustomerEntity input){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody CustomerEntity input){
		CustomerEntity save = customerRespository.save(input);
		return ResponseEntity.ok(save);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return null;
	}
	
	
	
	
	
}
