package com.inventario.main.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	private String productName;
	@ManyToOne
	@JoinColumn(name = "group_product_id")
	private GroupProduct groupProduct;
	private String codebar;
	@OneToMany(mappedBy="product")
	List<ProductAddress> productAddress;
	
	public Product() {
	}

	public Product(Long idProduct, String productName, GroupProduct groupProduct, String codebar,
			List<ProductAddress> productAddress) {
		this.idProduct = idProduct;
		this.productName = productName;
		this.groupProduct = groupProduct;
		this.codebar = codebar;
		this.productAddress = productAddress;
	}


	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public GroupProduct getGroupProduct() {
		return groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

	public String getCodebar() {
		return codebar;
	}

	public void setCodebar(String codebar) {
		this.codebar = codebar;
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
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
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
		Product other = (Product) obj;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		return true;
	}
}
