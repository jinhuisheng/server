package com.example.loan.service;

import com.example.loan.mapper.Demo;
import com.example.loan.mapper.DemoMapper;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private ThirdService thirdService;
    private DemoMapper demoMapper;

    public DemoService(ThirdService thirdService, DemoMapper demoMapper) {
        this.thirdService = thirdService;
        this.demoMapper = demoMapper;
    }


    public String sayHello() {
        return thirdService.sayHello();
    }

    public Demo getDemo(String name) {
        return demoMapper.selectDemoByName(name);
    }
}
