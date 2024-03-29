package com.example.itoolsinterface.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Login {
    private int loginId;

    @NotBlank (message = "Username cannot be blank")
    @Size(min = 3, max = 20)
    private String loginUsername;
    @NotBlank (message = "Password cannot be blank")
    @Size(min = 6, max = 20)
    private String loginPassword;


    public enum LoginResult  {
        SUCCESS,
        INCORRECT_USERNAME,
        INCORRECT_PASSWORD
    }
}
