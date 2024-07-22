package com.myApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.myApp.Dto.OrdersDTO;
import com.myApp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/orderdItems")
	public String getOrders(Model model,HttpSession session)
	{
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		
		String username = user.getName().toString();
		
		 
		
	 List<OrdersDTO> cartItemsList = orderService.getAllPlacedItems(username);
	 System.out.println(cartItemsList);
	 
	  model.addAttribute("orderItems", cartItemsList);
	  model.addAttribute("size", cartItemsList.size());
	
		
		return "my-orders";
	}
	

	
	
}
