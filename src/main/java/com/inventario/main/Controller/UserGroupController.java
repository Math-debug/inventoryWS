package com.inventario.main.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inventario.main.entities.UserGroup;
import com.inventario.main.service.UserGroupService;

@RestController
@RequestMapping(value = "/userGroup")
public class UserGroupController {
	
	@Autowired
	private UserGroupService service;
	
	@GetMapping
	public ResponseEntity<List<UserGroup>> findAll(){
		List<UserGroup> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserGroup> findById(@PathVariable Long id) {
		UserGroup obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<UserGroup> insert (@RequestBody UserGroup obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdUserGroup()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}