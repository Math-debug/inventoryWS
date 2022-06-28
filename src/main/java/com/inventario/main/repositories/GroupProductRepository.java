package com.inventario.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.GroupProduct;

public interface GroupProductRepository extends JpaRepository<GroupProduct, Long>{
	public List<GroupProduct> findByProductGroupName(String productGroupName);
}
