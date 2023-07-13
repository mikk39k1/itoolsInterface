package com.example.itoolsinterface.controller;

import com.example.itoolsinterface.model.User;
import com.example.itoolsinterface.service.CardService;
import com.example.itoolsinterface.service.HomeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    CardService cardService;

    @GetMapping("/")
    public String index(HttpSession session, Model model){
        //model.addAttribute("cards", cardService.getAllCards());
        // Husk at tilføj cards i html
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

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
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

    @GetMapping("/cardCreation")
    public String cardCreation(){
        return "home/cardCreation";
    }

    @PostMapping("/createNewCard")
    public String createNewCard(@RequestParam("cardHeader") String cardHeader,
                                @RequestParam("cardLink") String cardLink,
                                @RequestParam("cardImage") File cardImage){
        cardService.createNewCard(cardHeader, cardLink, cardImage);
        return "redirect:/";
    }

}
