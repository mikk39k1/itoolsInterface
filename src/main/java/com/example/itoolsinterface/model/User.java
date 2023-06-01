package com.example.itoolsinterface.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@Getter
@Setter
public class User {

    private int loginId;
    private String username;
    private String password;


    public enum LoginResult  {
        SUCCESS
    }
}
