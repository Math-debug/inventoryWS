package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.ProductCounting;

public interface ProductCountingRepository extends JpaRepository<ProductCounting, Long> {

}
