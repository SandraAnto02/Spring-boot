package edu.training.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.jwt.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{

}
