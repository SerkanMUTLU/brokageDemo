package com.example.brokagedemo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@Table(name = "tb_customer")
@Getter
@Setter
@SQLDelete(sql = "UPDATE tb_customer SET soft_deleted = true WHERE id = ?")
@Where(clause = "soft_deleted = false")
public class Customer extends BaseEntity {
    private String name;

    private String surname;

    @Column(unique = true, nullable = false)
    private String mail;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
