package com.shoes_shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoes_shop.entities.CategoryEntity;
@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity,Integer>{
	public CategoryEntity findBySeoAndStatus(String seo,boolean stt);
	public List<CategoryEntity> findByStatus(boolean stt);
}
