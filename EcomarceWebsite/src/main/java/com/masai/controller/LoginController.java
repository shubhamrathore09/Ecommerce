package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.Customer;
import com.masai.repository.AdminRepo;
import com.masai.repository.CustomerRepo;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Autowired
	private AdminRepo adminRepo;
	
	@GetMapping("/login")
	public ResponseEntity<String> LoginHandler(Authentication authentication) throws LoginException
	{
		Customer customer=customerRepo.findByEmail(authentication.getName());
		
		if(customer==null) {
			
			Admin admin=adminRepo.findByEmail(authentication.getName());
			
			if(admin==null) {
				throw new LoginException("wrong details");
			}
			
			else {
				return new ResponseEntity<String>("succefully login",HttpStatus.ACCEPTED);
			}
		}
		else {
			return new ResponseEntity<String>("succesfully login",HttpStatus.ACCEPTED);
		}
		
	}
}
