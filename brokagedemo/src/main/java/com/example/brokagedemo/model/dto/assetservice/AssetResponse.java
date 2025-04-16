package com.example.brokagedemo.model.dto.assetservice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AssetResponse {
    private Long customer_id;

    private String assetName;

    private BigDecimal Size;

    private BigDecimal usableSize;
}
