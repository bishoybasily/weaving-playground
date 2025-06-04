package com.gmail.bishoybasily.playground.weaving.main;

import com.gmail.bishoybasily.playground.weaving.calculator.Calculator;

public class Main {
  public static void main(String[] args) {

    // System.setProperty("calculator_subtract_feature", "false");

    // feature flag toggle at runtime
    // java -jar -Dcalculator_subtract_feature=false main-module/build/libs/main-module-1.0-SNAPSHOT.jar

    var calculator = new Calculator();
    System.out.println(calculator.sum("5", "3"));
  }
}
