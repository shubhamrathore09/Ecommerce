package com.masai.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CardException;
import com.masai.exception.CustomerException;
import com.masai.exception.ItemsException;
import com.masai.model.Card;
import com.masai.model.Customer;
import com.masai.model.Items;
import com.masai.repository.CardRepo;
import com.masai.repository.CustomerRepo;
import com.masai.repository.ItemRepo;
import com.masai.service.CardService;

@Service
public class CardServiceImpl implements CardService{
	
	@Autowired
	private CardRepo cardRepo;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String AddInCard(Integer itemId,Integer customerId) throws ItemsException, CardException {
	
		Optional<Items> itemOpt=itemRepo.findById(itemId);
		if(itemOpt.isPresent()) {
			Optional<Customer> opt=customerRepo.findById(customerId);
			
			if(opt.isEmpty()) {
				throw new CardException("wrong id");
			}
			else {
			Customer customer=opt.get();
			Card card=customer.getCard();
			card.getItemsList().add(itemOpt.get());
			customer.setCard(card);
			customerRepo.save(customer);
			return "Added";
			}
			
		}
		
	throw new ItemsException("item is not available");
	}

	@Override
	public String RemoveCard(Integer itemId,Integer customerId) throws ItemsException, CardException {
		

		Optional<Card> opt=cardRepo.findById(customerId);
		if(opt.isPresent()) {

			Card card=opt.get();

			Set<Items> set=card.getItemsList();
			List<Items> list=new ArrayList<>(set);
			for(Items i:list) {
				if(i.getId()==itemId) {
					list.remove(i);
					break;
				}
			}
			Set<Items> set2=new HashSet<>(list);
			
			card.setItemsList(null);

			card.setItemsList(set2);

			cardRepo.save(card);
			
			return "Removed";
		}
		
		throw new CardException("wrong card id");
	}
	
	@Override
	public Set<Items> ViewAllItemsInCard(Integer customerId) throws CardException, CustomerException, ItemsException {
		Card card=customerRepo.getCard(customerId);
	    Set<Items> items=card.getItemsList();
		return items;
	}

}
