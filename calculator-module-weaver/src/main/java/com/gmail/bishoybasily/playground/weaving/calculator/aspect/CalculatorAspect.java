package com.gmail.bishoybasily.playground.weaving.calculator.aspect;

import static java.lang.System.getProperty;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculatorAspect {

  private final CalculatorDifferent calculatorDifferent;

  public static final String FEATURE_CALCULATOR_SUBTRACT = "calculator_subtract_feature";

  public CalculatorAspect() {
    calculatorDifferent = new CalculatorDifferent();
  }

  @Around(
      """
                    execution(protected final Integer com.gmail.bishoybasily.playground.weaving.calculator.Calculator.sum(Integer, Integer))
                    &&
                    args(num1, num2)
                    """)
  public Object featureCalculatorSubtract(ProceedingJoinPoint joinPoint, Integer num1, Integer num2)
      throws Throwable {

    if ("false".equals(getProperty(FEATURE_CALCULATOR_SUBTRACT)))
      return joinPoint.proceed(new Object[] {num1, num2});

    return calculatorDifferent.subtract(num1, num2);
  }
}
