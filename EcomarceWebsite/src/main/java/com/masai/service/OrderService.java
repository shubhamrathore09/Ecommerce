package com.masai.service;

import java.util.List;

import com.masai.exception.CardException;
import com.masai.exception.CustomerException;
import com.masai.exception.ItemsException;
import com.masai.exception.OrderException;
import com.masai.model.Customer;
import com.masai.model.Orders;

public interface OrderService {
	
	public String placeOrder(Integer customerId,Integer itemId,Integer quantity)throws CardException,ItemsException;
	public String cancelOrderById(Integer orderId,Integer ItemId)throws OrderException,ItemsException;
	public String placeOrderForAllProductInCard(Integer customerId)throws CardException,ItemsException;
	public String cancelOrderPlacedByCard(Integer OrderId)throws OrderException,ItemsException; 
	public List<Orders> viewOrders(Integer customerId)throws OrderException;
	
}
