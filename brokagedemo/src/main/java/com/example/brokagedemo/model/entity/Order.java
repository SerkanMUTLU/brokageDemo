package com.example.brokagedemo.model.entity;

import com.example.brokagedemo.enums.OrderSide;
import com.example.brokagedemo.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@SQLDelete(sql = "UPDATE tb_order SET soft_deleted = true WHERE id = ?")
@Where(clause = "soft_deleted = false")
public class Order extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderSide orderSide;

    private BigDecimal size;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "asset_name")
    private String assetName;
}
