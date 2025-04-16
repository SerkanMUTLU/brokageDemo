package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.assetservice.AssetResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/asset")
public interface IAssetController {

    @GetMapping("/assets-by-customer-id/{customerId}")
    RestResponse<List<AssetResponse>> getAssetListByCustomerId(@PathVariable Long customerId);
}
