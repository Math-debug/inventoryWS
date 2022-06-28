package com.inventario.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inventario.main.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	@Query("select ad FROM Address ad "
			+ "where ad.street = :street "
			+ "AND ad.building = :building "
			+ "AND ad.apartment = :apartment "
			+ "AND ad.level = :level")
	public List<Address> findByFullAdress(
			@Param("street") String street,
			@Param("building") String building,
			@Param("apartment") String apartment,
			@Param("level") String level);
}