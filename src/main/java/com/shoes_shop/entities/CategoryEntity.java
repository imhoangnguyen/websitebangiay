package com.shoes_shop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_category")
public class CategoryEntity extends BaseEntity{
	@Column(name = "name",nullable = true)
	private String name;
	@Column(name = "description",nullable = true)
	private String description;
	@Column(name = "seo",nullable = true)
	private String seo;
	@Column(name = "categorytype",nullable = true)
	private String categorytype;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.LAZY)
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
	public void addProduct(ProductEntity product) {
		products.add(product);
		product.setCategory(this);
	}
	
	public void removeProduct(ProductEntity product) {
		products.remove(product);
		product.setCategory(null);
	}
	public String getName() {
		return name;
	}
	public List<ProductEntity> getProduct() {
		return products;
	}
	public void setProduct(List<ProductEntity> products) {
		this.products = products;
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
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	public boolean isDifferent(CategoryEntity cate) {
		if(!this.getName().equals(cate.getName()) || !this.getDescription().equals(cate.getDescription())
				||!this.getCategorytype().equals(cate.getCategorytype()))
		return true;
		return false;
	}
}
