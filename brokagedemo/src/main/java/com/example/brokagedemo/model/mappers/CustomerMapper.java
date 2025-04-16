package com.example.brokagedemo.model.mappers;

import com.example.brokagedemo.model.dto.customerservice.CustomerResponse;
import com.example.brokagedemo.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    CustomerResponse toCustomerResponse(Customer customer);
}
