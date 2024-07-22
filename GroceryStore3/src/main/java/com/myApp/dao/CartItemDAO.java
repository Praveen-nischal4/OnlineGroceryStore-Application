package com.myApp.dao;

import java.util.List;

import com.myApp.Dto.CartItemDTO;
import com.myApp.Dto.ItemsDTO;

public interface CartItemDAO {

	public List<CartItemDTO> getAllCartItem(String username);
	
	public void deleteFromCart(int cart_id);
	
	public CartItemDTO getCartItemById(int cart_id);
	
	public void updateItems(CartItemDTO cartItemDTO);
	
	public void deleteAllCartItems(String username);
    
	
}
