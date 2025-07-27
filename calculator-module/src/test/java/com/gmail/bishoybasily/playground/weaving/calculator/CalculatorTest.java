package com.gmail.bishoybasily.playground.weaving.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void sum_strings_subtracts() {
    final var calculator = new Calculator();
    assertEquals(2, calculator.add("5", "3"));
  }
}
