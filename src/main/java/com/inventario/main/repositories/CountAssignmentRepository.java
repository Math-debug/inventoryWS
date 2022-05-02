package com.inventario.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.main.entities.CountAssignment;

public interface CountAssignmentRepository extends JpaRepository<CountAssignment, Long> {

}
