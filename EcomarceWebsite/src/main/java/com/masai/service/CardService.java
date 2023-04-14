package com.masai.service;

import java.util.List;
import java.util.Set;

import com.masai.exception.CardException;
import com.masai.exception.CustomerException;
import com.masai.exception.ItemsException;
import com.masai.model.Items;

public interface CardService {
	public String AddInCard(Integer itemId,Integer customerId)throws ItemsException,CardException;
	public String RemoveCard(Integer itemId,Integer customerId)throws ItemsException,CardException;
	public Set<Items> ViewAllItemsInCard(Integer customerId)throws CardException,CustomerException,ItemsException;
}
