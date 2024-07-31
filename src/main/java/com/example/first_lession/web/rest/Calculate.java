package com.example.first_lession.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Calculate {

    @GetMapping("/calculate")
    public double Calculate(double num1, double num2, char operator){

        switch (operator) {
            case '-':
                return num1 - num2;
            case '+':
                return num1 + num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Khong the chia cho 0");
                }
            default:
                throw new IllegalArgumentException("Phep toan khong hop le: " + operator);
        }
    }
}
