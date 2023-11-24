package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.User;

public interface UserRepository extends CrudRepository<User,Integer>{
    public User findById(int id);  
}
