package com.example.brokagedemo.configurations;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class RestResponse <T> {
    private T payload;

    private HttpStatus statusCode;
}
