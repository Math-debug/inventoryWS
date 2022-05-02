package com.inventario.main.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_productCounting")
public class ProductCounting implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProductCounting;
	@ManyToOne
	@JoinColumn(name = "counting_id")
	private Counting counting;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private Integer quantity;
	
	public ProductCounting() {
	}

	public ProductCounting(Long idProductCounting, Counting counting, Product product, Integer quantity) {
		super();
		this.idProductCounting = idProductCounting;
		this.counting = counting;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getIdProductCounting() {
		return idProductCounting;
	}

	public void setIdProductCounting(Long idProductCounting) {
		this.idProductCounting = idProductCounting;
	}

	public Counting getCounting() {
		return counting;
	}

	public void setCounting(Counting counting) {
		this.counting = counting;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProductCounting == null) ? 0 : idProductCounting.hashCode());
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
		ProductCounting other = (ProductCounting) obj;
		if (idProductCounting == null) {
			if (other.idProductCounting != null)
				return false;
		} else if (!idProductCounting.equals(other.idProductCounting))
			return false;
		return true;
	}
	
}
