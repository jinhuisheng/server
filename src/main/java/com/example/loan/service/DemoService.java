package com.example.loan.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private ThirdService thirdService;

    public DemoService(ThirdService thirdService) {
        this.thirdService = thirdService;
    }


    public String sayHello() {
        return thirdService.sayHello();
    }
}
