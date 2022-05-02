package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.CountAssignment;
import com.inventario.main.repositories.CountAssignmentRepository;

@Service
public class CountAssignmentService {

	@Autowired
	private CountAssignmentRepository repository;
	
	public List<CountAssignment> findAll() {
		return repository.findAll();
	}
	
	public CountAssignment findById(Long id) {
		Optional<CountAssignment> obj = repository.findById(id);
		return obj.get();
	}
	
	public CountAssignment insert (CountAssignment obj) {
		return repository.save(obj);
	}
}
