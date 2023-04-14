package com.masai.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepo;
import com.masai.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer RagistorCustomer(Customer customer) throws CustomerException {
		Customer customer2=customerRepo.findByEmail(customer.getEmail());
		if(customer2==null) {
			Customer customer3=customerRepo.findByNumber(customer.getNumber());
			if(customer3==null) {
				return customerRepo.save(customer);
			}
			else {
				throw new CustomerException("This number already exist");
			}
		}
		else {
			throw new CustomerException("This email address already exist");
		}
	}

	@Override 
	public String changePassword(String oldp, String newp) throws CustomerException {
		
		return null;
	}

	@Override
	public String changeName(String name, String password) throws CustomerException {
		
		return null;
	}

	@Override
	public String deleteId(String password) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
