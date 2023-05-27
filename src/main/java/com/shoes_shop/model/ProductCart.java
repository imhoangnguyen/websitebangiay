package com.shoes_shop.model;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import com.ibm.icu.text.DecimalFormat;

public class ProductCart {
	private int productCode;
	private int productAmount = 0;
	private BigDecimal productPrice;
	private String productTitle;
	private String productAvatar;
	private String productSeo;
	private int size;
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public ProductCart() {
	}
	public ProductCart(int productCode, int productAmount, BigDecimal productPrice, String productTitle) {
		this.productCode = productCode;
		this.productAmount = productAmount;
		this.productPrice = productPrice;
		this.productTitle = productTitle;
	}
	public String getProductAvatar() {
		return productAvatar;
	}
	public void setProductAvatar(String productAvatar) {
		this.productAvatar = productAvatar;
	}
	public String getProductSeo() {
		return productSeo;
	}
	public void setProductSeo(String productSeo) {
		this.productSeo = productSeo;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getPriceFormat(BigDecimal priceConvert) {
		if(priceConvert != null) {
		 DecimalFormat df = new DecimalFormat("#,###");
		return df.format(priceConvert);}
		return "";
	}
}
