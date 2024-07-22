package com.myApp.Dto;

import org.springframework.web.multipart.MultipartFile;

public class ItemsDTO {
	private int item_id;
	private String category;
	private String name;
	private String description;
	private double price;
	private int max_quantity;
	private MultipartFile photo;    
    private String photo_path;
    
	public String getCategory() {
		return category;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}		
	
	public int getMax_quantity() {
		return max_quantity;
	}
	public void setMax_quantity(int max_quantity) {
		this.max_quantity = max_quantity;
	}	
	
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	public String getPhoto_path() {
		return photo_path;
	}
	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}
	@Override
	public String toString() {
		return "ItemsDTO [item_id=" + item_id + ", category=" + category + ", name=" + name + ", description="
				+ description + ", price=" + price + ", max_quantity=" + max_quantity + ", photo=" + photo
				+ ", photo_path=" + photo_path + "]";
	}

	
}
