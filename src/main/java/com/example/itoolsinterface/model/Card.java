package com.example.itoolsinterface.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Card {

    private int cardId;
    private String cardTitle;
    private String cardLink;
    private Boolean cardLoginIsRequired;

}
