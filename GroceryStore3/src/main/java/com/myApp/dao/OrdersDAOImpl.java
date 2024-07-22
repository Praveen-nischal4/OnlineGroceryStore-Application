package com.myApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.myApp.Dto.OrdersDTO;
import com.myApp.dao.OrdersDAOImpl.ItemListMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAOImpl implements OrdersDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveToOrders(OrdersDTO ordersDTO) {
		String sql = "INSERT INTO orders (order_id,username,cart_id,item_id,item_name,price,quantity,order_date,delivery_date,delivery_address,couponApplied,mobile,email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
        jdbcTemplate.update(sql, ordersDTO.getOrder_id(), ordersDTO.getUsername(),ordersDTO.getCart_id(), ordersDTO.getItem_id(),ordersDTO.getItem_name(), ordersDTO.getPrice(), ordersDTO.getQuantity(), ordersDTO.getOrder_date(), ordersDTO.getDelivery_date(), ordersDTO.getDelivery_address(),ordersDTO.isCouponApplied() ? 1 : 0,ordersDTO.getEmail(),ordersDTO.getMobile());
    }
	@Override
	public List<OrdersDTO> getAllPlacedItems(String username) {
		
	
	
		//String sql ="select * from orders where username = ?";
		
		String sql = "SELECT * FROM orders WHERE username = ? ";
		
	 List<OrdersDTO> myOrderedItemList = jdbcTemplate.query(sql, new Object[]{username}, new ItemListMapper());
		
		return myOrderedItemList;
	}
	
	@Override
	public List<OrdersDTO> ordersById(String order_id) {
		
		String sql ="select * from orders where order_id = ?";
		  List<OrdersDTO>  myOrderdListById = jdbcTemplate.query(sql, new Object[] {order_id},new ItemListMapper());
		return myOrderdListById;
	}
	
	
	class ItemListMapper implements RowMapper<OrdersDTO> {

		@Override
		public OrdersDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			OrdersDTO orderDTO = new OrdersDTO();
			orderDTO.setOrder_id(rs.getString("order_id"));
			orderDTO.setUsername(rs.getString("username"));
			orderDTO.setCart_id(rs.getInt("cart_id"));
			orderDTO.setItem_id(rs.getInt("item_id"));
			orderDTO.setItem_name(rs.getString("item_name"));
			orderDTO.setPrice(rs.getDouble("price"));
			orderDTO.setQuantity(rs.getInt("quantity"));
			orderDTO.setOrder_date(rs.getString("order_date"));
			orderDTO.setDelivery_date(rs.getString("delivery_date"));
			orderDTO.setDelivery_address(rs.getString("delivery_address"));
			orderDTO.setCouponApplied(rs.getInt("couponApplied")==1);
			orderDTO.setEmail(rs.getString("email"));
			orderDTO.setMobile(rs.getString("mobile"));
		
			return orderDTO;
		}
		
	}



	
	
}
