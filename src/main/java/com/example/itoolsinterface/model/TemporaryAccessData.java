package com.example.itoolsinterface.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TemporaryAccessData {
    private String initials;
    private int hourAmount;
    private String mailGroup;

    public TemporaryAccessData(int hourAmount, String mailGroup, String initials) {
        this.hourAmount = hourAmount;
        this.mailGroup = mailGroup;
        this.initials = initials;
    }
}
