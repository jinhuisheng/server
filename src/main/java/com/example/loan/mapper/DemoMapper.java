package com.example.loan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface DemoMapper extends BaseMapper<DemoBO> {
    DemoBO selectDemoByName(String name);
}
