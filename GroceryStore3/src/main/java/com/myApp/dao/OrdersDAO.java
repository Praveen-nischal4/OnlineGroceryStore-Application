package com.myApp.dao;

import java.util.List;

import com.myApp.Dto.OrdersDTO;

public interface OrdersDAO {

	public void saveToOrders(OrdersDTO ordersDTO);
	public List<OrdersDTO> getAllPlacedItems(String username);
	public List<OrdersDTO> ordersById(String order_id);
	
}
