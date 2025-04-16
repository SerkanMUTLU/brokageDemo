package com.example.brokagedemo.enums;

import lombok.Getter;

@Getter
public enum Status {
    CANCELLED(0),
    MATCHED(1),
    PENDING(2);

    private final int statusValue;

    Status(int statusValue) {
        this.statusValue = statusValue;
    }

}
