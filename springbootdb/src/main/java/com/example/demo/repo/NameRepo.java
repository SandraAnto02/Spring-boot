package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Name;

public interface NameRepo extends CrudRepository<Name, Integer>
{

}
