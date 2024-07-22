package com.myApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myApp.Dto.CartDTO;
import com.myApp.Dto.CartItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	@Override
	public List<CartItemDTO> getAllCartItem(String username) {
		
	 Authentication myUser = SecurityContextHolder.getContext().getAuthentication();
	 String myUsername =myUser.getName().toString();
		
	 String sql = "SELECT i.item_id, i.name , i.price AS BasePrice ," +
             " c.cart_id, c.quantity, c.cur_date AS Date, " +
             "(i.price * c.quantity) AS netprice ," + "i.max_quantity " +
             "FROM items i " +
             "JOIN cart c ON i.item_id = c.item_id " +
             "WHERE c.myUsername = ?";		
		
		
		return jdbcTemplate.query(sql, new Object[]{myUsername},new CartItemRowMapper());
	}	
	
	
	@Override
	public CartItemDTO getCartItemById(int cart_id) {
		
		String sql = "SELECT i.item_id, i.name , i.price AS BasePrice ," +
	             " c.cart_id, c.quantity, c.cur_date AS Date, " +
	             "(i.price * c.quantity) AS netprice ," + "i.max_quantity " +
	             "FROM items i " +
	             "JOIN cart c ON i.item_id = c.item_id " +
	             "WHERE c.cart_id = ?";		
	
		return jdbcTemplate.queryForObject(sql, new Object[] {cart_id},new CartItemRowMapper());
	}
	
	
	@Override
	public void updateItems(CartItemDTO cartItemDTO) {
	
		String mySql="update items set max_quantity =?  where item_id =?";
		jdbcTemplate.update(mySql,cartItemDTO.getMax_quantity(),cartItemDTO.getItem_id());
		
	}	
	

	class CartItemRowMapper implements RowMapper<CartItemDTO> {

		@Override
		public CartItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CartItemDTO cartItem = new CartItemDTO();
			cartItem.setItem_id(rs.getInt("item_id"));
			cartItem.setName(rs.getString("name"));
			cartItem.setPrice(rs.getDouble("BasePrice"));			
			cartItem.setCart_id(rs.getInt("cart_id"));
			cartItem.setQuantity(rs.getInt("quantity"));
			cartItem.setCur_date(rs.getString("Date"));
			cartItem.setNetprice(rs.getDouble("netprice"));
			cartItem.setMax_quantity(rs.getInt("max_quantity"));
			return cartItem;
		}
		
	}

	@Override
	public void deleteFromCart(int cart_id) {
	
		String sqlQuery ="delete cart  from cart join items on items.item_id = cart.item_id where cart_id =? ";
		jdbcTemplate.update(sqlQuery,cart_id);
		System.out.println("Item removed with "+cart_id);
	}


	@Override
	public void deleteAllCartItems(String username) {
		
		//Authentication myUser = SecurityContextHolder.getContext().getAuthentication();
		//String myUsername =myUser.getName().toString();
		
		String sqlQry = "delete cart from cart join items on items.item_id = cart.item_id where myUsername =?";
		
		//String sqlQry ="delete from cart where myUsername = ?";
		
		jdbcTemplate.update(sqlQry,username);
		System.out.println("Cart Cleared");
		
		
		
		
		
		
	}


	
	
	
	
}
