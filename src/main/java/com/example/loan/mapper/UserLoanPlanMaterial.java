package com.example.loan.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.loan.service.Gender;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UserLoanPlanMaterial {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String idCard;
    private String name;
    private Gender gender;
    private BigDecimal income;
    private TogetherLender togetherLender;
    private String togetherLenderIdCard;
    private String togetherLenderName;
    private BigDecimal togetherLenderIncome;
    private HouseMaterial houseMaterial;
    private Integer houseAge;
    private BigDecimal housePrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void loadHouseAndTogetherLender() {
        this.houseMaterial = new HouseMaterial(houseAge, housePrice);
        this.togetherLender = new TogetherLender(togetherLenderIdCard, togetherLenderName, togetherLenderIncome);
    }
}
