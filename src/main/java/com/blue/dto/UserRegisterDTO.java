package com.blue.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {
    private String account;
    private String password;
    private String email;
}

