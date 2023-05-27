package com.shoes_shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoes_shop.entities.SaleOrder;


public interface OrderRepo extends JpaRepository<SaleOrder,Integer>{
	@Query(value = "select * from tbl_saleorder where created_date LIKE %?1%",nativeQuery = true)
	public List<SaleOrder> findAllByCreatedDate(String date);
	public List<SaleOrder> findByStatus(boolean stt);
	public List<SaleOrder> findByCustomerActive(boolean stt);
	public SaleOrder findByStatusAndCustomerEmail(boolean stt,String email);
}
