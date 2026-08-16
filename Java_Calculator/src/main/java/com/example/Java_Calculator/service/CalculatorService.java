package com.example.Java_Calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }

    public double calculate(double a, double b, String operator) {

        switch (operator) {

            case "+":
                return add(a, b);

            case "-":
                return subtract(a, b);

            case "*":
                return multiply(a, b);

            case "/":
                return divide(a, b);

            default:
                throw new IllegalArgumentException(
                        "Invalid operator. Use +, -, * or /"
                );
        }
    }
}