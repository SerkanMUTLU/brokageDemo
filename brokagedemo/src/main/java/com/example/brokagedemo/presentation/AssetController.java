package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.assetservice.AssetResponse;
import com.example.brokagedemo.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssetController implements IAssetController {
    private final AssetService assetService;

    @Override
    public RestResponse<List<AssetResponse>> getAssetListByCustomerId(Long customerId) {
        return RestResponse.<List<AssetResponse>>builder()
                .payload(assetService.getAssetsByCustomerId(customerId))
                .statusCode(HttpStatus.OK)
                .build();
    }
}
