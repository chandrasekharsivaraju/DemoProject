package com.scs.ecommerce.resource;

import java.util.List;

import javax.validation.Valid;

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

import com.scs.ecommerce.model.Customer;
import com.scs.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		
		return  ResponseEntity.ok(customerService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer) {
		Customer savedCustomer = customerService.create(customer);
		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> update(@PathVariable Long id,@RequestBody Customer customer) {
		
		return ResponseEntity.ok(customerService.update(id,customer));
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
