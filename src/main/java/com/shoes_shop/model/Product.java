package com.shoes_shop.model;

public class Product {
	private int id ;
	private int size;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Product() {
	}
	public Product(int id) {
		this.id = id;
	}
}
