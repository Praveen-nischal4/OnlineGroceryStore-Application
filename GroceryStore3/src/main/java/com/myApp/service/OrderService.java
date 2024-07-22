package com.myApp.service;

import java.util.List;

import com.myApp.Dto.OrdersDTO;

public interface OrderService {

	public void PlacedOrder(OrdersDTO ordersDTO);
	public List<OrdersDTO> getAllPlacedItems(String username);
	public List<OrdersDTO> getOrderById(String order_id);
	
}
