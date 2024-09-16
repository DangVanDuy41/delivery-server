package com.example.deliveryserver.exception;

import com.example.deliveryserver.DTO.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleException(RuntimeException ex) {
        ApiResponse errorResponse = ApiResponse.builder().time(new Date()).message(ex.getMessage()).data(null).build();
        return ResponseEntity.status(500).body(errorResponse);
    }
}
