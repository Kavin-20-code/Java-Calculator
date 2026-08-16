package com.example.Java_Calculator.controller;

import com.example.Java_Calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculate")
    public double calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operator) {

        return calculatorService.calculate(a, b, operator);
    }
}