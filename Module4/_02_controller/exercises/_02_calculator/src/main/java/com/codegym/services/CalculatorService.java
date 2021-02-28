package com.codegym.services;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    double calculate(double number1, double number2, String operator) throws Exception;
}
