package com.example.brokagedemo.service;

import com.example.brokagedemo.model.dto.assetservice.AssetRequest;
import com.example.brokagedemo.model.dto.assetservice.AssetResponse;
import com.example.brokagedemo.model.entity.Asset;
import com.example.brokagedemo.model.mappers.AssetMapper;
import com.example.brokagedemo.repository.AssetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetRepository assetRepository;

    private final AssetMapper assetMapper;
    public List<AssetResponse> getAssetsByCustomerId(Long customerId) {
        List<Asset> assetList = assetRepository.getAssetsWithCustomerId(customerId);
        return assetList.stream()
                .map(assetMapper::toAssetResponse)
                .collect(Collectors.toList());
    }

    public AssetResponse getAssetsByNameAndCustomerId(String assetName) {
        Optional<Asset> asset = assetRepository.findByAssetNameIgnoreCase(assetName);
        return asset.map(assetMapper::toAssetResponse)
                .orElse(null);
    }

    public AssetResponse updateAssetInfo(AssetRequest assetRequest) {
        Asset asset = assetMapper.toAsset(assetRequest);
        return assetMapper.toAssetResponse(assetRepository.save(asset));
    }

}
