package edu.training.jwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.jwt.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> 
{
	List<Inventory> findByProductNameIn(List<String> productName);

}
