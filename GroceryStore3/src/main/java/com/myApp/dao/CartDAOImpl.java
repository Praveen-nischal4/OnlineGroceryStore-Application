package com.myApp.dao;

import com.myApp.Dto.CartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public void SavetoCart(CartDTO cartDTO) {
		
		String myDate = getCurrentDateTimeString();
		
		
	Authentication username	 =SecurityContextHolder.getContext().getAuthentication();
	  String myUserName = username.getName().toString();
	  
	  String sql ="insert into cart(item_id,quantity,cur_date,myUsername)values(?,?,?,?)";
	  jdbcTemplate.update(sql,cartDTO.getItem_id(),cartDTO.getQuantity(), myDate,myUserName);

	}
	
	 private String getCurrentDateTimeString() {
	        Date now = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return sdf.format(now);
	    }

	


		
		
}
