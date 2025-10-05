package com.gmail.bishoybasily.playground.weaving.app;

public class DeploymentServiceDistImpl implements DeploymentService {
  @Override
  public void print() {
    System.out.println("I'm the custom deployment service");
  }
}
