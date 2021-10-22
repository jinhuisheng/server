package com.example.loan.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TogetherLender {
    private String togetherLenderIdCard;
    private String togetherLenderName;
    private BigDecimal togetherLenderIncome;
}
