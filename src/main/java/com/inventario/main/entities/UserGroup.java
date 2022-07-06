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
@Table(name = "tb_userGroup")
public class UserGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUserGroup;
	private String groupName;
	@JsonIgnore
	@OneToMany(mappedBy = "userGroup")
	private List <User> users;
	private Boolean isAdmin;
	
	UserGroup(){
	}

	
	public UserGroup(Long idUserGroup, String groupName, List<User> users) {
		this.idUserGroup = idUserGroup;
		this.groupName = groupName;
		this.users = users;
	}

	public Long getIdUserGroup() {
		return idUserGroup;
	}


	public void setIdUserGroup(Long idUserGroup) {
		this.idUserGroup = idUserGroup;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Boolean isAdmin() {
		return isAdmin;
	}


	public void setAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUserGroup == null) ? 0 : idUserGroup.hashCode());
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
		UserGroup other = (UserGroup) obj;
		if (idUserGroup == null) {
			if (other.idUserGroup != null)
				return false;
		} else if (!idUserGroup.equals(other.idUserGroup))
			return false;
		return true;
	}
}
