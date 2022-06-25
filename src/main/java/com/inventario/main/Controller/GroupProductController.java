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

import com.inventario.main.entities.GroupProduct;
import com.inventario.main.service.GroupProductService;

@RestController
@RequestMapping(value = "/group/product")
public class GroupProductController {
	@Autowired
	private GroupProductService service;
	
	@GetMapping
	public ResponseEntity<List<GroupProduct>> findAll(){
		List<GroupProduct> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<GroupProduct> findById(@PathVariable Long id) {
		GroupProduct obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<GroupProduct> insert (@RequestBody GroupProduct obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdGroupProduct()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
