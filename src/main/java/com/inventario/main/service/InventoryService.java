package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.Inventory;
import com.inventario.main.repositories.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository repository;
	
	public List<Inventory> findAll() {
		return repository.findAll();
	}
	
	public Inventory findById(Long id) {
		Optional<Inventory> obj = repository.findById(id);
		return obj.get();
	}
	
	public Inventory insert (Inventory obj) {
		return repository.save(obj);
	}
}
