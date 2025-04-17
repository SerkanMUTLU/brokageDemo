package com.example.brokagedemo.model.dto.userservice;

import jakarta.annotation.Nonnull;
import lombok.Data;

@Data
public class RegisterRequest {
    private String customerName;

    private String customerSurname;

    @Nonnull
    private String mail;

    @Nonnull
    private String username;

    private String password;
}
