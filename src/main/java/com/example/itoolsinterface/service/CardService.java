package com.example.itoolsinterface.service;

import com.example.itoolsinterface.model.Card;
import com.example.itoolsinterface.model.CardWithImage;
import com.example.itoolsinterface.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepo cardRepo;


    public List<CardWithImage> getAllCardsVisibleToAll() {
        return cardRepo.getAllCardsVisibleToAll();
    }

    public void createNewCard(String cardTitle, String cardLink, boolean cardLoginIsRequired) {
        cardRepo.createNewCard(cardTitle, cardLink, cardLoginIsRequired);
    }

    public Integer getCardIdFromTitle(String cardTitle) {
        return cardRepo.getCardIdFromTitle(cardTitle);
    }

    public void saveImage(int cardId, String imagePath) {
        cardRepo.saveImage(cardId, imagePath);
    }

    public List<CardWithImage> getAllCardsVisibleToLoggedIn() {
        return cardRepo.getAllCardsVisibleToLoggedIn();
    }
}
