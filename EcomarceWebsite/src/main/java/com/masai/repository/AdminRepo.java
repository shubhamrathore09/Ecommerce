package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	public Admin findByEmail(String email);
	public Admin findByNumber(String number);
}
