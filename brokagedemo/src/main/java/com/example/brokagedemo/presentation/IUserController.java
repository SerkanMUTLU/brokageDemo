package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.userservice.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public interface IUserController {

    @GetMapping("/get-user-by-mail/{mail}")
    RestResponse<UserResponse> getUserByMail(@PathVariable String mail);

    @GetMapping("/get-user-by-id/{id}")
    RestResponse<UserResponse> getUserByCustomerId(@PathVariable Long id);
}
