package com.example.loan.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseMaterial {
    private Integer houseAge;
    private BigDecimal housePrice;
}
