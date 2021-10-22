package com.example.loan.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoanPeriodTest {

    @Test
    public void 男性主贷款人年龄_贷款年限不超过_65() {
        int loanPeriod = LoanPeriod.count(Gender.MALE, 35, 0);
        assertThat(loanPeriod).isEqualTo(30);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void 男性主贷款人年龄_贷款年限超过_65_报错() {
        expectedException.expect(BusinessException.class);
        expectedException.expectMessage("男性主贷款人年龄 + 贷款年限不超过 65");
        LoanPeriod.count(Gender.MALE, 66, 0);
    }

//    @Test
//    public void 女性主贷款人年龄_贷款年限不超过_60() {
//        int loanPeriod = LoanPeriod.count(Gender.FEMALE, 35, 0);
//        assertThat(loanPeriod).isEqualTo(25);
//    }

}
