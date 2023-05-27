package com.shoes_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shoes_shop.entities.SaleOrderProducts;

@Repository
public interface SaleorderRepo extends JpaRepository<SaleOrderProducts,Integer>{
	
}
