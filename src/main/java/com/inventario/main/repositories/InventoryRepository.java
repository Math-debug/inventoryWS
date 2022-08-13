package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventario.main.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	@Query("select i from Inventory i where i.idInventory = (select max(i.idInventory) from Inventory i )")
	public Inventory inventoryStatus();
}

