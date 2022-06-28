package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.ProductAddress;

public interface ProductAddressRepository extends JpaRepository<ProductAddress, Long>{

}
