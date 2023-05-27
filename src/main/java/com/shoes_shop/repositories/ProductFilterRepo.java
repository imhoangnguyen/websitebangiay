package com.shoes_shop.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shoes_shop.entities.ProductEntity;

public interface ProductFilterRepo extends PagingAndSortingRepository<ProductEntity, Integer>{
	@Query("SELECT p FROM ProductEntity p WHERE CONCAT(p.title, ' ', p.price, ' ', p.shortDes, ' ', p.producttype) LIKE %?1% and Status = ?2")
	public Page<ProductEntity> search(String keyword,boolean stt,Pageable page);
	@Query("SELECT p FROM ProductEntity p WHERE p.category.id = ?1 and p.status = ?2")
	public Page<ProductEntity> search(int idCate,boolean stt,Pageable page);
}
