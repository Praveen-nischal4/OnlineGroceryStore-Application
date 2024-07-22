package com.myApp.service;

import java.util.List;

import com.myApp.Dto.OrdersDTO;
import com.myApp.dao.OrdersDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrderService {

	@Autowired
	private OrdersDAO ordersDAO;
	
	@Override
	public void PlacedOrder(OrdersDTO ordersDTO) {
		
       ordersDAO.saveToOrders(ordersDTO);
	}

	@Override
	public List<OrdersDTO> getAllPlacedItems(String username) {
		// TODO Auto-generated method stub
		return ordersDAO.getAllPlacedItems(username);
	}

	@Override
	public List<OrdersDTO> getOrderById(String order_id) {
		// TODO Auto-generated method stub
		return ordersDAO.ordersById(order_id);
	}

	
}
