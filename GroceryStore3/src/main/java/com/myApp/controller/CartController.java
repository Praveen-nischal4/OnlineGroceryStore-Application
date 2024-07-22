package com.myApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.myApp.Dto.CartDTO;
import com.myApp.Dto.CartItemDTO;
import com.myApp.Dto.ItemsDTO;
import com.myApp.dao.CartDAO;
import com.myApp.dao.CartItemDAO;
import com.myApp.dao.ItemsDAO;
import com.myApp.service.CartItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private ItemsDAO itemsDAO;
	
	@GetMapping("/addToCart/{item_id}")
	public String generateCart(@PathVariable("item_id") int item_id, @ModelAttribute("cartdto") CartDTO cartDTO)
	{
		System.out.println(cartDTO);
		return "myCart";
	}
	
	//this code is for add item
	
	@PostMapping("/viewCart")
	 public String AddandviewCartItem(CartDTO cartDTO,Model model)
	 {
		//write logic to save or add item in cart
//		System.out.println(cardDTO);
//		
//
//	
//		ItemsDTO itemDTO = itemsDAO.getItemsById(itemDTO.getItem_id());
//		 int maxQ =itemDTO.getMax_quantity();
//		 
//		 if(itemDTO.getMax_quantity()>=cardDTO.getQuantity())
//		 {
//		cartDAO.SavetoCart(cardDTO);
//		 }
		
		//retrieve eleemnt based on id 
		
		ItemsDTO itemsDTO = itemsDAO.getItemsById(cartDTO.getItem_id());
		
		 if (itemsDTO == null) {
		        model.addAttribute("error", "Item not found.");
		        return "redirect:/menu";
		    }
		
		 		//get max quantity
		 
		 int maxQ = itemsDTO.getMax_quantity();
		 
		 //compare quantity and max quantity
		 if(cartDTO.getQuantity() <=maxQ)
		 {
			 cartDAO.SavetoCart(cartDTO);
			 

		        // Update the quantity in inventory
		        itemsDTO.setMax_quantity(maxQ - cartDTO.getQuantity());
		        itemsDAO.updateItems(itemsDTO);

		       
		        model.addAttribute("success", "Item added");
			 
		 }else {
		        model.addAttribute("error", "Insufficient stock for item: " + itemsDTO.getName());
		    }
				
		return "redirect:/Menu";
		
	 }
	
	
	@GetMapping("/myCart")
	public String myItemList(Model model,HttpSession session)
	{
	  Authentication user =	SecurityContextHolder.getContext().getAuthentication();
	  
	  String username = user.getName().toString();
	  
	     List<CartItemDTO> myCartListItems  =   cartItemDAO.getAllCartItem(username);
	      System.out.println("Cart Items :"+myCartListItems);
	  
	  model.addAttribute("myCartItem", myCartListItems);
		model.addAttribute("myUsername", username);
		
	 
		int len = myCartListItems.size();
		
		model.addAttribute("length", len);
		
				
		if(len >0)
		{
		double price = cartItemService.getPrice(username);
		
		
		
		System.out.println(price);
		
		model.addAttribute("TotalPrice", price);
		
		//store the totalprice in session
		
		session.setAttribute("TotalPrice", price);
		session.setAttribute("myUsername",username);
		session.setAttribute("cartItems", myCartListItems);
		}
		
		return "Cart-List";
	}
	
	@GetMapping("/deleteCartItems/{cart_id}")
	public String deleteItems(@PathVariable("cart_id") int cart_id,CartItemDTO cartItemDTO)
	{
	       cartItemDTO = cartItemDAO.getCartItemById(cart_id);
	       
	       if(cartItemDTO !=null)                                   //check cart-item is not null
	       {
		
		       cartItemDAO.deleteFromCart(cart_id);                            //delete cart-item 
		       
		       System.out.println("Item Deleted with "+cart_id);
		 
		 int maxQ = cartItemDTO.getMax_quantity();                                    //get max quantity
		 
		 cartItemDTO.setMax_quantity(maxQ + cartItemDTO.getQuantity());                //update max quantity
		
		 cartItemDAO.updateItems(cartItemDTO);             //finally update the quantity
	       }
		 
		return "redirect:/myCart";			
	}
	
}
