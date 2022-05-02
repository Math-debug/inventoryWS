package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}