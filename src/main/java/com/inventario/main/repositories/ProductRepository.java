package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
