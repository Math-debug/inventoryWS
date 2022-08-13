package com.inventario.main.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.inventario.main.entities.Inventory;
import com.inventario.main.service.InventoryService;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryService service;
	
	@GetMapping
	public ResponseEntity<List<Inventory>> findAll(){
		List<Inventory> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Inventory> findById(@PathVariable Long id) {
		Inventory obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Inventory> insert (@RequestBody Inventory obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdInventory()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@GetMapping(value = "/status")
	public ResponseEntity<Boolean> status() {
		Boolean obj = service.status();
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping(value = "/finish")
	public void finish() {
		service.finish();
		return;
	}
	@GetMapping(value = "/get")
	public ResponseEntity<Inventory> getLastInventory() {
		Inventory obj = service.lastInventory();
		return ResponseEntity.ok().body(obj);
	}
}
