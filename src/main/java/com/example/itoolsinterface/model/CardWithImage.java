package com.example.itoolsinterface.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CardWithImage {
    private int cardId;
    private String cardTitle;
    private String cardLink;
    private Boolean cardLoginIsRequired;
    private int imageId;
    private String imagePath;
}
