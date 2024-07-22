package com.myApp.dao;

import com.myApp.Dto.UserDTO;

public interface UserDAO {

	public void SaveUser(UserDTO userDTO);
	 public UserDTO getUserByUsername(String username);
	
}
