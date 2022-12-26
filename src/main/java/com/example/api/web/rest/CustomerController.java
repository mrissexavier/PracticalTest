package com.example.api.web.rest;

import com.example.api.exception.BadRequestException;
import com.example.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Page<Customer>> list(Pageable pageable){
		return ResponseEntity.ok(service.listAll(pageable));
			}


	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return service.findById(id)
				.orElseThrow(() -> new BadRequestException("Customer not found"));
	}

	@PostMapping("/add")
	public ResponseEntity<Customer> add(@Valid @RequestBody Customer customer){
		Customer newCustomer = service.add(customer);
		return new ResponseEntity(newCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> update(@Valid @RequestBody Customer customer){

		Customer updateCustomer = service.update(customer);
		return new ResponseEntity(updateCustomer, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return new ResponseEntity(HttpStatus.OK);
	}


}
