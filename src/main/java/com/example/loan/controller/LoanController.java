package com.example.loan.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("loan-plans")
public class LoanController {
    @PostMapping
    public LoanPlan audit(@RequestBody LoanPlanForm loanPlanForm) {
        return new LoanPlan(true, BigDecimal.valueOf(0.7), 30, BigDecimal.valueOf(0.0425));
    }
}
