package com.masai.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.ItemsException;
import com.masai.model.Items;
import com.masai.repository.ItemRepo;
import com.masai.service.ItemsService;

@Service
public class ItemServiceImpl implements ItemsService{
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public Items addItems(Items items) throws ItemsException {
		return itemRepo.save(items);
	}

	@Override
	public String deleteItems(Integer id) throws ItemsException {
		Optional<Items> opt=itemRepo.findById(id);
		if(opt.isEmpty()) {
			throw new ItemsException("wrong items id");
		}
		Items items=opt.get();
		itemRepo.delete(items);
		return "items has been deleted";
	}

	@Override
	public List<Items> getSortedResultByField(String field, String direction) throws ItemsException {
		Sort sort=direction.toUpperCase().equals("DESC")?Sort.by(field):Sort.by(field).ascending();
		List<Items> items=itemRepo.findAll(sort);
		return items;
	}

	@Override
	public List<Items> getAllItems() throws ItemsException {
		List<Items> list=itemRepo.findAll();
		if(list==null) {
			throw new ItemsException("No Items");
		}
		return list;
	}

	@Override
	public Items IncreaseItemsQauntity(Integer itemId, Integer quantity) throws ItemsException {
		Optional<Items> opt=itemRepo.findById(itemId);
		if(opt.isEmpty()) {
			throw new ItemsException("item is not available");
		}
		Items items=opt.get();
		items.setQuantity(items.getQuantity()+quantity);
		
		return itemRepo.save(items);
	}

	@Override
	public Items DecreaseItemsQuantity(Integer itemsId, Integer quantity) throws ItemsException {
		Optional<Items> opt=itemRepo.findById(itemsId);
		if(opt.isEmpty()) {
			throw new ItemsException("item is not available");
		}
		Items items=opt.get();
		items.setQuantity(items.getQuantity()-quantity);
		
		return itemRepo.save(items);
	}
	
}
