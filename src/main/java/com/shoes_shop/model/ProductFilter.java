package com.shoes_shop.model;

import java.math.BigDecimal;

public class ProductFilter {
	private int id;
	private String title;
	private String avatar;
	private BigDecimal price;
	private BigDecimal price_sale;
	private String size;
	private String seo;
	private int category;
	private String color;
	private String producttype;
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getPrice_sale() {
		return price_sale;
	}
	public void setPrice_sale(BigDecimal price_sale) {
		this.price_sale = price_sale;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public ProductFilter(int id, String title, String avatar, BigDecimal price, BigDecimal price_sale, String size,
			String seo,int category,String color,String producttype) {
		super();
		this.id = id;
		this.title = title;
		this.avatar = avatar;
		this.price = price;
		this.price_sale = price_sale;
		this.size = size;
		this.seo = seo;
		this.category = category;
		this.color = color;
		this.producttype = producttype;
	}
	public ProductFilter() {
	}
	
}
