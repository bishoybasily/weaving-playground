package com.gmail.bishoybasily.playground.weaving.calculator.aspect;

import static java.lang.System.getProperty;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculatorAspect {

  private final DifferentCalculator differentCalculator;

  public static final String FEATURE_CALCULATOR_SUBTRACT = "calculator_subtract_feature";

  public CalculatorAspect() {
    differentCalculator = new DifferentCalculator();
  }

  @Around(
      """
                    execution(private Integer com.gmail.bishoybasily.playground.weaving.calculator.Calculator.sum(Integer, Integer))
                    &&
                    args(num1, num2)
                    """)
  public Object featureCalculatorSubtract(ProceedingJoinPoint joinPoint, Integer num1, Integer num2)
      throws Throwable {

    if ("false".equals(getProperty(FEATURE_CALCULATOR_SUBTRACT)))
      return joinPoint.proceed(new Object[] {num1, num2});

    return differentCalculator.subtract(num1, num2);
  }
}
