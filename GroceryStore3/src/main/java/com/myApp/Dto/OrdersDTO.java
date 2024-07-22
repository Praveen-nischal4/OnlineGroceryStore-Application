package com.myApp.Dto;

public class OrdersDTO {

	private String order_id;
	private String username;
	private int cart_id;
	private int item_id;
	private String item_name;
	private double price;
	private int quantity;
	private String order_date;
	private String delivery_date;
	private String delivery_address;
	private boolean couponApplied;
	private String email;
	private String mobile;

	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}
		
	
	public boolean isCouponApplied() {
		return couponApplied;
	}
	public void setCouponApplied(boolean couponApplied) {
		this.couponApplied = couponApplied;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	@Override
	public String toString() {
		return "OrdersDTO [order_id=" + order_id + ", username=" + username + ", cart_id=" + cart_id + ", item_id="
				+ item_id + ", item_name=" + item_name + ", price=" + price + ", quantity=" + quantity + ", order_date="
				+ order_date + ", delivery_date=" + delivery_date + ", delivery_address=" + delivery_address
				+ ", couponApplied=" + couponApplied + ", email=" + email + ", mobile=" + mobile + "]";
	}
	
	
	
}

