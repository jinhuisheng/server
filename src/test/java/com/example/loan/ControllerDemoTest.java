package com.example.loan;

import com.example.loan.mapper.Demo;
import com.example.loan.mapper.DemoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest(classes = LoanServerApplication.class)
@Transactional(rollbackFor = TransactionException.class)
public class ControllerDemoTest {
    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void should_return_receipt_when_scan_barcode() throws Exception {
        String result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertThat(result).isEqualTo("hello");
    }

    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        Demo demo = new Demo();
        demo.setName("test");
        demo.setCreatedAt(LocalDateTime.now());
        demo.setUpdatedAt(LocalDateTime.now());
        demoMapper.insert(demo);
        List<Demo> userList = demoMapper.selectList(null);
        assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

}

