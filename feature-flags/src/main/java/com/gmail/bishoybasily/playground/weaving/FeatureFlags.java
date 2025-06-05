package com.gmail.bishoybasily.playground.weaving;

public class FeatureFlags {

  public static final String FEATURE_CALCULATOR_SUBTRACT = "calculator_subtract_feature";

  public static boolean isFeatureEnabled(String feature) {
    return System.getProperty(FEATURE_CALCULATOR_SUBTRACT).equals("true");
  }

  public static boolean isFeatureDisabled(String feature) {
    return !isFeatureEnabled(feature);
  }
}
