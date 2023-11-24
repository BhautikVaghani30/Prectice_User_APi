package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import com.example.demo.Entities.User;
import com.example.demo.repository.UserRepository;

@Component
public class Services {
    
    @Autowired
    private UserRepository userRepository;

    public void CreateUser(User user){
        this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> list = (List<User>) this.userRepository.findAll();
        return list;
    }

    public User getOneUser(int id){
        User user = this.userRepository.findById(id);
        return user;
    }

    public void removeUer(int id){
        this.userRepository.deleteById(id);
    }

    public User update(User user,int id){
        user.setId(id);
        User user2 = this.userRepository.save(user);

        return user2;
    }
}
