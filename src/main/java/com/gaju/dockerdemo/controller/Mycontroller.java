package com.gaju.dockerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Mycontroller {

    @GetMapping("/calculator")
    public String showCalculator() {
        return "calculator.html";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(name = "num1") double num1,
                            @RequestParam(name = "num2") double num2,
                            @RequestParam(name = "operator") String operator,
                            Model model) {
        double result = performCalculation(num1, num2, operator);
        model.addAttribute("result", result);
        return "calculator";
    }

    private double performCalculation(double num1, double num2, String operator) {
        switch (operator) {
            case "add":
                return num1 + num2;
            case "subtract":
                return num1 - num2;
            case "multiply":
                return num1 * num2;
            case "divide":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
