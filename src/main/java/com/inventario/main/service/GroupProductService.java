package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.Counting;
import com.inventario.main.entities.GroupProduct;
import com.inventario.main.repositories.GroupProductRepository;

@Service
public class GroupProductService {
	@Autowired
	private GroupProductRepository repository;
	
	public List<GroupProduct> findAll() {
		return repository.findAll();
	}
	
	public GroupProduct findById(Long id) {
		Optional<GroupProduct> obj = repository.findById(id);
		return obj.get();
	}
	
	public GroupProduct insert (GroupProduct obj) throws Exception {
		List<GroupProduct> groups = repository.findByProductGroupName(obj.getProductGroupName());
		if(groups.isEmpty()) {
		return repository.save(obj);
		} else {
			throw new Exception("Grupo ja cadastrado");
		}
	}
}
