package com.myApp.dao;

import com.myApp.Dto.BillingDTO;

public interface BillingDAO {

	public void saveBillDetails(BillingDTO billingDTO);
	 BillingDTO getBillDetailsByOrderId(String orderId);
}
