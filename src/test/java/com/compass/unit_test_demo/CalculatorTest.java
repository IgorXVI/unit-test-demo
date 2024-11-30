package com.compass.unit_test_demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }
}
