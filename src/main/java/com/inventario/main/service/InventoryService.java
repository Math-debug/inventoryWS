package com.inventario.main.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.Counting;
import com.inventario.main.entities.Inventory;
import com.inventario.main.repositories.CountingRepository;
import com.inventario.main.repositories.InventoryRepository;
import com.inventario.main.socket.SocketController;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository repository;
	@Autowired
	private CountingRepository countingRepository;
	@Autowired
	private SocketController socketController;
	
	public List<Inventory> findAll() {
		return repository.findAll();
	}
	
	public Inventory findById(Long id) {
		Optional<Inventory> obj = repository.findById(id);
		return obj.get();
	}
	public Inventory lastInventory() {
		Inventory obj = repository.inventoryStatus();
		return obj;
	}
	
	public Boolean status() {
		Inventory obj = repository.inventoryStatus();
		if(obj != null && obj.getFinishInventory() == null) {
			socketController.inventoryStatus(true);
			return true;
		} else {
			socketController.inventoryStatus(false);
			return false;
		}
	}
	
	public Inventory insert (Inventory obj) {
		status();
		Instant date = Instant.now();
		obj.setStartInventory(date);
		return repository.save(obj);
	}
	public void finish() {
		Inventory obj = repository.inventoryStatus();
		Instant date = Instant.now();
		obj.setFinishInventory(date);
		repository.save(obj);
		List<Counting> countings= countingRepository.findOpenCounting();
		for(Counting counting : countings) {
			Instant fim = Instant.now();
			counting.setFinishCounting(fim);
			countingRepository.save(counting);
		}
		status();
	}
}
