package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}

