package com.cotizador.utils;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiResponseError extends Response {
    public ApiResponseError(String message, Integer code, HttpStatus status, LocalDateTime timestamp) {
        super(message, code, status, timestamp);
    }
}
