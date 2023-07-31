package com.example.itoolsinterface.controller;

import com.example.itoolsinterface.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    CardService cardService;

    @GetMapping("/")
    public String index(Model model){
        //model.addAttribute("cards", cardService.getAllCards());
        // Husk at tilføj cards i html
        model.addAttribute("cardsVisibleToAll", cardService.getAllCardsVisibleToAll());
        model.addAttribute("cardVisibleWhenLoggedIn", cardService.getAllCardsVisibleToLoggedIn());
        return "home/index";
    }

    @GetMapping("/cardCreation")
    public String cardCreation(){
        return "home/cardCreation";
    }

    @PostMapping("/createNewCard")
    public String createNewCard(@RequestParam("cardTitle") String cardTitle,
                                @RequestParam("cardLink") String cardLink,
                                @RequestParam(value = "cardLoginIsRequired", required = false) String cardLoginIsRequired,
                                @RequestParam(value = "cardLoginIsRequiredHidden", defaultValue = "0") String cardLoginIsRequiredHidden,
                                @RequestParam("cardImage") MultipartFile cardImage) {

        String fileName = UUID.randomUUID().toString() + '_' + cardImage.getOriginalFilename();
        try {
            Path filePath = Paths.get('/' + "home/fomadmin/itoolsInterface/src/main/resources/static/images/" + fileName);
            Files.copy(cardImage.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }

        // Check if the checkbox is checked, otherwise use the hidden input value
        boolean loginIsRequired = cardLoginIsRequired != null ? true : "1".equals(cardLoginIsRequiredHidden);

        cardService.createNewCard(cardTitle, cardLink, loginIsRequired);
        int cardId = cardService.getCardIdFromTitle(cardTitle);

        String imagePath = "home/fomadmin/itoolsInterface/src/main/resources/static/images/" + fileName;

        cardService.saveImage(cardId, imagePath);

        return "redirect:/";
    }


}
