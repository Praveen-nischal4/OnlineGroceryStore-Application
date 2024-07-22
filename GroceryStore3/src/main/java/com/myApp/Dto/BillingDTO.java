package com.myApp.Dto;

public class BillingDTO {

	private int bill_id;
	private String bill_no;
	private String bill_date;
	private String order_id;
	private boolean coupon_code;
	private double total;
	
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public String getBill_no() {
		return bill_no;
	}
	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}
	public String getBill_date() {
		return bill_date;
	}
	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public boolean isCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(boolean coupon_code) {
		this.coupon_code = coupon_code;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "BillingDTO [bill_id=" + bill_id + ", bill_no=" + bill_no + ", bill_date=" + bill_date + ", order_id="
				+ order_id + ", coupon_code=" + coupon_code + ", total=" + total + "]";
	}
	
	
	
	
}
