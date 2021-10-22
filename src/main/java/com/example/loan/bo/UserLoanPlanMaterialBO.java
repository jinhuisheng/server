package com.example.loan.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.loan.service.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoanPlanMaterialBO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String idCard;
    private String name;
    private Gender gender;
    private BigDecimal income;
    private Integer lenderAge;

    private TogetherLenderBO togetherLenderBO;
    private HouseMaterialBO houseMaterialBO;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
