package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Card;
import com.masai.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	public Customer findByEmail(String email);
	public Customer findByNumber(String number);
	
	@Query("select c.card from Customer c where c.id=?1")
	public Card getCard(Integer id);
}
