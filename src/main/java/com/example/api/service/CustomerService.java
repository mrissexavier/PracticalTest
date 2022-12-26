package com.example.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.api.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public Page<Customer> listAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer add (Customer customer) {
		return repository.save(customer);
	}

	public Customer update (Customer customer){
		return repository.save(customer);
	}

	public void deleteById(Long id){
		repository.deleteById(id);
	}

}