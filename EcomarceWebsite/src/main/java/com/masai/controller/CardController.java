package com.masai.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CardException;
import com.masai.exception.CustomerException;
import com.masai.exception.ItemsException;
import com.masai.model.Items;
import com.masai.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@PutMapping("/card")
	public ResponseEntity<String> AddItemInCardHadler(@RequestParam Integer itemId,@RequestParam Integer customerId) throws ItemsException, CardException{
		return new ResponseEntity<String>(cardService.AddInCard(itemId, customerId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view")
	public ResponseEntity<Set<Items>> ViewAllCard(@RequestParam Integer id) throws CardException, CustomerException, ItemsException{
		return new ResponseEntity<Set<Items>>(cardService.ViewAllItemsInCard(id),HttpStatus.OK);
	}
	
	@PutMapping("/remove")
	public ResponseEntity<String> removeItemfromCard(@RequestParam Integer itemId, @RequestParam Integer customerId) throws ItemsException, CardException{
		return new ResponseEntity<String>(cardService.RemoveCard(itemId, customerId),HttpStatus.OK);
	}

}
