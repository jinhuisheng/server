package com.example.loan.service;

public class LoanPeriod {
    public static int count(Gender gender, int lenderAge, int purchaseHouseAge) {
        int loanPeriod = 65 - lenderAge - purchaseHouseAge;
        if (loanPeriod <= 0) {
            throw new BusinessException("男性主贷款人年龄 + 贷款年限不超过 65");
        }
        return loanPeriod;
    }
}
