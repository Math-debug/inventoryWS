package com.inventario.main.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddress;
	private String street;
	private String building;
	private String apartment;
	private String level;
	@JsonIgnore
	@OneToMany(mappedBy="address")
	List<ProductAddress> productAddress;
	
	Address(){
	}

	public Address(Long idAddress, String street, String building, String apartment, String level) {
		super();
		this.idAddress = idAddress;
		this.street = street;
		this.building = building;
		this.apartment = apartment;
		this.level = level;
	}
	public Address(String street, String building, String apartment, String level) {
		this.street = street;
		this.building = building;
		this.apartment = apartment;
		this.level = level;
	}


	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<ProductAddress> getProductAddress() {
		return productAddress;
	}

	public void setProductAddress(List<ProductAddress> productAddress) {
		this.productAddress = productAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAddress == null) ? 0 : idAddress.hashCode());
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
		Address other = (Address) obj;
		if (idAddress == null) {
			if (other.idAddress != null)
				return false;
		} else if (!idAddress.equals(other.idAddress))
			return false;
		return true;
	}
	
}
