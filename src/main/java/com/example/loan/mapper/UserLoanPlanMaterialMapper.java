package com.example.loan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserLoanPlanMaterialMapper extends BaseMapper<UserLoanPlanMaterial> {
    UserLoanPlanMaterial selectUserLoanPlanMaterial(String idCard);

    UserLoanPlanMaterial selectByIdCard(String idCard);
}
