package com.example.loan.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanPlan {
    private Boolean canLoan;
    private BigDecimal maxLoanProportion;
    private Integer maxLoanPeriod;
    private BigDecimal loanInterestRate;
}
