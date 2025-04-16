package com.example.brokagedemo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_asset")
@Getter
@Setter
@SQLDelete(sql = "UPDATE tb_asset SET soft_deleted = true WHERE id = ?")
@Where(clause = "soft_deleted = false")
public class Asset extends BaseEntity {

    @Column(name = "customer_id")
    private Long customer_id;

    @Column(unique = true, nullable = false)
    private String assetName;

    private BigDecimal Size;

    private BigDecimal usableSize;

}
