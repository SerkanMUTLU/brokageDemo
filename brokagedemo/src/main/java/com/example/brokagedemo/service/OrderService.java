package com.example.brokagedemo.service;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.constants.DateConstant;
import com.example.brokagedemo.enums.Status;
import com.example.brokagedemo.model.dto.assetservice.AssetResponse;
import com.example.brokagedemo.model.dto.orderservice.OrderRequest;
import com.example.brokagedemo.model.dto.orderservice.OrderResponse;
import com.example.brokagedemo.model.entity.Order;
import com.example.brokagedemo.model.mappers.OrderMapper;
import com.example.brokagedemo.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    private final AssetService assetService;

    private final CustomerService customerService;

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public List<OrderResponse> getOrdersByCustomerName(String customerName) {
        List<Order> orderList = orderRepository.getOrdersByCustomer_Name(customerName);
        return orderList.stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public List<OrderResponse> getOrdersByCustomerNameAndDate(String customerName, String startDate, String endDate) {
        List<Order> orderList = orderRepository.getOrdersByCustomerAndBetweenDates(customerName, convertStringToDate(startDate), convertStringToDate(endDate));
        return orderList.stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public List<OrderResponse> getOrdersByCustomerId(Long customerId) {
        List<Order> orderList = orderRepository.getOrdersByCustomer_Id(customerId);
        return orderList.stream()
                .map(orderMapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public RestResponse deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);

        return RestResponse.builder()
                .statusCode(HttpStatus.OK)
                .build();
    }

    public OrderResponse cancelOrder(Long orderId) throws Exception {
        Optional<Order> selectedOrder = orderRepository.findById(orderId);

        if (selectedOrder.isEmpty()) {
            throw new EntityNotFoundException("There is no item whose id is : " + orderId);
        }

        if (!selectedOrder.get().getStatus().name().equalsIgnoreCase(Status.PENDING.name())) {
            throw new Exception("Order can't be canceled.");
        }

        selectedOrder.get().setStatus(Status.CANCELLED);
        Order canceledOrder = orderRepository.save(selectedOrder.get());

        return orderMapper.toOrderResponse(canceledOrder);
    }

    @Transactional
    public OrderResponse createOrder(OrderRequest request) throws Exception {

        if (!customerService.checkCustomerExistById(request.getCustomerId())) {
            throw new EntityNotFoundException("There no customer in database.");
        }

        AssetResponse assetResponse = assetService.getAssetsByNameAndCustomerId(request.getAssetName());
        if (Objects.isNull(assetResponse)) {
            throw new EntityNotFoundException("There no asset in database.");
        }

        if (request.getCustomerId().equals(assetResponse.getCustomer_id())) {
            throw new Exception("asset owner not buy own asset");
        }

        if (assetResponse.getUsableSize().compareTo(request.getSize()) == -1) {
            throw new Exception("asset usable size not lower than asset that is wanted to buy");
        }

        Order newOrder = orderMapper.toOrder(request);
        newOrder.setStatus(Status.PENDING);
        return orderMapper.toOrderResponse(orderRepository.save(newOrder));
    }

    private LocalDateTime convertStringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateConstant.DATE_FORMAT_FOR_YYYY_MM_DD_HH_MM_SS);
        return LocalDateTime.parse(date, formatter);
    }

}
