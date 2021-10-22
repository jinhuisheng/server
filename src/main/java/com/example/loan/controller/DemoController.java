package com.example.loan.controller;

import com.example.loan.mapper.DemoBO;
import com.example.loan.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }


    @GetMapping
    public DemoBO test() {
        return demoService.getDemo("1");
    }
}
