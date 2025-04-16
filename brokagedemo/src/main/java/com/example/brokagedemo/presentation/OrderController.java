package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.orderservice.OrderRequest;
import com.example.brokagedemo.model.dto.orderservice.OrderResponse;
import com.example.brokagedemo.model.entity.Order;
import com.example.brokagedemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController implements IOrderController {
    private final OrderService orderService;

    @Override
    public RestResponse<List<OrderResponse>> getAllOrders() {
        return RestResponse.<List<OrderResponse>>builder()
                .payload(orderService.getAllOrders())
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public RestResponse<List<OrderResponse>> getOrdersByCustomerName(String customerName) {
        return RestResponse.<List<OrderResponse>>builder()
                .payload(orderService.getOrdersByCustomerName(customerName))
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public RestResponse<List<OrderResponse>> getOrdersByCustomerNameAndDate(String customerName, String startDate, String endDate) {
        return RestResponse.<List<OrderResponse>>builder()
                .payload(orderService.getOrdersByCustomerNameAndDate(customerName, startDate, endDate))
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public RestResponse<List<OrderResponse>> getOrdersByCustomerId(Long customerId) {
        return RestResponse.<List<OrderResponse>>builder()
                .payload(orderService.getOrdersByCustomerId(customerId))
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public RestResponse deleteOrderById(Long orderId) {
        return orderService.deleteOrder(orderId);
    }

    @Override
    public RestResponse<OrderResponse> cancelOrder(Long orderId) throws Exception {
        return RestResponse.<OrderResponse>builder()
                .payload(orderService.cancelOrder(orderId))
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public RestResponse<OrderResponse> createOrder(OrderRequest orderRequest) throws Exception {
        return RestResponse.<OrderResponse>builder()
                .payload(orderService.createOrder(orderRequest))
                .statusCode(HttpStatus.OK)
                .build();
    }

}
