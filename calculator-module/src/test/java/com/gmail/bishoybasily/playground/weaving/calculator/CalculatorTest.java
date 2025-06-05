package com.gmail.bishoybasily.playground.weaving.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gmail.bishoybasily.playground.weaving.FeatureFlags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

class CalculatorTest {

  @Test
  @EnabledIfSystemProperty(named = FeatureFlags.FEATURE_CALCULATOR_SUBTRACT, matches = "false")
  void sum_strings_adds() {
    final var calculator = new Calculator();
    assertEquals(8, calculator.sum("5", "3"));
  }

  @Test
  @EnabledIfSystemProperty(named = FeatureFlags.FEATURE_CALCULATOR_SUBTRACT, matches = "true")
  void sum_strings_subtracts() {
    final var calculator = new Calculator();
    assertEquals(2, calculator.sum("5", "3"));
  }
}
