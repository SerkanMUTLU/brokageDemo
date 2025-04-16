package com.example.brokagedemo.enums;

import lombok.Getter;

@Getter
public enum OrderSide {
    SELL(0),
    BUY(1);

    private final int orderValue;

    OrderSide(int orderValue) {
        this.orderValue = orderValue;
    }
}
