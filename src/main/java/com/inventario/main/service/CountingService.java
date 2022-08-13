package com.inventario.main.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.Counting;
import com.inventario.main.repositories.CountingRepository;

@Service
public class CountingService {

	@Autowired
	private CountingRepository repository;
	
	public List<Counting> findAll() {
		return repository.findAll();
	}
	
	public Counting findById(Long id) {
		Optional<Counting> obj = repository.findById(id);
		return obj.get();
	}
	
	public Counting insert (Counting obj) {
		Instant date = Instant.now();
		obj.setStartCounting(date);
		return repository.save(obj);
	}
}
