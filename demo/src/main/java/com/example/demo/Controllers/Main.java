package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.demo.Entities.User;
import com.example.demo.Services.Services;

@RestController
public class Main {
    
    @Autowired
    private Services service;

    @PostMapping("/addUser")
    public ResponseEntity<Void> add(@RequestBody User user){
        try {
            this.service.CreateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAll(){
        List<User> list = null;
        try {
            list = this.service.getAllUsers(); 
            if (list.size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getone(@PathVariable("id") int id){
        User user = null;
        try {
            user = this.service.getOneUser(id);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/deleteuswer/{id}")
    public ResponseEntity<Void> deleteUer(@PathVariable("id") int id){
        try {
            this.service.removeUer(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateEntity(@PathVariable("id") int id,@RequestBody User user){
        User u = null;
        try {
            u = this.service.update(user,id);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }



}
