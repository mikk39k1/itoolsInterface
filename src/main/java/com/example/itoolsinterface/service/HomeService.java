package com.example.itoolsinterface.service;

import com.example.itoolsinterface.model.User;
import com.example.itoolsinterface.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;


    public Map<User,Boolean> getUser(String username, String password){
        return homeRepository.getUser(username, password);
    }
}
