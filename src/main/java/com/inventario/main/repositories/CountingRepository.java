package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.Counting;

public interface CountingRepository extends JpaRepository<Counting, Long> {

}
