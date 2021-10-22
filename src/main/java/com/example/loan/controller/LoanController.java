package com.example.loan.controller;

import com.example.loan.mapper.UserLoanPlanMaterial;
import com.example.loan.service.LoanPlanService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{idCard}")
    public UserLoanPlanMaterial getUserLoadPlanMaterial(@PathVariable String idCard) {
        return loanPlanService.getUserLoadPlanMaterial(idCard);
    }

}
