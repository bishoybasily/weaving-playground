package com.gmail.bishoybasily.playground.weaving.app.dist;

import com.gmail.bishoybasily.playground.weaving.app.DeploymentService;

public class DeploymentServiceDistImpl implements DeploymentService {
  @Override
  public String print() {
    return "I'm the custom deployment service";
  }
}
