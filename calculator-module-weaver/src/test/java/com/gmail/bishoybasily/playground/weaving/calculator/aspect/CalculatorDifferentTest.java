package com.gmail.bishoybasily.playground.weaving.calculator.aspect;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorDifferentTest {

  @Test
  void subtract() {
    final var calculator = new CalculatorDifferent();
    assertEquals(2, calculator.subtract(5, 3));
  }
}
