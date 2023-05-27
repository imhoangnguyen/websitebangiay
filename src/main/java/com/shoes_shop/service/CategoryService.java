package com.shoes_shop.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slugify.Slugify;
import com.shoes_shop.entities.CategoryEntity;
import com.shoes_shop.repositories.CategoryRepo;

@Service
public class CategoryService {
	@PersistenceContext protected EntityManager entityManager;
	//khai báo component do người dùng định nghĩa để sử dụng
	@Autowired
	private CategoryRepo categoryRepo;
	//lưu category
	public void save(CategoryEntity category) {
		if(category.getId() != null) {//nếu category này đã có trong database ta chỉ sửa thôi
			CategoryEntity oldCategory = categoryRepo.findById(category.getId()).get();
			if(categoryRepo.findById(category.getId()).get().isDifferent(category))
			{
				//cập nhật thời gian sửa
			    category.setUpdatedDate(LocalDateTime.now());
			}
			else 
				category.setUpdatedDate(oldCategory.getUpdatedDate());
				category.setCreatedDate(oldCategory.getCreatedDate());
		}
		else {
		    category.setCreatedDate(LocalDateTime.now());
		}
		//khởi tạo seo cho category
		Slugify slg = new Slugify();
		category.setSeo(slg.slugify(category.getName() +""+System.currentTimeMillis()));
		categoryRepo.save(category);
	}
}
