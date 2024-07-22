package com.myApp.Dto;

public class CartItemDTO {

	private int item_id;
	private String name;
	private double price;
	private int cart_id;
	private int quantity;
	private String cur_date;
	private double netprice;
	private int max_quantity;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
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
	public double getNetprice() {
		return netprice;
	}
	public void setNetprice(double netprice) {
		this.netprice = netprice;
	}	
	
	public int getMax_quantity() {
		return max_quantity;
	}
	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}
	
	
	@Override
	public String toString() {
		return "CartItemDTO [item_id=" + item_id + ", name=" + name + ", price=" + price + ", cart_id=" + cart_id
				+ ", quantity=" + quantity + ", cur_date=" + cur_date + ", netprice=" + netprice + ", max_quantity="
				+ max_quantity + "]";
	}
	
	
}
