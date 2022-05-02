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

import com.inventario.main.entities.CountAssignment;
import com.inventario.main.service.CountAssignmentService;

@RestController
@RequestMapping(value = "/countAssignment")
public class CountAssignmentController {
	
	@Autowired
	private CountAssignmentService service;
	
	@GetMapping
	public ResponseEntity<List<CountAssignment>> findAll(){
		List<CountAssignment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CountAssignment> findById(@PathVariable Long id) {
		CountAssignment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<CountAssignment> insert (@RequestBody CountAssignment obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCountAssigment()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
