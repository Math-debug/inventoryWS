package com.inventario.main.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.inventario.main.entities.User;
import com.inventario.main.repositories.UserRepository;

@Repository
public class UserAuthentication implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List <User> users = userRepository.findByUserName(username);
		User user = null;
		for(User userArray : users) {
				user = userArray;
		}
		if(user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return user;
	}
	
}
