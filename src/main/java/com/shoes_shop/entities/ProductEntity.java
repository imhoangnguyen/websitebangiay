package com.shoes_shop.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

import com.ibm.icu.text.DecimalFormat;

@Entity
@Table(name = "tbl_products")
public class ProductEntity extends BaseEntity {
	@Column(name = "title", length = 500, nullable = false)
	private String title;

	@Column(name = "avatar", length = 500, nullable = false)
	private String avatar;
	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price;
	@Column(name = "price_sale", precision = 13, scale = 2, nullable = false)
	private BigDecimal price_sale;
	
	@Column(name = "producttype", nullable = false)
	private String producttype;

	@Column(name = "short_description", columnDefinition = "LONGTEXT", nullable = false)
	private String shortDes;
	@Column(name = "metarial_vs_skill",columnDefinition = "LONGTEXT")
	private String metarial_vs_skill;
	@Column(name = "code")
	private String code;
	@Column(name = "size", length = 100, nullable = false)
	private String size;
	@Lob
	@Column(name = "detail_description", nullable = false, columnDefinition = "LONGTEXT")
	private String shortDetails;

	@Column(name = "seo", nullable = false)
	private String seo;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<ProductImages> productImages = new ArrayList<ProductImages>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tbl_sizes_products",
	joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "size_id"))
	private List<SizeEntity> sizes = new ArrayList<SizeEntity>();
	//function of Size
	public void addProductSizes(SizeEntity size) {
		sizes.add(size);
		size.getProducts().add(this);
	}
	
	public void removeProductSizes(SizeEntity size) {
		sizes.remove(size);
		size.getProducts().remove(this);
	}
	//function of product
	public void addProductImages(ProductImages _productImages) {
		_productImages.setProduct(this);
		productImages.add(_productImages);
	}
	
	public void removeProductImages(ProductImages _productImages) {
		_productImages.setProduct(null);
		productImages.remove(_productImages);
	}
	
	public void removeProductAvatar() {
		this.setAvatar(null);
	}
	
	public void removeProductImages() {
		for(ProductImages productImages : productImages) {
			removeProductImages(productImages);
		}
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public String getShortDetails() {
		return shortDetails;
	}

	public void setShortDetails(String shortDetails) {
		this.shortDetails = shortDetails;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<ProductImages> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImages> productImages) {
		this.productImages = productImages;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getMetarial_vs_skill() {
		return metarial_vs_skill;
	}

	public void setMetarial_vs_skill(String metarial_vs_skill) {
		this.metarial_vs_skill = metarial_vs_skill;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public BigDecimal getPrice_sale() {
		return price_sale;
	}

	public void setPrice_sale(BigDecimal price_sale) {
		this.price_sale = price_sale;
	}
	
	
	
	public List<SizeEntity> getSizes() {
		return sizes;
	}

	public void setSizes(List<SizeEntity> sizes) {
		this.sizes = sizes;
	}
	
	
	
	public ProductEntity(String title, String avatar, BigDecimal price, BigDecimal price_sale, String producttype,
			String shortDes, String metarial_vs_skill, String code, String size, String shortDetails, String seo,
			CategoryEntity category, List<ProductImages> productImages, List<SizeEntity> sizes) {
		super();
		this.title = title;
		this.avatar = avatar;
		this.price = price;
		this.price_sale = price_sale;
		this.producttype = producttype;
		this.shortDes = shortDes;
		this.metarial_vs_skill = metarial_vs_skill;
		this.code = code;
		this.size = size;
		this.shortDetails = shortDetails;
		this.seo = seo;
		this.category = category;
		this.productImages = productImages;
		this.sizes = sizes;
	}

	
	
	public ProductEntity() {
	}

	public boolean compare(ProductEntity prd) {
		if(this.getCategory().getId() != prd.getCategory().getId() 
			||!this.getMetarial_vs_skill().equals(prd.getMetarial_vs_skill()) || this.getPrice() != prd.getPrice()
			||this.getProducttype() != prd.getProducttype()
			||!this.getShortDes().equals(prd.getShortDes()) || !this.getShortDetails().equals(prd.getShortDes())
			||!this.getSize().equals(prd.getSize()) ||!this.getTitle().equals(prd.getTitle()))	
		return true;
		return false;
	}
	
	public String getPriceFormat(BigDecimal priceConvert) {
		if(priceConvert != null) {
		 DecimalFormat df = new DecimalFormat("#,###");
		return df.format(priceConvert);}
		return "";
	}
	
}
