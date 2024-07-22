package com.myApp.service;

import com.myApp.dao.CartItemDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private JdbcTemplate jdbcTemplate;	
	 
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Override
	public double getPrice(String username) {
		
	 String sql ="select sum(i.price * c.quantity) from items i join cart c on i.item_id = c.item_id where c.myUsername =?";
		return  jdbcTemplate.queryForObject(sql, new Object[]{username},Double.class);
	}


	@Override
	public void clearCart(String username) {
	 cartItemDAO.deleteAllCartItems(username);
		
	}

}
