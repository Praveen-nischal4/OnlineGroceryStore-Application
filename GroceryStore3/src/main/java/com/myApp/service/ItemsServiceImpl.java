package com.myApp.service;

import com.myApp.Dto.ItemsDTO;
import com.myApp.dao.ItemsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ItemsDAO itemsDAO;

	@Override
	public ItemsDTO getItemById(int item_id) {
		
		return itemsDAO.getItemsById(item_id);
	}

	@Override

    public void saveItems(ItemsDTO itemsDTO) {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        String username = user.getName();

        String sql = "INSERT INTO items (category, name, description, price, created_by, max_quantity, photo_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, itemsDTO.getCategory(), itemsDTO.getName(), itemsDTO.getDescription(), itemsDTO.getPrice(), username, itemsDTO.getMax_quantity(), itemsDTO.getPhoto_path());
    }



		
	

}
