package com.shoes_shop.Controller.indexcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shoes_shop.entities.CategoryEntity;
import com.shoes_shop.repositories.CategoryRepo;

@Controller
public abstract class BaseController {//class chung cho tất cả các controller đều có category
	@Autowired
	CategoryRepo categoryRepo;
	@ModelAttribute("categories")
	public List<CategoryEntity> getCategories() {
		return categoryRepo.findByStatus(true);
	}
}
