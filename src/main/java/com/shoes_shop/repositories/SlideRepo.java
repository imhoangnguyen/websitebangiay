package com.shoes_shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoes_shop.entities.SlideEntity;

public interface SlideRepo extends JpaRepository<SlideEntity,Integer>{
	public List<SlideEntity> findByStatus(boolean stt);
}
