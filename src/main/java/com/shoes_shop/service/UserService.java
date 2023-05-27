package com.shoes_shop.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoes_shop.entities.EmailEntity;
import com.shoes_shop.entities.User;
import com.shoes_shop.repositories.EmailRepo;
import com.shoes_shop.repositories.UserRepo;

@Service
public class UserService {
	@PersistenceContext protected EntityManager entityManager;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private EmailRepo emailRepo;
	@Transactional 
	public int save(User user) {
			if(userRepo.findByUsername(user.getUsername()) != null) {
				return 1;
			}
			else if(userRepo.findByEmail(user.getEmail()) != null) 
			{
				return 2;
			}
			else {
				//hash password
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
				user.setPassword(encoder.encode(user.getPassword()));
				//set role
				userRepo.save(user);
				String sql = "INSERT INTO tbl_users_roles(user_id,role_id) VALUES (?1,?2)";
				entityManager.createNativeQuery(sql).setParameter(1, userRepo.findByUsername(user.getUsername()).getId())
				.setParameter(2, 10).executeUpdate();
				return 0;
				}
	}
	public boolean saveEmailNoti(String email) {
		EmailEntity eml = new EmailEntity();
		eml.setEmail(email);
		if(emailRepo.findByEmail(eml.getEmail()) != null) return false;
		else if(userRepo.findByEmail(eml.getEmail()) != null) return false;
		else {
			LocalDateTime now = LocalDateTime.now();  
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		    String formatDateTime = now.format(format); 
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    eml.setCreatedDate(LocalDateTime.parse(formatDateTime, formatter));
			emailRepo.save(eml);
			return true;
		}
}
}
