package com.example.brokagedemo.presentation;

import com.example.brokagedemo.configurations.RestResponse;
import com.example.brokagedemo.model.dto.userservice.LoginRequest;
import com.example.brokagedemo.model.dto.userservice.RegisterRequest;
import com.example.brokagedemo.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public RestResponse register(@Valid @RequestBody RegisterRequest request) throws Exception {
        authService.register(request);
        return RestResponse.builder()
                .statusCode(HttpStatus.OK)
                .build();
    }
}
