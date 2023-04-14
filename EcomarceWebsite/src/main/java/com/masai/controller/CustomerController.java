package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> RagisterCustomer(@RequestBody Customer customer) throws CustomerException{
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		
		return new ResponseEntity<Customer>(customerService.RagistorCustomer(customer),HttpStatus.CREATED);
	}

}
