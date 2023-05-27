package com.shoes_shop.model;

import java.util.List;


public class ProductDataForCate {
	private List<ProductFilter> prdList;
	private int numberOfPage;
	public List<ProductFilter> getPrdList() {
		return prdList;
	}
	public void setPrdList(List<ProductFilter> prdList) {
		this.prdList = prdList;
	}
	public int getNumberOfPage() {
		return numberOfPage;
	}
	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}
	public ProductDataForCate(List<ProductFilter> prdList, int numberOfPage) {
		this.prdList = prdList;
		this.numberOfPage = numberOfPage;
	}
	public ProductDataForCate() {
	}
	
}	
