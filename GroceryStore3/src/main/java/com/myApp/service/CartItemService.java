package com.myApp.service;

public interface CartItemService {
	
	public double getPrice(String username);
	public void clearCart(String username);
}
