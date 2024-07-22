package com.myApp.Dto;

public class CartDTO {

	private int cart_id;
	private int item_id;
	private int quantity;
	private String cur_date;
	private String myUsername;
	
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCur_date() {
		return cur_date;
	}
	public void setCur_date(String cur_date) {
		this.cur_date = cur_date;
	}
	public String getMyUsername() {
		return myUsername;
	}
	public void setMyUsername(String myUsername) {
		this.myUsername = myUsername;
	}
	@Override
	public String toString() {
		return "CartDTO [item_id=" + item_id + ", quantity=" + quantity + ", cur_date=" + cur_date + ", myUsername="
				+ myUsername + "]";
	}
	
	
}
