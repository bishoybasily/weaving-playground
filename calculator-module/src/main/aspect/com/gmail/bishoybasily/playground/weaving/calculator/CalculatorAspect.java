package com.gmail.bishoybasily.playground.weaving.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculatorAspect {

  private final CalculatorDifferent calculatorDifferent;

  public CalculatorAspect() {
    calculatorDifferent = new CalculatorDifferent();
  }

  @Around(
      """
                    execution(Integer com.gmail.bishoybasily.playground.weaving.calculator.Calculator.sum(Integer, Integer))
                    &&
                    args(num1, num2)
                    """)
  public Object featureCalculatorSubtract(ProceedingJoinPoint joinPoint, Integer num1, Integer num2)
      throws Throwable {

    var target = (Calculator) joinPoint.getThis();
    System.out.printf(
        "Original execution result: %s%n", joinPoint.proceed(new Object[] {num1, num2}));

    return calculatorDifferent.subtract(num1, num2);

    //    return joinPoint.proceed(new Object[] {num1, num2});
  }
}
