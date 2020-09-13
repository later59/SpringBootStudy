package com.rock.controller;

import com.rock.entity.User;
import com.rock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping("/addUser")
    public User addUser(User user){
        return userRepository.save(user);
    }
}
