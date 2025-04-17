package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.userservice.UserResponse;
import com.example.brokagedemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements IUserController {
    private final UserService userService;
    @Override
    public RestResponse<UserResponse> getUserByMail(String mail) {
        return RestResponse.<UserResponse>builder()
                .payload(userService.getUserByMail(mail))
                .statusCode(HttpStatus.OK)
                .build();
    }

    @Override
    public RestResponse<UserResponse> getUserByCustomerId(Long id) {
        return RestResponse.<UserResponse>builder()
                .payload(userService.getUserById(id))
                .statusCode(HttpStatus.OK)
                .build();
    }
}
