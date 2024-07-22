package com.myApp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.myApp.Dto.ItemsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ItemsDAOImpl implements ItemsDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void SaveItems(ItemsDTO itemsDTO) {
	
		Authentication myUsername = SecurityContextHolder.getContext().getAuthentication();
		 String username = myUsername.getName();
		
		String sql = "insert into items(category,name,description,price,created_by,max_quantity)values (?,?,?,?,?,?)";
		
	jdbcTemplate.update(sql,itemsDTO.getCategory(),itemsDTO.getName(),itemsDTO.getDescription(),itemsDTO.getPrice(),username,itemsDTO.getMax_quantity());
	}

	@Override
	public List<ItemsDTO> getAllItems() {
		
		String sql = "SELECT * FROM items";
	    List<ItemsDTO> items = jdbcTemplate.query(sql, new ItemRowMapper());
	    System.out.println("Fetched items: " + items); // Debugging line
	    return items;		
	
	}
	
	@Override
	public ItemsDTO getItemsById(int item_id) {

           String sql ="select * from items where item_id = ?";
           
		return jdbcTemplate.queryForObject(sql, new Object[] {item_id}, new ItemRowMapper());
	}
	
	@Override
	public void updateItems(ItemsDTO itemsDTO) {
		
		String sql1 = "UPDATE items SET category = ?, name = ?, description = ?, price = ?, max_quantity =? WHERE item_id = ?";
		jdbcTemplate.update(sql1, itemsDTO.getCategory(), itemsDTO.getName(), itemsDTO.getDescription(), itemsDTO.getPrice(),itemsDTO.getMax_quantity(), itemsDTO.getItem_id());
		}
	
	
	
	 private static class ItemRowMapper implements RowMapper<ItemsDTO> {
	        @Override
	        public ItemsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	            ItemsDTO item = new ItemsDTO();
	            item.setItem_id(rs.getInt("item_id")); // Auto-generated ID from DB
	            item.setCategory(rs.getString("category"));
	            item.setName(rs.getString("name"));
	            item.setDescription(rs.getString("description"));
	            item.setPrice(rs.getDouble("price"));
	            item.setMax_quantity(rs.getInt("max_quantity"));
	           item.setPhoto_path(rs.getString("photo_path"));
	            return item;
	        }
	    }

	@Override
	public void deleteItems(int item_id) {
		
		String sql ="delete from items where item_id=?";
		jdbcTemplate.update(sql,item_id);
		System.out.println("Deleted Record with Id :"+item_id);
		
	}




	
}
