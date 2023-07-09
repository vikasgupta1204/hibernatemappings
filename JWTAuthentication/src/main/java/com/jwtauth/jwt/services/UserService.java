package com.jwtauth.jwt.services;

import com.jwtauth.jwt.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store=new ArrayList<>();
    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Vikas Gupta","vikas@dev.in"));
        store.add(new User(UUID.randomUUID().toString(),"Aravind Poduri","aravind@dev.in"));
        store.add(new User(UUID.randomUUID().toString(),"Neha Keshri","neha@dev.in"));
        store.add(new User(UUID.randomUUID().toString(),"Gautam Shukla","gautam@dev.in"));

    }

    public List<User> getUsers(){
        return store;
    }
}
