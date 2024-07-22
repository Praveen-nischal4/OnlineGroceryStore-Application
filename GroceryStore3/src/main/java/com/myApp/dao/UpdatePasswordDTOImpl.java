package com.myApp.dao;

import com.myApp.Dto.UpdatePasswordDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UpdatePasswordDTOImpl implements UpdatePasswordDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	   @Autowired
	    private PasswordEncoder passwordEncoder;
	
	@Override
	public void updatePassword(UpdatePasswordDTO updatePasswordDTO) {
	
		 Authentication user = SecurityContextHolder.getContext().getAuthentication();			
		
		if(user !=null)
		{
			 String username = user.getName().toString();
			 
			 //verify current password
			 
			 String sql= " select password from users where username =?";
			 String currentpassword = jdbcTemplate.queryForObject(sql, new Object[] {username}, String.class);
			 
			 if(passwordEncoder.matches(updatePasswordDTO.getPassword(), currentpassword))
			 {
				 if(updatePasswordDTO.getNewPassword().equals(updatePasswordDTO.getRetypePassword()))
				    {
					 
					 String encryptedPassword = passwordEncoder.encode(updatePasswordDTO.getNewPassword());
					 String updateSQL = "update users set password = ? where username = ?";
					 jdbcTemplate.update(updateSQL, encryptedPassword, username);
				 }else
				 {
					 throw new RuntimeException("New Password and Retype PAssword does'nt match ");
				 }
			 }else
			 {
				 throw new RuntimeException(" Current password is not correct");
			 }
			
		}else
		{
			throw new RuntimeException(" User doen't exists");
		}
	}

}
