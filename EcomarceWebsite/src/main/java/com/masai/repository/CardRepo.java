package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.model.Card;
import com.masai.model.Items;

public interface CardRepo extends JpaRepository<Card, Integer>{
	
	
}
