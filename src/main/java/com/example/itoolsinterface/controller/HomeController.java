package com.example.itoolsinterface.controller;

import com.example.itoolsinterface.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Controller
public class HomeController {

    @Autowired
    CardService cardService;

    @GetMapping("/")
    public String index(){
        //model.addAttribute("cards", cardService.getAllCards());
        // Husk at tilføj cards i html
        return "home/index";
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
