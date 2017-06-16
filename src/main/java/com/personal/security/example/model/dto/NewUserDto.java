package com.personal.security.example.model.dto;

import com.personal.security.example.model.User;
import com.personal.security.example.validation.FieldsMatch;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@FieldsMatch(first = "password", second = "repeatPassword", message = "Passwords should be similar")
public class NewUserDto {

    @Size(min = 5, max = 15, message = "Length of username should be between 5 and 15 characters")
    private String username;

    @Size(min = 5, max = 50, message = "Length of password should be between 5 and 50 characters")
    private String password;

    private String repeatPassword;

    public User user() {
        return new User(username, password, true);
    }

}
