package org.demon.controller;

import org.demon.entity.User;
import org.demon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id")Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping("/user")
    public User insert(User user){
        userRepository.save(user);
        return user;
    }
}
