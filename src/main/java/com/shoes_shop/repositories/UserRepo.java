package com.shoes_shop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoes_shop.entities.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
	public List<User> findByStatus(boolean stt);
	public User findByUsername(String username);
	public User findByEmail(String email);
}
