package com.shoes_shop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table ( name = "tbl_slides")
public class SlideEntity extends BaseEntity{
	@Column(name = "url",nullable = false)
	private String url;
	@Column(name = "title",nullable = false)
	private String title;
	@Column(name = "image",nullable = false)
	private String image;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public SlideEntity(String url, String title, String image) {
		this.url = url;
		this.title = title;
		this.image = image;
	}
	public SlideEntity() {
	}
	
}
