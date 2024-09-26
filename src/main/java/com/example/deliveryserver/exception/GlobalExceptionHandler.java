package com.example.deliveryserver.exception;

import com.example.deliveryserver.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handleException(RuntimeException ex) {
        ApiResponse<Object> errorResponse = ApiResponse.builder().time(new Date()).message(ex.getMessage()).data(null).build();
        return ResponseEntity.status(500).body(errorResponse);
    }
}
