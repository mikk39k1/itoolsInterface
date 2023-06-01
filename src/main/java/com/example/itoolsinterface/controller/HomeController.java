package com.example.itoolsinterface.controller;

import com.example.itoolsinterface.model.User;
import com.example.itoolsinterface.service.HomeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/")
    public String index(HttpSession session){
        User user = (User) session.getAttribute("user");
        return "home/index";
    }

    @GetMapping("/login")
    public String login(){
        return "home/login";
    }


    @GetMapping("/invalidLogin")
    public String invalidLogin(){
        return "home/invalidLogin";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam("username") String username, @RequestParam("password") String password,
                         HttpSession session){

        boolean success;
        Map<User, Boolean> loginResult = homeService.getUser(username, password);
        User user = loginResult.keySet().iterator().next();
        success = loginResult.get(user);
        session.setAttribute("user", user);
        return success ? "redirect:/" : "home/invalidLogin";
    }

}
