package com.example.brokagedemo.repository;

import com.example.brokagedemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByCustomer_Id(Long customerId);

    Optional<User> getUserByCustomerMail(String mail);

    Optional<User> getUserByUsername(String username);

    Boolean existsUserByUsername(String username);
}
