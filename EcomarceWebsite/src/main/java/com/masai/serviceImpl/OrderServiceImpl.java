package com.masai.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CardException;
import com.masai.exception.CustomerException;
import com.masai.exception.ItemsException;
import com.masai.exception.OrderException;
import com.masai.model.Card;
import com.masai.model.Customer;
import com.masai.model.Items;
import com.masai.model.Orders;
import com.masai.repository.CardRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ItemRepo;
import com.masai.repository.OrderRepo;
import com.masai.service.CardService;
import com.masai.service.ItemsService;
import com.masai.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	private CardRepo cardRepo;

	@Override
	public String placeOrder(Integer customerId, Integer itemId,Integer quantity) throws CardException, ItemsException {
		
		Optional<Customer> customerOpt=customerRepo.findById(customerId);
		
		if(customerOpt.isPresent()) {
			
			Optional<Items> itemsOpt=itemRepo.findById(itemId);
			
			if(itemsOpt.isPresent()) {

				Items items=itemsOpt.get();
				
				if(items.getQuantity()>=quantity) {
					
					itemsService.DecreaseItemsQuantity(itemId, quantity);
					
					Orders orders=new Orders();
					
					orders.setDateTime(LocalDateTime.now());
					
					orders.setQuantity(quantity);
					
					orders.getItems().add(items);
					
					orders.setCustomer(customerOpt.get());
					
					orderRepo.save(orders);
					
					return "Order has been placed";
					
				}
				
				else {
					throw new ItemsException("Quantity of items no present right");
				}
			}
			else {
				throw new ItemsException("No Item available by that id");
			}
		}
		throw new CardException("Wrong customer id");
	}

	@Override
	public String placeOrderForAllProductInCard(Integer customerId) throws CardException, ItemsException {
		 Optional<Customer> opt=customerRepo.findById(customerId);
		 
		 if(opt.isPresent()) {
			 
			 Customer customer=opt.get();
			 
			 Card card=customer.getCard();
			 
			 if(card.getItemsList().size()>0) {
			 
			 Orders orders=new Orders();
			 
			 orders.setDateTime(LocalDateTime.now());
			 
			 orders.setCustomer(customer);
			 
			 orders.setQuantity(1);
			 
			 orders.getItems().addAll(card.getItemsList());
			 
			 for(Items i:card.getItemsList()) {
				 itemsService.DecreaseItemsQuantity(i.getId(), 1);
			 }
			 
			 orderRepo.save(orders);
			 
			 for(Items i:card.getItemsList()) {
				 cardService.RemoveCard(i.getId(), customerId);
			 }
			 
			 return "placed";
			 }
			 else {
				 throw new CardException("no items are available in card");
			 }
			 
		 }
		 
		throw new CardException("Wrong Customer Id");

	}

	@Override
	public String cancelOrderById(Integer orderId,Integer ItemId) throws OrderException, ItemsException {
		
		Optional<Orders> opt=orderRepo.findById(orderId);
		
		if(opt.isPresent()) {
			
			itemsService.IncreaseItemsQauntity(ItemId,opt.get().getQuantity());

			orderRepo.deleteById(orderId);
			
			return "order has been deleted";
		}
		
		else {
			throw new OrderException("No Order present by that id");
		}
		
	}

	@Override
	public String cancelOrderPlacedByCard(Integer OrderId) throws OrderException, ItemsException {
		
		
		List<Items> list=orderRepo.getAllItem(OrderId);
		
		for(Items i:list) {
			itemsService.IncreaseItemsQauntity(i.getId(), 1);
		}
		return "Order deleted";
	}

	@Override
	public List<Orders> viewOrders(Integer customerId) throws OrderException {
		
		  
		
		return null;
	}
	
}
