package com.shoes_shop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;

import com.ibm.icu.text.DecimalFormat;

import java.math.BigDecimal;

public class Cart {
	private List<ProductCart> Cart = new ArrayList<ProductCart>();
	public List<ProductCart> getCart() {
		return Cart;
	}
	
	public void setCart(List<ProductCart> cart) {
		Cart = cart;
	}
	public BigDecimal getSumPrice() {
		BigDecimal sum = new BigDecimal(0);
		for(ProductCart p : Cart) {
			sum = sum.add(BigDecimal.valueOf(p.getProductAmount()).multiply(p.getProductPrice()));
		}
		return sum;
	}


	public Cart(List<ProductCart> cart) {
		this.Cart = cart;
	}
	public String getPriceFormat(BigDecimal priceConvert) {
		if(priceConvert != null) {
		 DecimalFormat df = new DecimalFormat("#,###");
		return df.format(priceConvert);}
		return "";
	}
	public ProductCart findByIdAndSize(int id,int size) {
		for(ProductCart p : Cart) {
			if(p.getProductCode() == id && p.getSize() == size) return p;
		}
		return null;
	}
	public Cart() {
	}	
}
