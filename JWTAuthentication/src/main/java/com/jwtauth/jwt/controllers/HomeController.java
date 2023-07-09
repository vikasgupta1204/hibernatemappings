package com.jwtauth.jwt.controllers;

import com.jwtauth.jwt.models.User;
import com.jwtauth.jwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private UserService userService;
    @GetMapping("/home/user")
    public List<User> getUser(){
        return userService.getUsers();
    }
}
