package com.myApp.dao;

import com.myApp.Dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void SaveUser(UserDTO userDTO) {
		
		String sql = "insert into users values(?,?,?,?,?,?)";
		String sql1 ="insert into authorities values(?,?)";
		
	       jdbcTemplate.update(sql,userDTO.getUsername(),userDTO.getPassword(),userDTO.getEnabled(),userDTO.getAddress(),userDTO.getEmail(),userDTO.getMobile());
	       
	       jdbcTemplate.update(sql1,userDTO.getUsername(),"User");
	}

	 @SuppressWarnings("deprecation")
	public UserDTO getUserByUsername(String username)
	 {
	        String sql = "SELECT username, password, enabled, address,email,mobile FROM users WHERE username = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
	            UserDTO userDTO = new UserDTO();
	            userDTO.setUsername(rs.getString("username"));
	            userDTO.setPassword(rs.getString("password"));
	            userDTO.setEnabled(rs.getInt("enabled"));
	            userDTO.setAddress(rs.getString("address"));
	            userDTO.setEmail(rs.getString("email"));
	            userDTO.setMobile(rs.getString("mobile"));
	            return userDTO;
	        });
	    }
	
	
}
