package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}