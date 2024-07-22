package com.myApp.dao;

import java.util.List;

import com.myApp.Dto.ItemsDTO;

public interface ItemsDAO {

	public void SaveItems(ItemsDTO itemsDTO);
	
	public List<ItemsDTO> getAllItems();
	public void deleteItems(int item_id);
	public ItemsDTO getItemsById(int item_id);
	public void updateItems(ItemsDTO itemsDTO);
}
