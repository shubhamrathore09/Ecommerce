package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CardException;
import com.masai.exception.ItemsException;
import com.masai.exception.OrderException;
import com.masai.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PutMapping("/order")
	public ResponseEntity<String> orderItems(@RequestParam Integer customerId, @RequestParam Integer itemsId,@RequestParam Integer quantity) throws CardException, ItemsException{
		return new ResponseEntity<String>(orderService.placeOrder(customerId, itemsId, quantity),HttpStatus.OK);
	}
	
	@DeleteMapping("/order")
	public ResponseEntity<String> deleteOrder(@RequestParam Integer orderId) throws OrderException, ItemsException
	{
		return new ResponseEntity<String>(orderService.cancelOrderById(orderId, 1),HttpStatus.OK);
	}
	
	@PutMapping("/cardOrder")
	public ResponseEntity<String> OrderItemsFromCard(@RequestParam Integer customerId) throws CardException, ItemsException{
		return new ResponseEntity<String>(orderService.placeOrderForAllProductInCard(customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteCardOrder")
	public ResponseEntity<String> DeleteCardOrder(@RequestParam Integer orderId) throws OrderException, ItemsException{
		return new ResponseEntity<String>(orderService.cancelOrderPlacedByCard(orderId),HttpStatus.OK);
	}
}
