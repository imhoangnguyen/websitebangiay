package com.shoes_shop.model;

import javax.servlet.http.HttpServletRequest;

public class ProductSearching {
	private static int SIZE_ITEM_ON_PAGE = 1;
	private String name;
	private String seoProduct;
	private String seoCategory;
	private Integer categoryId;
	private Integer currentPage;
	private Integer id;
	public void parseRequest(final HttpServletRequest request) {
		Integer currentPage = null;

		String strPage = request.getParameter("page");
		if (strPage != null && !strPage.isEmpty()) {
			currentPage = Integer.parseInt(strPage);
		}

		this.setCurrentPage(currentPage);
	}
	public static int getSIZE_ITEM_ON_PAGE() {
		return SIZE_ITEM_ON_PAGE;
	}
	public static void setSIZE_ITEM_ON_PAGE(int sIZE_ITEM_ON_PAGE) {
		SIZE_ITEM_ON_PAGE = sIZE_ITEM_ON_PAGE;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeoProduct() {
		return seoProduct;
	}
	public void setSeoProduct(String seoProduct) {
		this.seoProduct = seoProduct;
	}
	public String getSeoCategory() {
		return seoCategory;
	}
	public void setSeoCategory(String seoCategory) {
		this.seoCategory = seoCategory;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
