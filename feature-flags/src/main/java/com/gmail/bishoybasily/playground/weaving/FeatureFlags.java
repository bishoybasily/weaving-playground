package com.gmail.bishoybasily.playground.weaving;

public class FeatureFlags {

  public static final String FEATURE_CALCULATOR_SUBTRACT = "calculator_subtract_feature";

  public static boolean isFeatureEnabled(String feature) {
    return "true".equals(System.getProperty(feature));
  }

  public static boolean isFeatureDisabled(String feature) {
    return !isFeatureEnabled(feature);
  }

  public static void enable(String feature) {
    System.setProperty(feature, "true");
  }

  public static void disable(String feature) {
    System.setProperty(feature, "false");
  }
}
