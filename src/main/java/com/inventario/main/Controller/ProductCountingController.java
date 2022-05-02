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

import com.inventario.main.entities.ProductCounting;
import com.inventario.main.service.ProductCountingService;

@RestController
@RequestMapping(value = "/productCounting")
public class ProductCountingController {
	
	@Autowired
	private ProductCountingService service;
	
	@GetMapping
	public ResponseEntity<List<ProductCounting>> findAll(){
		List<ProductCounting> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductCounting> findById(@PathVariable Long id) {
		ProductCounting obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<ProductCounting> insert (@RequestBody ProductCounting obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdProductCounting()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
