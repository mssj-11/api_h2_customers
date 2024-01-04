package com.mss.springboot.web.app.controller;

import java.util.List;
import java.util.Optional;

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
	public ResponseEntity<CustomerEntity> get(@PathVariable Long id){
		Optional<CustomerEntity> customer = customerRespository.findById(id);
	    
	    if(customer.isPresent()) {
	        return ResponseEntity.ok(customer.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerEntity> put(@PathVariable Long id, @RequestBody CustomerEntity updatedCustomer){
	    Optional<CustomerEntity> existingCustomerOptional = customerRespository.findById(id);

	    if (existingCustomerOptional.isPresent()) {
	        CustomerEntity existingCustomer = existingCustomerOptional.get();
	        existingCustomer.setName(updatedCustomer.getName()); // Actualiza los campos necesarios
	        existingCustomer.setPhone(updatedCustomer.getPhone());

	        CustomerEntity savedCustomer = customerRespository.save(existingCustomer);
	        return ResponseEntity.ok(savedCustomer);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	
	@PostMapping
	public ResponseEntity<?> post(@RequestBody CustomerEntity input){
		CustomerEntity save = customerRespository.save(input);
		return ResponseEntity.ok(save);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
	    if (customerRespository.existsById(id)) {
	        customerRespository.deleteById(id);
	        return ResponseEntity.ok("Customer deleted");
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not exist");
	    }
	}

	
	
	
	
	
}
