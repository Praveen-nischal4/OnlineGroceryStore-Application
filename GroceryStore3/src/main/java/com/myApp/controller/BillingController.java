package com.myApp.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.io.exceptions.IOException;
import com.myApp.Dto.BillingDTO;
import com.myApp.Dto.OrdersDTO;
import com.myApp.dao.BillingDAO;
import com.myApp.service.BillingService;
import com.myApp.service.MyBillingService;
import com.myApp.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BillingController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private MyBillingService myBillingService;
	
	@Autowired
	private BillingDAO billingDAO;
	
	@GetMapping("/billing")
	public String myBill(@RequestParam("order_id") String order_id, HttpSession session,Model model)
	{
		 // Check if the bill has already been generated
	    Boolean billGenerated = (Boolean) session.getAttribute("billGenerated_" + order_id);
	    if (billGenerated != null && billGenerated) {
	        // Redirect to an already generated bill page or show an error message
	        return "redirect:/alreadyGeneratedBill";
	    }
		
		
	    String username =(String)session.getAttribute("myUsername");
	     LocalDateTime date = LocalDateTime.now();
	    
	        List<OrdersDTO> myOrderItems = (List<OrdersDTO>)orderService.getOrderById(order_id);
	        System.out.println(myOrderItems);
	      
	       double total = calculateTotal(myOrderItems);
	       
	       //retrieve copon details 
	       
	      boolean coupon = getcouponStatus(myOrderItems);
	      
	      BillingDTO billing  = new BillingDTO();
	      
	      billing.setBill_no(UUID.randomUUID().toString().substring(0, 4));
	      billing.setBill_date(date.toString());
	      billing.setOrder_id(order_id);
	      billing.setCoupon_code(coupon);
	      billing.setTotal(total);
	      
	      //finally save billing details
	      billingService.saveBillDetails(billing);
	      
	      // Set the billGenerated attribute in session
	      session.setAttribute("billGenerated_" + order_id, true);
	      
	      //check for Id Exist or not
		int id = billing.getBill_id();
	      //adding all th data to model
		System.out.println("ID is "+id);
		
		
		 // Add attributes to model
	      model.addAttribute("OrderItems", myOrderItems);
	      model.addAttribute("billing", billing);
	      model.addAttribute("myUsername",username);
	      model.addAttribute("total", total);
	      
		return "myBill";
		
	}
	
	 @GetMapping("/downloadBill")
	    public void downloadBill(@RequestParam("order_id") String order_id, HttpSession session, HttpServletResponse response) throws IOException, java.io.IOException {
	        BillingDTO billing = billingDAO.getBillDetailsByOrderId(order_id);
	        List<OrdersDTO> myOrderItems = orderService.getOrderById(order_id);
	        byte[] pdfBytes = myBillingService.generateBillPdf(billing, myOrderItems, session);

	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=bill_" + billing.getBill_no() + ".pdf");
	        response.getOutputStream().write(pdfBytes);
	        response.getOutputStream().flush();
	    }
	
	public double calculateTotal(List<OrdersDTO> myOrderItems) {
	    double total = 0.0;
	    for (OrdersDTO orderItem : myOrderItems) {
	        double itemTotal = orderItem.getPrice() * orderItem.getQuantity();
	        total += itemTotal;
	    }
	    return total;
	}

	
	public boolean getcouponStatus(List<OrdersDTO> myOrderItems) {
	    for (OrdersDTO orderItem : myOrderItems) {
	        if (orderItem.isCouponApplied()) {
	            return true; // Found an order with a coupon applied
	        }
	    }
	    return false; // No order with a coupon applied found
	}

	
	
	@RequestMapping("/alreadyGeneratedBill")
	public String billGenrationErrorMessage()
	{
		return "bill-error";
	}
	
}
