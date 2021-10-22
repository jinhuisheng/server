package com.example.loan.controller;

import com.example.loan.LoanServerApplication;
import com.example.loan.mapper.HouseMaterialMapper;
import com.example.loan.mapper.TogetherLenderMapper;
import com.example.loan.mapper.UserLoanPlanMaterialMapper;
import com.example.loan.mapper.entity.HouseMaterialEntity;
import com.example.loan.mapper.entity.TogetherLenderEntity;
import com.example.loan.mapper.entity.UserLoanPlanMaterialEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.example.loan.service.Gender.MALE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = LoanServerApplication.class)
@Transactional(rollbackFor = TransactionException.class)
public class LoanControllerTest {
    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private UserLoanPlanMaterialMapper userLoanPlanMaterialMapper;
    @Autowired
    HouseMaterialMapper houseMaterialMapper;
    @Autowired
    private TogetherLenderMapper togetherLenderEntityMapper;


    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void should_get_loan_plan_success() throws Exception {
        givenLoadPlanMaterialData();
        String requestJson = "{\"idCard\":\"412233333333\",\"loanPeriod\":20}";
        String result = mockMvc.perform(
                        post("/loan-plans")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(result).isEqualTo("{\"canLoan\":true,\"maxLoanProportion\":0.7,\"maxLoanPeriod\":30,\"loanInterestRate\":0.0425}");
    }

    private void givenLoadPlanMaterialData() {
        UserLoanPlanMaterialEntity entity = new UserLoanPlanMaterialEntity();
        entity.setGender(MALE);
        entity.setIncome(BigDecimal.valueOf(10000));
        entity.setLenderAge(35);
        entity.setIdCard("412233333333");
        entity.setName("王一");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        userLoanPlanMaterialMapper.insert(entity);

        HouseMaterialEntity houseMaterialEntity = new HouseMaterialEntity();
        houseMaterialEntity.setLoanPlanMaterialId(entity.getId());
        houseMaterialEntity.setHouseAge(0);
        houseMaterialEntity.setHousePrice(BigDecimal.valueOf(10000));
        houseMaterialMapper.insert(houseMaterialEntity);

        TogetherLenderEntity togetherLenderEntity = new TogetherLenderEntity();
        togetherLenderEntity.setTogetherLenderIdCard("111111111");
        togetherLenderEntity.setTogetherLenderName("xxxx");
        togetherLenderEntity.setTogetherLenderIncome(BigDecimal.valueOf(10000));
        togetherLenderEntity.setLoanPlanMaterialId(entity.getId());
        togetherLenderEntityMapper.insert(togetherLenderEntity);


    }
}
