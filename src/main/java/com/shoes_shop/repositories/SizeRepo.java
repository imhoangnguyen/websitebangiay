package com.shoes_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoes_shop.entities.SizeEntity;

public interface SizeRepo extends JpaRepository<SizeEntity,Integer>{
	public SizeEntity findByStatusAndSize(boolean stt,int size);
}
