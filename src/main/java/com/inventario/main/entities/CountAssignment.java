package com.inventario.main.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_countAssignment")
public class CountAssignment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCountAssigment;
	@ManyToOne
	@JoinColumn(name = "counting_id")
	private Counting counting;
	@OneToOne
	@JoinColumn(name = "user_assignment")
	private User user;
	@OneToMany
	@JoinColumn(name = "address_assignment")
	private List<Address> address;
	public CountAssignment() {
	}

	public CountAssignment(Long idCountAssigment, Counting counting, User user, List<Address> address) {
		super();
		this.idCountAssigment = idCountAssigment;
		this.counting = counting;
		this.user = user;
		this.address = address;
	}


	public Long getIdCountAssigment() {
		return idCountAssigment;
	}

	public void setIdCountAssigment(Long idCountAssigment) {
		this.idCountAssigment = idCountAssigment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Counting getCounting() {
		return counting;
	}

	public void setCounting(Counting counting) {
		this.counting = counting;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
}
