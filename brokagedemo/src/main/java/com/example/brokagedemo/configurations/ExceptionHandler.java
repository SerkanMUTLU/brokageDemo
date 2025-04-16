package com.example.brokagedemo.configurations;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {
    Map<String, String> errorMessage = new HashMap<>();

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodException(Exception ex, WebRequest webRequest) {
        errorMessage.put("Error Message :",ex.getMessage());
        errorMessage.put("Path : ", webRequest.getContextPath());
        errorMessage.put("Detail : ", webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.EXPECTATION_FAILED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<?>handleException(Exception ex, WebRequest webRequest){
        errorMessage.put("Error Message :",ex.getMessage());
        errorMessage.put("Path : ", webRequest.getContextPath());
        errorMessage.put("Detail : ", webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.EXPECTATION_FAILED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?>handleNotFoundException(EntityNotFoundException ex, WebRequest webRequest){
        errorMessage.put("Error Message :",ex.getMessage());
        errorMessage.put("Path : ", webRequest.getContextPath());
        errorMessage.put("Detail : ", webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<?>handleUnsupportedOperationException(UnsupportedOperationException ex, WebRequest webRequest){
        errorMessage.put("Error Message :",ex.getMessage());
        errorMessage.put("Path : ", webRequest.getContextPath());
        errorMessage.put("Detail : ", webRequest.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.EXPECTATION_FAILED);
    }

}
