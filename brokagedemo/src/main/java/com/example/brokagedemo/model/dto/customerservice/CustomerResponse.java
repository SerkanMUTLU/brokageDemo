package com.example.brokagedemo.model.dto.customerservice;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;

    private String name;

    private String surname;

    private String mail;

    private String userName;
}
