package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ItemsException;
import com.masai.model.Items;
import com.masai.service.ItemsService;

@RestController
@RequestMapping("/Items")
public class ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	
	@PostMapping("/item")
	public ResponseEntity<Items> AddItemHandler(@RequestBody Items items) throws ItemsException{
		return new ResponseEntity<Items>(itemsService.addItems(items),HttpStatus.CREATED);
	}
}
