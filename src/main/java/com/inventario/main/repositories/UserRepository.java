package com.inventario.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUserName(String userName);
}