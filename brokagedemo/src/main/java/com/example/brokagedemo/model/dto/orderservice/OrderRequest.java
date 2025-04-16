package com.example.brokagedemo.model.dto.orderservice;

import com.example.brokagedemo.enums.OrderSide;
import com.example.brokagedemo.enums.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private Long customerId; // target

    private BigDecimal size;

    private BigDecimal price;

    private String assetName;

    private OrderSide orderSide;
}
