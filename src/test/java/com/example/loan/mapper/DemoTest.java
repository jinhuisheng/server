package com.example.loan.mapper;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DemoTest {
    @Test
    public void should_success() {
        int input = 1;
        Integer result = Demo.of(input);
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }
}
