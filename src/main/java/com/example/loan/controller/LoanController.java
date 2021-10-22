package com.example.loan.controller;

import com.example.loan.service.LoanPlanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loan-plans")
public class LoanController {
    private LoanPlanService loanPlanService;

    public LoanController(LoanPlanService loanPlanService) {
        this.loanPlanService = loanPlanService;
    }

    @PostMapping
    public LoanPlan query(@RequestBody LoanPlanForm loanPlanForm) {
        return loanPlanService.query(loanPlanForm);
    }
}
