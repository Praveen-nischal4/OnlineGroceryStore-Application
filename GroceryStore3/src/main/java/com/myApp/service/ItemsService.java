package com.myApp.service;

import com.myApp.Dto.ItemsDTO;


public interface ItemsService {

	public ItemsDTO getItemById(int item_id);
	public void saveItems(ItemsDTO itemsDTO);
	
}
