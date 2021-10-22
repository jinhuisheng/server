package com.example.loan.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseMaterialBO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer houseAge;
    private BigDecimal housePrice;
}
