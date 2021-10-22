package com.example.loan.service;

import com.example.loan.controller.LoanPlan;
import com.example.loan.controller.LoanPlanForm;
import com.example.loan.mapper.UserLoanPlanMaterial;
import com.example.loan.mapper.UserLoanPlanMaterialMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanPlanService {
    private UserLoanPlanMaterialMapper userLoanPlanMaterialMapper;


    public LoanPlanService(UserLoanPlanMaterialMapper userLoanPlanMaterialMapper) {
        this.userLoanPlanMaterialMapper = userLoanPlanMaterialMapper;
    }

    public LoanPlan query(LoanPlanForm loanPlanForm) {
        /**
         * 贷款年限规则 -> 最大年限
         * 房产套数贷款规则 -> 最大贷款比例 maxLoanProportion
         *               ->  贷款利率 loanInterestRate
         *
         */
        UserLoanPlanMaterial userLoanPlanMaterial = userLoanPlanMaterialMapper.selectUserLoanPlanMaterial(loanPlanForm.getIdCard());
        int maxLoanPeriod = LoanPeriod.count(userLoanPlanMaterial.getGender(), userLoanPlanMaterial.getLenderAge()
                , userLoanPlanMaterial.getHouseMaterial().getHouseAge());
        BigDecimal maxLoanProportion = maxLoanProportion(loanPlanForm.getIdCard());
        BigDecimal loanInterestRate = getLoanInterestRate(loanPlanForm.getIdCard());
        return new LoanPlan(true, maxLoanProportion, maxLoanPeriod, loanInterestRate);
    }

    private BigDecimal getLoanInterestRate(String idCard) {
        return BigDecimal.valueOf(0.0425);
    }

    private BigDecimal maxLoanProportion(String idCard) {
        return BigDecimal.valueOf(0.7);
    }

    public UserLoanPlanMaterial getUserLoadPlanMaterial(String idCard) {
        UserLoanPlanMaterial userLoanPlanMaterial = userLoanPlanMaterialMapper.selectUserLoanPlanMaterial(idCard);
        userLoanPlanMaterial.loadHouseAndTogetherLender();
        return userLoanPlanMaterial;
    }
}
