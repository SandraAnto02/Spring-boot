package edu.training.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.training.jwt.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> 
{

}
