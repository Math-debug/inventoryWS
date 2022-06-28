package com.inventario.main.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_group_product")
public class GroupProduct implements Serializable{

	private static final long serialVersionUID = 3136833274997697363L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGroupProduct;
	private String productGroupName;
	
	public GroupProduct() {
	}

	public GroupProduct(Long idGroupProduct, String productGroupName) {
		this.idGroupProduct = idGroupProduct;
		this.productGroupName = productGroupName;
	}
	public GroupProduct(String productGroupName) {
		this.productGroupName = productGroupName;
	}



	public Long getIdGroupProduct() {
		return idGroupProduct;
	}



	public void setIdGroupProduct(Long idGroupProduct) {
		this.idGroupProduct = idGroupProduct;
	}



	public String getProductGroupName() {
		return productGroupName;
	}



	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGroupProduct == null) ? 0 : idGroupProduct.hashCode());
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
		GroupProduct other = (GroupProduct) obj;
		if (idGroupProduct == null) {
			if (other.idGroupProduct != null)
				return false;
		} else if (!idGroupProduct.equals(other.idGroupProduct))
			return false;
		return true;
	}
	
}
