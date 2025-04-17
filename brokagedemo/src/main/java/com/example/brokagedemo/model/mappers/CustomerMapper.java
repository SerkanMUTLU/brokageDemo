package com.example.brokagedemo.model.mappers;

import com.example.brokagedemo.model.dto.customerservice.CustomerResponse;
import com.example.brokagedemo.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {
        UserMapper.class, OrderMapper.class
})
public interface CustomerMapper {
    @Mappings({
            @Mapping(target = "userName", source = "user.username")
    })
    CustomerResponse toCustomerResponse(Customer customer);
}
