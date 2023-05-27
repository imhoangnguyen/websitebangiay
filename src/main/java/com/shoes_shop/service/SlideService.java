package com.shoes_shop.service;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shoes_shop.entities.SlideEntity;
import com.shoes_shop.repositories.SlideRepo;

@Service
public class SlideService {
	@Autowired
	SlideRepo slideRepo;
	public boolean save(MultipartFile image,SlideEntity slide) throws IllegalStateException, IOException {
		if(slide.getId() != null) {// if this slide had in db
			SlideEntity oldSlide = slideRepo.getOne(slide.getId());
			if(!image.isEmpty()) { //if admin uploads slide image
				new File("C:\\Users\\Duc\\Desktop\\shoe_shop_springboot_application\\com.shoes_shop.duc\\uploads\\slides\\" + oldSlide.getImage()).delete();
			}
			else {
				slide.setImage(oldSlide.getImage());
			}
			slide.setUpdatedDate(LocalDateTime.now());
		}
		if(!image.isEmpty()) {
			image.transferTo(new File("C:\\Users\\Duc\\Desktop\\shoe_shop_springboot_application\\com.shoes_shop.duc\\uploads\\slides\\"+image.getOriginalFilename())); 
			slide.setImage(image.getOriginalFilename());
		}
		slide.setCreatedDate(LocalDateTime.now());
		slideRepo.save(slide);
		return true;
	}
}
