package com.example.brokagedemo.repository;

import com.example.brokagedemo.model.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    @Query("SELECT a FROM Asset a WHERE a.customer_id = :customerId")
    List<Asset>getAssetsWithCustomerId(Long customerId);
    @Query("SELECT a FROM Asset a WHERE a.assetName like :assetName and a.customer_id = :customerId")
    Optional<Asset> getAssetByAssetNameAndAndCustomer_id(String assetName, Long customerId);

    Optional<Asset> findByAssetNameIgnoreCase(String assetName);
}
