package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.service.AdminService;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/Admin")
	public ResponseEntity<Admin> RagistorAdmin(@RequestBody Admin admin) throws AdminException{
		return new ResponseEntity<Admin>(adminService.AddAdmin(admin),HttpStatus.CREATED);
	}

}
