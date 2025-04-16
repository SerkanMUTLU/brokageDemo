package com.example.brokagedemo.repository;

import com.example.brokagedemo.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByCustomer_Name(String customerName);

    @Query("SELECT a FROM Order a WHERE a.customer.name = :customerName and a.createdDate between :startDate and :endDate")
    List<Order> getOrdersByCustomerAndBetweenDates(String customerName, LocalDateTime startDate, LocalDateTime endDate);

    List<Order> getOrdersByCustomer_Id(Long customerId);

}
