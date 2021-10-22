package com.example.loan.service;

import com.example.loan.controller.LoanPlan;
import com.example.loan.controller.LoanPlanForm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanPlanService {
    public LoanPlan query(LoanPlanForm loanPlanForm) {
        BigDecimal maxLoanProportion = BigDecimal.valueOf(0.7);
        int maxLoanPeriod = 30;
        BigDecimal maxLoanInterestRate = BigDecimal.valueOf(0.0425);
        return new LoanPlan(true, maxLoanProportion, maxLoanPeriod, maxLoanInterestRate);
    }
}
