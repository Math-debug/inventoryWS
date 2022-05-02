package com.inventario.main.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_counting")
public class Counting implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCounting;
	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant startCounting;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant finishCounting;
	
	public Counting() {
	}
	
	public Counting(Long idCounting, Inventory inventory, Instant startCounting, Instant finishCounting) {
		super();
		this.idCounting = idCounting;
		this.inventory = inventory;
		this.startCounting = startCounting;
		this.finishCounting = finishCounting;
	}
	
	public Long getIdCounting() {
		return idCounting;
	}
	public void setIdCounting(Long idCounting) {
		this.idCounting = idCounting;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Instant getStartCounting() {
		return startCounting;
	}
	public void setStartCounting(Instant startCounting) {
		this.startCounting = startCounting;
	}
	public Instant getFinishCounting() {
		return finishCounting;
	}
	public void setFinishCounting(Instant finishCounting) {
		this.finishCounting = finishCounting;
	}
	
	

}
