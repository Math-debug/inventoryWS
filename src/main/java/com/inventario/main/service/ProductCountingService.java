package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.ProductCounting;
import com.inventario.main.repositories.ProductCountingRepository;

@Service
public class ProductCountingService {
	
	@Autowired
	private ProductCountingRepository repository;
	
	public List<ProductCounting> findAll() {
		return repository.findAll();
	}
	
	public ProductCounting findById(Long id) {
		Optional<ProductCounting> obj = repository.findById(id);
		return obj.get();
	}
	
	public ProductCounting insert (ProductCounting obj) {
		return repository.save(obj);
	}
}
