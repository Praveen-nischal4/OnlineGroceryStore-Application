package com.myApp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.myApp.Dto.CartItemDTO;
import com.myApp.Dto.OrdersDTO;
import com.myApp.Dto.UserDTO;
import com.myApp.dao.UserDAO;
import com.myApp.service.CartItemService;
import com.myApp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserDAO userDAO;
	
	 @RequestMapping("/proceedToPayment")
	    public String proceedToPayment(@RequestParam("totalPrice") Double totalPrice, @RequestParam("hiddenCoupon") String hiddenCoupon, HttpSession session) {
	        boolean applied = false;

	        if ("AB100".equals(hiddenCoupon) || "GROCERY100".equals(hiddenCoupon)) {
	             
	            applied = true;
	        }

	        session.setAttribute("myCoupon", applied);
	        session.setAttribute("finalPrice", totalPrice);

	        return "redirect:/paymentConfirmation";
	    }
	
	
	 @RequestMapping("/paymentConfirmation")
	    public String getConfirmation(Model model, HttpSession session) 
	  {
	        // Retrieve the final price from the session
	        Double finalPrice = (Double) session.getAttribute("finalPrice");
            String userName = (String) session.getAttribute("myUsername");
            boolean myCoupon = (Boolean)session.getAttribute("myCoupon");
            
           UserDTO address = userDAO.getUserByUsername(userName);      
             
              
            //get all the cart items in session
            
          List<CartItemDTO> cartItems= (List<CartItemDTO>)session.getAttribute("cartItems");
          
          if (cartItems != null && !cartItems.isEmpty()) {  
        	  
        	     String orderId = generateOrderId();      	  
            	   LocalDateTime myDate = LocalDateTime.now().plusDays(7);             	   
            	   
                   for(CartItemDTO items :cartItems)
                   {
                	   OrdersDTO orderDTO = new OrdersDTO();               	   
                       orderDTO.setOrder_id(orderId);             	   
                  	   orderDTO.setUsername(userName);
                	   orderDTO.setCart_id(items.getCart_id());
                	   orderDTO.setItem_id(items.getItem_id());
                	   orderDTO.setItem_name(items.getName());
                	   orderDTO.setPrice(items.getPrice());
                	   orderDTO.setQuantity(items.getQuantity());
                	   orderDTO.setOrder_date(items.getCur_date());
                	   orderDTO.setDelivery_date(myDate.toString());
                	   orderDTO.setDelivery_address(address.getAddress());
                	   orderDTO.setCouponApplied(myCoupon);
                	   orderDTO.setEmail(address.getEmail());
                	   orderDTO.setMobile(address.getMobile());
                	   orderService.PlacedOrder(orderDTO);             	  
                   }
                 
                   cartItemService.clearCart(userName);
               }
            
            
	        model.addAttribute("payment", finalPrice);
	        model.addAttribute("user", userName);
	        model.addAttribute("thisCoupon", myCoupon);
	        
	       session.setAttribute("EMAIL", address.getEmail());
	       session.setAttribute("MOBILE", address.getMobile());
	        
	     // Optionally remove session attributes if they are no longer needed
	        session.removeAttribute("myCoupon");
	        // session.removeAttribute("finalPrice");
	      
	       
	        
	        return "confirm-payment";
	    }
	 
	 private String generateOrderId() {
	        return "Gro" + UUID.randomUUID().toString().substring(0, 4);
	    }
}
