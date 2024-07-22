package com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myHomeController {

	@RequestMapping("/")
	public String getHome()
	{
		
		
		return "home";
	}
	
	@GetMapping("/about")
	public String getAbout()
	{
		return "about";
	}
	
	@GetMapping("/myContact")
	public String getContact()
	{
		return "contact-page";
	}
	
	
	@GetMapping("/restrict-access")
	public String accessDeniedt()
	{
		return "Access-denied";
	}
	
	@GetMapping("/myAppHomeMenu")
    public String myMenuHome()
    {
    	return "header2";
    }
}
