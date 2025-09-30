package com.gmail.bishoybasily.playground.weaving.app;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeploymentServiceImpl implements DeploymentService {

  private final JobService jobService;

  @Override
  public void print() {
    System.out.printf("Total jobs are: %d%n", jobService.getNumJobs());
  }
}
