package com.example.itoolsinterface.service;


import com.example.itoolsinterface.model.Login;
import com.example.itoolsinterface.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;


    public Login.LoginResult loginUser(String username, String password) {
        return loginRepo.loginUser(username, password);
    }

    public Login getLoginSession(String username, String password) {
        return loginRepo.getLoginSession(username, password);
    }
}
