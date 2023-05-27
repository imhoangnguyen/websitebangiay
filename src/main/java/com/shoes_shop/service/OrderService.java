package com.shoes_shop.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_shop.entities.ProductEntity;
import com.shoes_shop.entities.SaleOrder;
import com.shoes_shop.entities.SaleOrderProducts;
import com.shoes_shop.model.Cart;
import com.shoes_shop.model.ProductCart;
import com.shoes_shop.repositories.OrderRepo;
import com.shoes_shop.repositories.ProductRepo;
import com.shoes_shop.repositories.SaleorderRepo;
import com.shoes_shop.repositories.UserRepo;


@Service
public class OrderService {
	@PersistenceContext protected EntityManager entityManager;
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private SaleorderRepo saleorderRepo;
	@Autowired
	private ProductRepo productRepo;
	@Transactional 
	public void saveOrder(Cart cart,SaleOrder order,int id) {
		LocalDateTime now = LocalDateTime.now();  
	    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	    String formatDateTime = now.format(format); 
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		order.setCreatedDate(LocalDateTime.parse(formatDateTime, formatter));
		order.setUser_id(id);
		order.setTotal(cart.getSumPrice());
		order.setCode("sp"+id);
		order.setCustomerEmail(userRepo.findById(id).get().getEmail());
		orderRepo.save(order);
		for(ProductCart prC :  cart.getCart()) {
			SaleOrderProducts sop = new SaleOrderProducts();
			sop.setSaleOrder(order);
			sop.setProduct(productRepo.getOne(prC.getProductCode()));
			sop.setCreatedDate(LocalDateTime.parse(formatDateTime, formatter));
			sop.setQuality(prC.getProductAmount());
			sop.setSize(prC.getSize());
			saleorderRepo.save(sop);
		}
	}
}
