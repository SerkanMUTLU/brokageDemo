package com.example.brokagedemo.model.mappers;

import com.example.brokagedemo.model.dto.orderservice.OrderRequest;
import com.example.brokagedemo.model.dto.orderservice.OrderResponse;
import com.example.brokagedemo.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mappings({
            @Mapping(target = "customerName", source = "customer.name"),
            @Mapping(target = "customerSurname", source = "customer.surname"),
            @Mapping(target = "customerMail", source = "customer.mail")
    })
    OrderResponse toOrderResponse(Order order);

    @Mappings({
            @Mapping(target = "customer.id", source = "customerId")
    })
    Order toOrder (OrderRequest orderRequest);
}
