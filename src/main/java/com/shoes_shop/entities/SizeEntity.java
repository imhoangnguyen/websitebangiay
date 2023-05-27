package com.shoes_shop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_size")
public class SizeEntity extends BaseEntity{
	@Column(name = "size")
	private int size;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sizes")
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public SizeEntity(int size) {
		this.size = size;
	}

	public SizeEntity() {
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
}
