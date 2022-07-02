package com.inventario.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventario.main.entities.User;
import com.inventario.main.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User obj) throws Exception {
		obj.setPassword(new BCryptPasswordEncoder().encode(obj.getPassword()));
		List<User> users = repository.findByUserName(obj.getUsername());
		if (users.isEmpty()) {
			return repository.save(obj);
		}
		else {
			throw new Exception("username ja existe");
		}
	}

	public User findByUserName(String username) {
		return repository.findByUserName(username).get(0);
	}
}
