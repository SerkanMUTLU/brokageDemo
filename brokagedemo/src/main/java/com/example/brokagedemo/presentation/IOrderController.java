package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.orderservice.OrderRequest;
import com.example.brokagedemo.model.dto.orderservice.OrderResponse;
import com.example.brokagedemo.model.entity.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/order")
public interface IOrderController {
    @GetMapping("/all-orders")
    RestResponse<List<OrderResponse>> getAllOrders();

    @GetMapping("/orders-by-customer-name/{customerName}")
    RestResponse<List<OrderResponse>> getOrdersByCustomerName(@PathVariable("customerName") String customerName);

    @GetMapping("/orders-by-customer-name-and-date")
    RestResponse<List<OrderResponse>> getOrdersByCustomerNameAndDate(@RequestParam String customerName, @RequestParam String startDate, @RequestParam String endDate);

    @GetMapping("/orders-by-customer-id/{customerId}")
    RestResponse<List<OrderResponse>> getOrdersByCustomerId(@PathVariable("customerId") Long customerId);

    @DeleteMapping("/delete-order/{orderId}")
    RestResponse deleteOrderById(@PathVariable Long orderId);

    @PutMapping("/cancel-order/{orderId}")
    RestResponse<OrderResponse> cancelOrder(@PathVariable Long orderId) throws Exception;

    @PostMapping("/create-order")
    RestResponse<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) throws Exception;
}
