package com.example.loan.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.loan.bo.HouseMaterialBO;
import com.example.loan.bo.TogetherLenderBO;
import com.example.loan.bo.UserLoanPlanMaterialBO;
import com.example.loan.service.Gender;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("user_loan_plan_material")
public class UserLoanPlanMaterialEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String idCard;
    private String name;
    private Gender gender;
    private BigDecimal income;
    private Integer lenderAge;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserLoanPlanMaterialBO toBO(HouseMaterialEntity houseMaterialEntity, TogetherLenderEntity togetherLenderEntity) {
        HouseMaterialBO houseMaterialBO = HouseMaterialBO.builder()
                .houseAge(houseMaterialEntity.getHouseAge())
                .housePrice(houseMaterialEntity.getHousePrice())
                .id(houseMaterialEntity.getId())
                .build();
        TogetherLenderBO togetherLenderBO = TogetherLenderBO.builder()
                .togetherLenderIdCard(togetherLenderEntity.getTogetherLenderIdCard())
                .togetherLenderIncome(togetherLenderEntity.getTogetherLenderIncome())
                .id(togetherLenderEntity.getId())
                .build();
        return UserLoanPlanMaterialBO.builder()
                .id(this.id)
                .idCard(idCard)
                .name(name)
                .gender(gender)
                .income(income)
                .lenderAge(lenderAge)
                .houseMaterialBO(houseMaterialBO)
                .togetherLenderBO(togetherLenderBO)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}

