package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.UserGroup;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {

}
