package com.example.loan.service;

import com.example.loan.controller.LoanPlan;
import com.example.loan.controller.LoanPlanForm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanPlanService {
    public LoanPlan query(LoanPlanForm loanPlanForm) {
        /**
         * 贷款年限规则 -> 最大年限
         * 房产套数贷款规则 -> 最大贷款比例 maxLoanProportion
         *               ->  贷款利率 loanInterestRate
         *
         */
        int maxLoanPeriod = getMaxLoanPeriod(loanPlanForm.getIdCard());
        BigDecimal maxLoanProportion = maxLoanProportion(loanPlanForm.getIdCard());
        BigDecimal loanInterestRate = getLoanInterestRate(loanPlanForm.getIdCard());
        return new LoanPlan(true, maxLoanProportion, maxLoanPeriod, loanInterestRate);
    }

    private BigDecimal getLoanInterestRate(String idCard) {
        return BigDecimal.valueOf(0.0425);
    }

    private int getMaxLoanPeriod(String idCard) {
        return 30;
    }

    private BigDecimal maxLoanProportion(String idCard) {
        return BigDecimal.valueOf(0.7);
    }
}
