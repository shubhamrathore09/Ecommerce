package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;

public interface CustomerService {
	public Customer RagistorCustomer(Customer customer)throws CustomerException;
	public String changePassword(String oldp,String newp)throws CustomerException;
	public String changeName(String name,String password)throws CustomerException;
	public String deleteId(String password)throws CustomerException;
} 
