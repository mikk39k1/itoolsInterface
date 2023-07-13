package com.example.itoolsinterface.service;

import com.example.itoolsinterface.model.Card;
import com.example.itoolsinterface.repository.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepo cardRepo;


    public List<Card> getAllCards() {
        return cardRepo.getAllCards();
    }

    public void createNewCard(String cardHeader, String cardLink, File cardImage) {
        cardRepo.createNewCard(cardHeader, cardLink, cardImage);
    }
}
