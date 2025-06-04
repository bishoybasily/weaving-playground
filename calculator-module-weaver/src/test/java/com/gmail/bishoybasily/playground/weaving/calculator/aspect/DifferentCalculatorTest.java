package com.gmail.bishoybasily.playground.weaving.calculator.aspect;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DifferentCalculatorTest {

  @Test
  void subtract() {
    final var calculator = new DifferentCalculator();
    assertEquals(2, calculator.subtract(5, 3));
  }
}
