package com.gmail.bishoybasily.playground.weaving.main;

import com.gmail.bishoybasily.playground.weaving.calculator.Calculator;

import static com.gmail.bishoybasily.playground.weaving.FeatureFlags.FEATURE_CALCULATOR_SUBTRACT;
import static com.gmail.bishoybasily.playground.weaving.FeatureFlags.enable;

public class Main {
    public static void main(String[] args) {

        enable(FEATURE_CALCULATOR_SUBTRACT);

        var calculator = new Calculator();
        System.out.println(calculator.add("5", "3"));
    }
}
