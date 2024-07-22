package com.myApp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.myApp.Dto.ItemsDTO;
import com.myApp.dao.ItemsDAO;
import com.myApp.service.ItemsService;
import com.myApp.utils.FileUploadUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MenuController {

	@Autowired
	private ItemsService itemService;
	
	@Autowired
	private ItemsDAO itemsDAO;
	
	 @GetMapping("/addItems")
	    public String getMenuItems(Model model) {
	        model.addAttribute("itemsdto", new ItemsDTO());
	        return "add-items";
	    }
	
	
	 @PostMapping("/add")  
	    public String addItems(@RequestParam("category") String category,
	                           @RequestParam("name") String name,
	                           @RequestParam("description") String description,
	                           @RequestParam("price") double price,
	                           @RequestParam("max_quantity") int max_quantity,
	                           @RequestParam("photo") MultipartFile photo,
	                           Model model) {
	        try {
	        	  String imagePath  = FileUploadUtil.saveFile(photo);       	
	           

	            ItemsDTO itemsDTO = new ItemsDTO();
	            itemsDTO.setCategory(category);
	            itemsDTO.setName(name);
	            itemsDTO.setDescription(description);
	            itemsDTO.setPrice(price);
	            itemsDTO.setMax_quantity(max_quantity);
	            itemsDTO.setPhoto_path(imagePath);

	            itemService.saveItems(itemsDTO);
	            //return "upload-success";
	            return "redirect:/Menu";
	        } catch (IOException e) {
	            model.addAttribute("error", "Failed to save the item. Please try again.");
	            return "add-items";
	        }
	    }

	  

	@GetMapping("/Menu")
	public String MainMenu(Model model)
	{
	      List<ItemsDTO> listItems = itemsDAO.getAllItems();
		   model.addAttribute("itemsList",listItems);
		 
		   return "Menu-List";
	}
	
	@GetMapping("/editItems/{item_id}")
	public String editMenuItems(@PathVariable("item_id") int item_id,Model model)
	{	
	     ItemsDTO	itemsDTO = itemService.getItemById(item_id);
		    model.addAttribute("itemsdto",itemsDTO);		
		return "edit-items";
	}
	
	@PostMapping("/updateItems")
   	public String updateItems(@ModelAttribute("itemsdto") ItemsDTO itemsDTO)
   	{
		itemsDAO.updateItems(itemsDTO);
		return "redirect:/Menu";
   	}
 	
	
	@GetMapping("/deleteItems/{item_id}")
	public String delItems(@PathVariable("item_id") int item_id)
	{
		//wriite logic to delete 
		
		itemsDAO.deleteItems(item_id);
		
		
		return "redirect:/Menu";
	}
}
