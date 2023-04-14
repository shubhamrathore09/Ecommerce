package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Items;
import com.masai.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{
	
	@Query("select i from Orders o INNER JOIN items i where o.id=?1")
	public List<Items> getAllItem(Integer id);
	
}
