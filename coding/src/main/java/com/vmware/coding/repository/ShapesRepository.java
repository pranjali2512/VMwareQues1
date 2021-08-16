package com.vmware.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmware.coding.entity.Shapes;

public interface ShapesRepository extends JpaRepository<Shapes, Integer> {

	public Shapes findByTaskId(int id);
}
