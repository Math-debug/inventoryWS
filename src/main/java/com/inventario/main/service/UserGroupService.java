package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.UserGroup;
import com.inventario.main.repositories.UserGroupRepository;

@Service
public class UserGroupService {

	@Autowired
	private UserGroupRepository repository;
	
	public List<UserGroup> findAll() {
		return repository.findAll();
	}
	
	public UserGroup findById(Long id) {
		Optional<UserGroup> obj = repository.findById(id);
		return obj.get();
	}
	
	public UserGroup insert (UserGroup obj) {
		return repository.save(obj);
	}
}
