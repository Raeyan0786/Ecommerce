package com.example.Ecommerce.controller;

import com.example.Ecommerce.model.User;
import com.example.Ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/user")
    public String saveUser(@RequestBody User user){
        service.addUser(user);
        return "user saved";
    }
    @GetMapping("/user/id/{id}")
    public User getUser(@PathVariable Integer id){
        return service.getUser(id);
    }


}
