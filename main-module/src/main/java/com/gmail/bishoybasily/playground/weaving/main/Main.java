package com.gmail.bishoybasily.playground.weaving.main;

import com.gmail.bishoybasily.playground.weaving.calculator.Calculator;

public class Main {
  public static void main(String[] args) {
    var calculator = new Calculator();
    System.out.println(calculator.sum("5", "3"));
  }
}
