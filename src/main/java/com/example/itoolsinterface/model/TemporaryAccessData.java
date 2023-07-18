package com.example.itoolsinterface.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TemporaryAccessData {
    private String initials;
    private int hourAmount;
    private String mailGroup;
    private LocalDateTime localDateTime;

    public TemporaryAccessData(int hourAmount, String mailGroup, String initials, LocalDateTime localDateTime) {
        this.hourAmount = hourAmount;
        this.mailGroup = mailGroup;
        this.initials = initials;
        this.localDateTime = localDateTime;
    }
}
