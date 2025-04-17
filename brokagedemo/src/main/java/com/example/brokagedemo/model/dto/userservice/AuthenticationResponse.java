package com.example.brokagedemo.model.dto.userservice;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String username;

    private String password;
}
