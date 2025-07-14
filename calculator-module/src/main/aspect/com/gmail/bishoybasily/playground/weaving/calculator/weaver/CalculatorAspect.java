package com.gmail.bishoybasily.playground.weaving.calculator.weaver;

import static com.gmail.bishoybasily.playground.weaving.FeatureFlags.FEATURE_CALCULATOR_SUBTRACT;
import static com.gmail.bishoybasily.playground.weaving.FeatureFlags.isFeatureEnabled;

import com.gmail.bishoybasily.playground.weaving.calculator.Calculator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CalculatorAspect {

  private final CalculatorDifferent calculatorDifferent;

  public CalculatorAspect() {
    calculatorDifferent = new CalculatorDifferent();
  }

  @Around("""
          execution(private Integer com.gmail.bishoybasily.playground.weaving.calculator.Calculator.sum(Integer, Integer))
          &&
          args(num1, num2)
          """)
  public Object featureCalculatorSubtract(ProceedingJoinPoint joinPoint, Integer num1, Integer num2)
      throws Throwable {

      var target = (Calculator)joinPoint.getTarget();

      System.out.println(target);

    if (isFeatureEnabled(FEATURE_CALCULATOR_SUBTRACT))
      return calculatorDifferent.subtract(num1, num2);

    return joinPoint.proceed(new Object[] {num1, num2});
  }
}
