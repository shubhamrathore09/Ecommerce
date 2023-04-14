package com.masai.service;

import java.util.List;

import com.masai.exception.ItemsException;
import com.masai.model.Items;

public interface ItemsService {
	
	public Items addItems(Items items)throws ItemsException;
	public Items IncreaseItemsQauntity(Integer itemId,Integer quantity)throws ItemsException;
	public Items DecreaseItemsQuantity(Integer itemsId,Integer quantity)throws ItemsException;
	public String deleteItems(Integer id)throws ItemsException;
	public List<Items> getSortedResultByField(String field,String direction)throws ItemsException;
	public List<Items> getAllItems()throws ItemsException;

}
