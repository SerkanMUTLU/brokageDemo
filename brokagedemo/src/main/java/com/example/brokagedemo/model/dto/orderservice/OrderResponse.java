package com.example.brokagedemo.model.dto.orderservice;

import com.example.brokagedemo.enums.OrderSide;
import com.example.brokagedemo.enums.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponse {
    private OrderSide orderSide;

    private BigDecimal size;

    private BigDecimal price;

    private Status status;

    private String createdDate;

    private String assetName;

    private String customerName;

    private String customerSurname;

    private String customerMail;

}
