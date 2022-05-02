package com.inventario.main.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_inventory")
public class Inventory implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInventory;
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private User idUser;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant startInventory;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant finishInventory;
	
	Inventory(){
	}

	public Inventory(Long idInventory, User idUser, Instant startInventory, Instant finishInventory,
			List<CountAssignment> countAssignment) {
		super();
		this.idInventory = idInventory;
		this.idUser = idUser;
		this.startInventory = startInventory;
		this.finishInventory = finishInventory;
	}

	public Long getIdInventory() {
		return idInventory;
	}


	public void setidInventory(Long idInventory) {
		this.idInventory = idInventory;
	}


	public User getIdUser() {
		return idUser;
	}


	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}


	public Instant getStartInventory() {
		return startInventory;
	}


	public void setStartInventory(Instant startInventory) {
		this.startInventory = startInventory;
	}


	public Instant getFinishInventory() {
		return finishInventory;
	}


	public void setFinishInventory(Instant finishInventory) {
		this.finishInventory = finishInventory;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idInventory == null) ? 0 : idInventory.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (idInventory == null) {
			if (other.idInventory != null)
				return false;
		} else if (!idInventory.equals(other.idInventory))
			return false;
		return true;
	}
}
