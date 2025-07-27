package com.gmail.bishoybasily.playground.weaving.calculator;

public class Calculator {

  public Integer add(String param1, String param2) {

    Integer num1 = Integer.parseInt(param1);
    Integer num2 = Integer.parseInt(param2);

    return sum(num1, num2);
  }

  Integer sum(Integer num1, Integer num2) {
    return num1 + num2;
  }
}
