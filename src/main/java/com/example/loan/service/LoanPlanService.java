package com.example.loan.service;

import com.example.loan.bo.UserLoanPlanMaterialBO;
import com.example.loan.controller.LoanPlan;
import com.example.loan.controller.LoanPlanForm;
import com.example.loan.dao.UserLoanPlanMaterialDAO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanPlanService {
    private UserLoanPlanMaterialDAO userLoanPlanMaterialDAO;


    public LoanPlanService(UserLoanPlanMaterialDAO userLoanPlanMaterialDAO) {
        this.userLoanPlanMaterialDAO = userLoanPlanMaterialDAO;
    }

    public LoanPlan query(LoanPlanForm loanPlanForm) {
        /**
         * 贷款年限规则 -> 最大年限
         * 房产套数贷款规则 -> 最大贷款比例 maxLoanProportion
         *               ->  贷款利率 loanInterestRate
         *
         */
        UserLoanPlanMaterialBO userLoanPlanMaterial = userLoanPlanMaterialDAO.selectUserLoanPlanMaterial(loanPlanForm.getIdCard());
        int maxLoanPeriod = LoanPeriod.count(userLoanPlanMaterial.getGender(), userLoanPlanMaterial.getLenderAge()
                , userLoanPlanMaterial.getHouseMaterialBO().getHouseAge());
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

    public UserLoanPlanMaterialBO getUserLoadPlanMaterial(String idCard) {
        UserLoanPlanMaterialBO userLoanPlanMaterial = userLoanPlanMaterialDAO.selectUserLoanPlanMaterial(idCard);
        return userLoanPlanMaterial;
    }
}
