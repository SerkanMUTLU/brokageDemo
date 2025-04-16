package com.example.brokagedemo.model.mappers;

import com.example.brokagedemo.model.dto.assetservice.AssetRequest;
import com.example.brokagedemo.model.dto.assetservice.AssetResponse;
import com.example.brokagedemo.model.entity.Asset;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssetMapper {
    AssetResponse toAssetResponse(Asset asset);

    Asset toAsset (AssetRequest assetRequest);
}
