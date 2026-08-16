package com.example.Java_Calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleArithmeticException(
            ArithmeticException exception) {

        Map<String, String> response = new HashMap<>();

        response.put("error", exception.getMessage());

        return response;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleIllegalArgumentException(
            IllegalArgumentException exception) {

        Map<String, String> response = new HashMap<>();

        response.put("error", exception.getMessage());

        return response;
    }
}