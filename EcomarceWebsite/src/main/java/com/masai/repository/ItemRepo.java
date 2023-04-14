package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Items;

public interface ItemRepo extends JpaRepository<Items, Integer>,PagingAndSortingRepository<Items, Integer>{
	public List<Items> findByName(String name);
	public List<Items> findByPriceBetween(Integer low ,Integer high);
}
