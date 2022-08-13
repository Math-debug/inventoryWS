package com.inventario.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventario.main.entities.Counting;

public interface CountingRepository extends JpaRepository<Counting, Long> {
	@Query("select c from Counting c where c.finishCounting is null")
	List<Counting> findOpenCounting();
}
