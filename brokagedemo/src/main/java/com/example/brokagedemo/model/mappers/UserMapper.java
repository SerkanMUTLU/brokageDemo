package com.example.brokagedemo.model.mappers;

import com.example.brokagedemo.model.dto.userservice.UserResponse;
import com.example.brokagedemo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CustomerMapper.class)
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    @Mapping(target = "customerName", source = "customer.name")
    UserResponse toUserResponse(User user);

    User toUser(UserResponse userResponse);
}
