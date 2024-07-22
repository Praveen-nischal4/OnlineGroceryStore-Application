package com.myApp.service;

import com.myApp.Dto.BillingDTO;
import com.myApp.dao.BillingDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	private BillingDAO billingDAO;
	
	
	@Override
	public void saveBillDetails(BillingDTO billingDTO) {
	
		billingDAO.saveBillDetails(billingDTO);
		
	}

	
	
}
